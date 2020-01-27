package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-27 19:55
 */
public class T118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }

        if (numRows == 1) {
            res.add(new ArrayList<>());
            // 杨辉三角的顶点为1 因为res是每一行的数据所以add 1
            res.get(0).add(1);
            return res;
        }

        res = generate(numRows - 1);
        List<Integer> row = new ArrayList<>();
        // 首部的1
        row.add(1);
        for (int j = 1; j < numRows - 1; j++) {
            // 某个需要计算的节点值的计算
            row.add(res.get(numRows - 2).get(j - 1) + res.get(numRows - 2).get(j));
        }
        // 尾部的1
        row.add(1);
        res.add(row);
        return res;
    }
}
