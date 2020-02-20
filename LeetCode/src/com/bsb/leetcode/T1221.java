package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 20:34
 */
public class T1221 {

    // 分割平衡字符串
    public int balancedStringSplit(String s) {
        // 思路其实很简单 贪心的策略就是尽量划分最小长度的平衡串
        // s串本来就是平衡的
        int res = 0;
        int RCount = 0, LCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                RCount++;
            } else if (s.charAt(i) == 'L') {
                LCount++;
            }
            if (RCount == LCount) {
                res++;
                RCount = 0;
                LCount = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new T1221().balancedStringSplit("LLLLRRRR"));
    }
}
