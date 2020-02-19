package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-19 10:41
 */
public class T765 {

    // 情侣牵手
    // N对情侣
    // 情侣关系为(0, 1) (2N - 2, 2N - 1)
    // 最少交换的次数
    public int minSwapsCouples(int[] row) {
        int res = 0;
        for (int i = 0; i < row.length; i += 2) {
            // 这里用异或1来做是(n, n + 1)这个对还是(n + 1, n)这种对
            if (row[i + 1] == (row[i] ^ 1)) continue;
            res++;
            for (int j = i + 1; j < row.length; ++j) {
                if (row[j] == (row[i] ^ 1)) {
                    row[j] = row[i + 1];
                    row[i + 1] = row[i] ^ 1;
                    break;
                }
            }
        }
        return res;
    }
}
