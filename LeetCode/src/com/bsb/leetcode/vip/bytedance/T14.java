package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-13 22:18
 */
public class T14 {

    // 最长公共前缀
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String cur = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(cur) != 0) {
                cur = cur.substring(0, cur.length() - 1);
                if (cur.length() == 0) return "";
            }
        }
        return cur;
    }
}
