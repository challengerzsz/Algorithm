package com.bsb.leetcode;

import sun.applet.Main;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-02 20:10
 */
public class T42 {

    // 接雨水 等等做
    // 左右扫描
    public int trap(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            int l = 0, r = 0;
            for (int j = i; j >= 0; j--) {
                l = Math.max(l, height[j]);
            }
            for (int j = i; j < height.length; j++) {
                r = Math.max(r, height[j]);
            }
            res += Math.min(l, r) - height[i];
        }
        return res;
    }

    public int trapByDP(int[] height) {
        if (height == null) return 0;
        int ans = 0;
        int[] l = new int[height.length], r = new int[height.length];
        l[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            l[i] = Math.max(height[i], l[i - 1]);
        }
        r[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            r[i] = Math.max(height[i], r[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(l[i], r[i]) - height[i];
        }
        return ans;
    }
}
