package com.bsb.leetcode.contest.may_second;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-08 10:56
 */
public class T5353 {

    // 点亮灯泡III
    public int numTimesAllBlue(int[] light) {
        int res = 0;
        int count = 0;
        // count记录当前点亮的最大编号的灯
        for (int i = 0; i < light.length; i++) {
            count = Math.max(count, light[i]);
            // 证明[0,i]之间的灯都亮了 都可以变成蓝色的灯
            if (count == i + 1) res++;
        }
        return res;
    }
}
