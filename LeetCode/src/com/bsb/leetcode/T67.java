package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-20 14:02
 */
public class T67 {

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) return b;
        if (b == null || b.length() == 0) return a;

        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        // 总思路就是模拟进位进行加法运算
        int c = 0;  // 进位
        while (i >= 0 || j >= 0) {
            if (i >= 0) c += a.charAt(i--) - '0';
            if (j >= 0) c += b.charAt(j--) - '0';
            stb.append(c % 2);
            c >>= 1;
        }

        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;
    }

    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        new T67().addBinary(a, b);
    }
}
