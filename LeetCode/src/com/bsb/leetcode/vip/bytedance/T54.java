package com.bsb.leetcode.vip.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 21:13
 */
public class T54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return res;
        int lie = matrix[0].length;
        int hang = matrix.length;

        if (hang == 0 || lie == 0) return res;

        int left = 0, top = 0, right = lie - 1, bottom = hang - 1;
        while (left <= right && top <= bottom) {


            for (int i = left; i <= right; ++i) res.add(matrix[top][i]);
            for (int i = top + 1; i <= bottom; ++i) res.add(matrix[i][right]);
            if (top != bottom) for (int i = right - 1; i >= left; --i) res.add(matrix[bottom][i]);
            if (left != right) for (int i = bottom - 1; i > top; --i) res.add(matrix[i][left]);
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        new T54().spiralOrder(new int[][]{{1}, {5}, {8}});
    }
}
