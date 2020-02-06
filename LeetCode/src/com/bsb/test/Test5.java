package com.bsb.test;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-06 15:26
 */
public class Test5 {

    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public int numTrees2(int n) {
        if (n == 0) {
            return 0;
        }
        return helper(1, n);

    }

    private int helper(int start, int end) {
        int ans = 0;
        // 此时没有数字，只有一个数字,返回 1
        if (start >= end) {
            return 1;
        }
        // 尝试每个数字作为根节点
        for (int i = start; i <= end; i++) {
            // 得到所有可能的左子树
            int left = helper(start, i - 1);
            // 得到所有可能的右子树
            int right = helper(i + 1, end);
            // 左子树右子树两两组合 这里是笛卡尔积 不是加法
            ans += left * right;
        }
        return ans;
    }

    public static void main(String[] args) {
        new Test5().numTrees(5);
    }
}
