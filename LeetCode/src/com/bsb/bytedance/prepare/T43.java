package com.bsb.bytedance.prepare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-20 09:56
 */
public class T43 {

    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) return "0";
        StringBuilder sb = new StringBuilder(num1);
        num1 = sb.reverse().toString();
        sb = new StringBuilder(num2);
        num2 = sb.reverse().toString();

        if (num1.length() < num2.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }

        long level;
        long carry = 0;
        int index = 0;
        long sum = 0;
        long mul;
        for (int count = 1; count <= num2.length(); count++) {
            level = count - 1;
            for (int i = 0; i < num1.length(); i++) {
                mul = (num1.charAt(i) - '0') * (num2.charAt(index) - '0') + carry;
                carry = mul / 10;
                sum = sum + ((mul % 10) * ((long) Math.pow(10, level)));
                level++;
            }
            if (carry != 0) {
                sum = sum + (carry * ((long) Math.pow(10, level)));
            }
            carry = 0;
            index++;
        }
        return sum + "";
    }

    public String multiply2(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        // 保存计算结果
        String res = "0";

        // num2 逐位与 num1 相乘
        for (int i = num2.length() - 1; i >= 0; i--) {
            int carry = 0;
            // 保存 num2 第i位数字与 num1 相乘的结果
            StringBuilder temp = new StringBuilder();
            // 补 0
            for (int j = 0; j < num2.length() - 1 - i; j++) {
                temp.append(0);
            }
            int n2 = num2.charAt(i) - '0';

            // num2 的第 i 位数字 n2 与 num1 相乘
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {
                int n1 = j < 0 ? 0 : num1.charAt(j) - '0';
                int product = (n1 * n2 + carry) % 10;
                temp.append(product);
                carry = (n1 * n2 + carry) / 10;
            }
            // 将当前结果与新计算的结果求和作为新的结果
            res = addStrings(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * 对两个字符串数字进行相加，返回字符串形式的和
     */
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            builder.append(sum);
            carry = (x + y + carry) / 10;
        }
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new T43().multiply("123456789", "987654321"));
    }
}
