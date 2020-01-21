package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-21 21:19
 */
public class T204 {

    public int CountPrimes(int n) {
        // 厄拉多塞筛法
        // 基本思路 例如统计1～n之间的素数个数
        // 选择2 排除2～n之间2的倍数 以此类推 3的倍数 5的倍数 最后留下的肯定是素数
        int count = 0;
        boolean[] signs = new boolean[n];
        for (int i = 2; i < n; i++) {
            if (!signs[i]) {
                count++;
                for (int j = i + i; j < n; j += i) {
                    // 排除不是质数的数
                    signs[j] = true;
                }
            }
        }
        return count;
    }
}
