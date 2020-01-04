package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-04 13:01
 */
public class T70 {

    // 直接递归 重复计算太多 超时
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if (n <= 1)
            return 1;
        else if (n == 2)
            return 2;
        else {
            int res = 0;
            int i = 1, j = 2;
            int k = 3;
            while (k <= n) {
                res = i + j;
                i = j;
                j = res;
                k++;
            }
            return res;
        }
    }
}
