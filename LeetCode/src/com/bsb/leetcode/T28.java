package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-31 10:34
 */
public class T28 {

    // 时间效率很低 应该是想考察kmp之类的字符串匹配算法
    public int strStr(String haystack, String needle) {
        if (haystack == null) return -1;
        if (needle == null || needle.trim().length() == 0) return 0;
        int index, j;
        for (int i = 0; i < haystack.length(); i++) {
            index = 0;
            if (haystack.charAt(i) == needle.charAt(index)) {
                j = i;
                while (index < needle.length() && j < haystack.length()) {
                    if (needle.charAt(index) != haystack.charAt(j)) break;
                    j++;
                    index++;
                }
                if (index > needle.length()) return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        new T28().strStr("mississippi", "issip");
    }
}
