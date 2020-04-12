package com.bsb.kuaishou.perpare;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-12 10:46
 */
public class T521 {

    public int findLUSlength(String a, String b) {
        if (a.equals(b)) return -1;
        return a.length() > b.length() ? a.length() : b.length();
    }
}
