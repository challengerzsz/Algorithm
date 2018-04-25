package com.bsb.str;

public class StrSolution {
    //字符串替换
    public String replaceSpace(StringBuffer str) {
        String strR = String.valueOf(str);
        String newStr = strR.replace(" ", "%20");

        return newStr;
    }
    //左旋字符串
    public String LeftRotateString(String str,int n) {

        if (n > str.length()) return "";
        String temp = str.substring(0, n);

        return str.substring(n, str.length()) + temp;
    }

}
