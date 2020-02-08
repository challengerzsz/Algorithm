package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-08 21:52
 */
public class T455 {


    // 优先用小饼干满足小需求的孩子
    public int findContentChildren(int[] g, int[] s) {
        if (g == null || s == null) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int childCount = 0, cookieCount = 0;
        while (childCount < g.length && cookieCount < s.length) {
            if (g[childCount] <= s[cookieCount]) {
                childCount++;
            }
            cookieCount++;
        }
        return childCount;
    }


}
