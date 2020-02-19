package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-18 21:32
 */
public class T1090 {

    // 从values中找num_wanted个数 并且这些数字出现的相同标签不能够超过use_limit
    // 取得数字需要保证最大和
    public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        if (num_wanted == 0 || use_limit == 0) {
            return 0;
        }
        int len = values.length;
        // 封装value - label的对
        int[][] pairs = new int[len][2];
        for (int i = 0; i < len; i++) {
            pairs[i][0] = values[i];
            pairs[i][1] = labels[i];
        }
        // 按照 value 降序排列
        Arrays.sort(pairs, (o1, o2) -> o2[0] - o1[0]);
        // 记录当前label选择的数量
        // max{label} = 20000
        int[] numLabel = new int[20001];
        int res = 0;
        // 记录选择的总数 |S|
        int count = 0;
        for (int i = 0; i < len; i++) {
            int lab = pairs[i][1];
            if (numLabel[lab] >= use_limit)
                continue;
            res += pairs[i][0];
            numLabel[lab]++;
            count++;
            if (count >= num_wanted)
                return res;
        }
        return res;

    }
}
