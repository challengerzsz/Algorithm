package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 09:51
 */
public class T122 {

    // 第二种股票问题 可以多次买卖 但第二次买前必须售出
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int[] tag = new int[prices.length];
        boolean flag = false;
        if (prices.length == 1) {
            tag[0] = -1;
            flag = true;
        }
        for (int i = 0; i < prices.length && !flag; i++) {
            if (i == 0) {
                if (prices[1] >= prices[0]) tag[0] = -1;
                else if (prices[1] < prices[0]) tag[0] = 1;
                continue;
            }
            if (i == prices.length - 1) {
                if (prices[i - 1] <= prices[i]) tag[i] = 1;
                if (prices[i - 1] > prices[i]) tag[i] = -1;
                continue;
            }
            // 标记 每个谷底
            if (prices[i + 1] >= prices[i] && prices[i - 1] >= prices[i]) tag[i] = -1;
            // 标记每个顶峰
            if (prices[i + 1] <= prices[i] && prices[i - 1] <= prices[i]) tag[i] = 1;
        }

        int index = 0;
        int count = 0;
        while (index < tag.length) {
            if (tag[index] == 0) {
                index++;
                continue;
            }
            if (tag[index] == -1) {
                int j = index;
                while (j < tag.length && tag[j] < 1) j++;
                if (j < tag.length) count += (prices[j] - prices[index]);
                else break;
            }
            index++;
        }
        return count;
    }

    public int maxProfit2(int[] prices) {
        int i = 0;
        int valley = prices[0];
        int peak = prices[0];
        int max = 0;
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                i++;
            valley = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                i++;
            peak = prices[i];
            max += peak - valley;
        }
        return max;
    }

    // 这个解法有点巧妙 只要在上升区间 后一天比前一天的售价高 那么就可以求和 这个和刚好等于这个上升区间的低谷到这个上升区间peak的差值
    public int maxProfit3(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array = {2, 2, 5};
        System.out.println(new T122().maxProfit(array));
    }
}
