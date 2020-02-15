package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-15 20:41
 */
public class T401 {

    // 二进制手表
    // 二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）
    // 反向暴力解 暴力00:00 ~ 11:59的所有时间
    // 寻找那个二进制1的个数等于num的
    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                if (helper(i) + helper(j) == num) res.add(i + ":" + (j < 10 ? "0" + j : j));
            }
        }
        return res;
    }

    private int helper(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

}
