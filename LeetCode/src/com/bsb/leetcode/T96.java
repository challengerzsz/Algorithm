package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-04 15:01
 */
public class T96 {

    // 不同的二叉搜索树
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                // 笛卡尔集 因为对于某个root顶点来说 可能的左右子树的不同结果应该做乘法计算最后结果
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
