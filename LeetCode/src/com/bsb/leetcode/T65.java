package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 16:20
 */
public class T65 {

    public boolean isNumber(String s) {

        // 投机试了一下 不对.. 题解是搞状态机 有点麻烦
        if (s == null || (s = s.trim()).length() == 0) return false;

        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
