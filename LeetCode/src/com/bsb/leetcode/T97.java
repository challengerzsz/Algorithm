package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-04 15:38
 */
public class T97 {

    public boolean isInterleave(String s1, String s2, String s3) {
        return helper(s1, 0, s2, 0, "", s3);
    }

    // 选取s1和s2的部分进行组合 和s3进行比较
    public boolean helper(String s1, int i, String s2, int j, String res, String s3) {
        if (res.equals(s3) && i == s1.length() && j == s2.length())
            return true;
        boolean ans = false;
        if (i < s1.length())
            ans |= helper(s1, i + 1, s2, j, res + s1.charAt(i), s3);
        if (j < s2.length())
            ans |= helper(s1, i, s2, j + 1, res + s2.charAt(j), s3);
        return ans;

    }

    
}
