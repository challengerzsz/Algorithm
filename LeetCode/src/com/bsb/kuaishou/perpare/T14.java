package com.bsb.kuaishou.perpare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-12 10:39
 */
public class T14 {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(str) != 0) {
                str = str.substring(0, str.length() - 1);
            }
        }

        return str;
    }

    public static void main(String[] args) {
//        System.out.println("1".substring(0, 0));
        new T14().longestCommonPrefix(new String[]{"a", "b"});
    }
}
