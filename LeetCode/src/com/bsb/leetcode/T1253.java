package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 21:37
 */
public class T1253 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        int sum = 0;
        // 确定的数量
        int certain = 0;
        // 只有列的和为0 和 2的列能够先被确定下来
        for (int i : colsum) {
            sum += i;
            if (i == 2) certain++;
        }
        List<List<Integer>> res = new ArrayList<>();
        // 不合法条件 1的个数超过upper和lower的和 或者每一行的数量不够确定下来的1
        if (sum != upper + lower || upper < certain || lower < certain) return res;
        res.add(new ArrayList<>());
        res.add(new ArrayList<>());
        // 减掉确定的数量
        upper -= certain;
        lower -= certain;
        // 先填充upper 剩余的填充lower
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    res.get(0).add(1);
                    res.get(1).add(0);
                    upper--;
                } else {
                    res.get(0).add(0);
                    res.get(1).add(1);
                    lower--;
                }
            } else if (colsum[i] == 2) {
                res.get(0).add(1);
                res.get(1).add(1);
            } else {
                res.get(0).add(0);
                res.get(1).add(0);
            }
        }
        return res;
    }
}
