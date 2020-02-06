package com.bsb.test;

import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-06 14:52
 */
public class Test3 {

    public int findMinPath(int[][] road) {
        if (road == null || road.length == 0) return 0;
        int[][] dp = new int[road.length][road[0].length];
        dp[0][0] = road[0][0];
        for (int i = 1; i < road[0].length; i++) {
            dp[0][i] = road[0][i] + dp[0][i - 1];
        }
        for (int i = 1; i < road.length; i++) {
            dp[i][0] = dp[i - 1][0] + road[i][0];
        }

        for (int i = 1; i < road.length; i++) {
            for (int j = 1; j < road[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + road[i][j];
            }
        }

        return dp[road.length - 1][road[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] array = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Test3().findMinPath(array));
    }
}
