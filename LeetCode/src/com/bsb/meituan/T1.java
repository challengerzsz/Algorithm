package com.bsb.meituan;
import java.util.Scanner;

public class T1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        String numberStr = input.substring(1, input.length() - 1);
        String[] numberStrArray = numberStr.split(",");
        for (String number : numberStrArray) {
            String s = number2Chn(number);
            stringBuilder.append(s);
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }
    public static String number2Chn(String number) {
        String[] hanziArray = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] danwei1Array = {"", "拾", "佰", "仟"};
        String[] danwei2Array = {"", "万", "亿", "万亿"};
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        String[] numberArray = number.split("\\.");
        long zhengshu = Long.parseLong(numberArray[0]);
        String xiaoshu = numberArray[1];
        int danwei2Pos = (int) (zhengshu % 10000);
        if (zhengshu != 0) {
            for (int i = 0; zhengshu != 0 && i < 4; i++) {
                if (danwei2Pos == 0) {
                    if (stringBuilder.length() > 0 && !stringBuilder.substring(0, 1).equals("零")) {
                        stringBuilder.insert(0, "零");
                    }
                    zhengshu = zhengshu / 10000;
                    danwei2Pos = (int)(zhengshu % 10000);
                    continue;
                }
                stringBuilder.insert(0, danwei2Array[i]);
                int danwei1Pos = (int) (danwei2Pos % 10);
                for (int j = 0; j < 4; j++) {
                    if (danwei1Pos == 0) {
                        if (stringBuilder.length() > 0 && !stringBuilder.substring(0, 1).equals("零")
                                && !stringBuilder.substring(0, 1).equals(danwei2Array[i])) {
                            stringBuilder.insert(0, "零");
                        } else {
                            stringBuilder.insert(0, hanziArray[danwei1Pos] + danwei1Array[j]);
                        }
                        danwei2Pos = danwei2Pos / 10;
                        danwei1Pos = danwei2Pos % 10;
                    }
                    zhengshu = zhengshu / 10000;
                    danwei2Pos = (int)(zhengshu % 10000);
                }
                if (stringBuilder.length() > 0 && stringBuilder.substring(0,1).equals("零")) {
                    stringBuilder = new StringBuilder(stringBuilder.substring(1));
                    stringBuilder.append("元");
                    if (numberArray.length < 2) {
                        return stringBuilder.append("整").toString();
                    }
                    if (xiaoshu.length() == 1) {
                        xiaoshu += "0";
                    }
                    int num2 = Integer.parseInt(xiaoshu);
                    if (num2 == 0) {
                        stringBuilder.append("整");
                    }
                    int a = num2 / 10;
                    int b = num2 % 10;
                    stringBuilder.append(hanziArray[a]);
                    if (a != 0) {
                        stringBuilder.append("角");
                    }
                    if (b != 0) {
                        stringBuilder.append(hanziArray[b]).append("分");
                    }
                    return stringBuilder.toString();
                } else {
                    if (xiaoshu.length() == 1) {
                        xiaoshu += "0";
                    }
                    int num2 = Integer.parseInt(xiaoshu);
                    if (num2 == 0) {
                        return stringBuilder.append("零").toString();
                    }
                    int a = num2 / 10;
                    int b = num2 % 10;
                    if (a != 0) {
                        stringBuilder.append(hanziArray[a]);
                        stringBuilder.append("角");
                    }
                    if (b != 0) {
                        stringBuilder.append(hanziArray[b]).append("分");
                    }
                    return stringBuilder.toString();
                }
            }
        }
        return stringBuilder.toString();
    }
}