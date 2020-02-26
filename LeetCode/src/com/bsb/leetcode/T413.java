package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-26 21:07
 */
public class T413 {

    // 等差数列划分
    // 将数组划分为等差数列
    // 暴力
    public int numberOfArithmeticSlices(int[] A) {
        int count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            // distance => 等差数列公差
            int distance = A[i + 1] - A[i];
            // 这里是因为题目要求 每两个分割之间必须隔一个
            for (int j = i + 2; j < A.length; j++) {
                int k;
                for (k = i + 1; k <= j; k++)
                    if (A[k] - A[k - 1] != distance)
                        break;
                if (k > j)
                    count++;
            }
        }
        return count;
    }

    // 对于第 i 个元素，判断这个元素跟前一个元素的差值是否和等差数列中的差值相等
    // 如果相等，那么新区间中等差数列的个数即为 1 + dp[i - 1]
    public int numberOfArithmeticSlicesByDp(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }

}
