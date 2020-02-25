package com.bsb.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-25 21:07
 */
public class T354 {

    // 俄罗斯套娃信封？ 这是个毛问题...
    // [w, h]表示宽度和高度的大小 如果w2 > w1 && h2 > h1那么就可以把信封1装进信封2
    // 最多能套多少个
    // O(n^2) 28%
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if (n < 1) return 0;
        int max = 1;
        // dp[i]表示 第i个信封中能套别的信封的个数(加上自己 => + 1)
        int[] dp = new int[n];
        // 这里初始化为全1 因为自己套自己也算一种.. 至少样例输出是这样的
        Arrays.fill(dp, 1);
        // 将信封数组按照宽度升序排序
        Arrays.sort(envelopes, Comparator.comparingInt(a -> a[0]));
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                // 能不能装下之前的某个信封 再去dp数组找之前某个信封能装下别的信封的数量
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public int maxEnvelopes2(int[][] envelopes) {
        int max = 0;
        int[] dp = new int[envelopes.length];
        // 按照信封的宽度排序 如果宽度相等 高度按降序排列
        Arrays.sort(envelopes, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));

        // 这个思路是借鉴评论区的
        // 将这个问题转换成最长连续递增序列的长度来计算
        for (int[] temp : envelopes) {
            int left = 0, right = max;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < temp[1])
                    left = mid + 1;
                else
                    right = mid;
            }
            dp[left] = temp[1];
            if (left == max)
                max++;
        }
        return max;
    }
}
