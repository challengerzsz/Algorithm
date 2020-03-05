package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-05 12:00
 */
public class T135 {

    // hard 分发糖果
    // dp1从左到右扫 dp2从右到左
    // 统计dp1 dp2的最大值求和
    // 这题思路就是说对于dp1来说每个位置的糖果都是大于等于左边的小朋友的
    // 对于dp2来说每个位置的糖果都是大于等于右边的小朋友的
    // max(dp1[i], dp2[i])的结果就是当前小朋友既符合左边又符合右边的情况
    public int candy(int[] ratings) {
        int[] dp1 = new int[ratings.length];
        int[] dp2 = new int[ratings.length];

        dp1[0] = 1;
        dp2[ratings.length - 1] = 1;
        for (int i = 1; i < ratings.length; i++) {
            dp1[i] = ratings[i] > ratings[i - 1] ? dp1[i - 1] + 1 : 1;
            dp2[ratings.length - 1 - i] =
                    ratings[ratings.length - 1 - i] > ratings[ratings.length - i] ? dp2[ratings.length - i] + 1 : 1;
        }

        int res = 0;
        for (int i = 0; i < ratings.length; i++) {
            res += Math.max(dp1[i], dp2[i]);
        }

        return res;
    }
}
