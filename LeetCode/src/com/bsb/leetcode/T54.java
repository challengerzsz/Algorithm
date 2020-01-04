package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-04 13:20
 */
public class T54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix == null) return res;
        int lie = matrix[0].length;
        int hang = matrix.length;

        if (hang == 0 || lie == 0) return res;

        int left = 0, top = 0, right = lie - 1, bottom = hang - 1;
        while (left <= right && top <= bottom) {
            // left to right
            for (int i = left; i <= right; ++i) res.add(matrix[top][i]);
            // top to bottom
            for (int i = top + 1; i <= bottom; ++i) res.add(matrix[i][right]);
            // right to left
            if (top != bottom)
                for (int i = right - 1; i >= left; --i) res.add(matrix[bottom][i]);
            // bottom to top
            if (left != right)
                for (int i = bottom - 1; i > top; --i) res.add(matrix[i][left]);
            left++;
            top++;
            right--;
            bottom--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] m = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new T54().spiralOrder(m);
    }
}
