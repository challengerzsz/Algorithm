package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizright
 * @date : 2020-02-10 16:33
 */
public class T948 {

    // 令牌放置
    // 把这题一开始想复杂了 
    // 其实就是在有能量的时候尽量去翻耗能最小的牌赚分 没能量的时候用分去反向翻最大能量的牌
    // 最大分数肯定是最后一次翻正面牌获得分数后得到
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        int left = 0, right = tokens.length - 1;
        int points = 0, ans = 0;
        // 只有在剩余能量大于最小能耗牌而且分数不为零的时候去执行翻牌操作 要不然就不符合题目要求的翻牌条件
        while (left <= right && (P >= tokens[left] || points > 0)) {
            while (left <= right && P >= tokens[left]) {
                P -= tokens[left++];
                points++;
            }

            // 正面翻牌之后更新最大分数
            ans = Math.max(ans, points);
            if (left <= right && points > 0) {
                P += tokens[right--];
                points--;
            }
        }

        return ans;
    }
}
