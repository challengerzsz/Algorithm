package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-04 16:10
 */
public class T58 {

    public int lengthOfLastWord(String s) {
        String[] strs = s.split(" ");
        if (strs.length == 0) return 0;
        return strs[strs.length - 1].length();
    }

}
