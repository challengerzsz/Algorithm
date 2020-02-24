package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-24 18:22
 */
public class T733 {

    // 图像渲染
    // 从[sr, sc]开始渲染 渲染规则是将和它上下左右相邻的4个方向值相等的点开始向外继续渲染为newColor
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) return null;
        helper(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void helper(int[][] image, int sr, int sc, int newColor, int target) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length ||
                image[sr][sc] != target || image[sr][sc] == newColor) return;

        image[sr][sc] = newColor;
        for (int[] direction : directions) {
            helper(image, sr + direction[0], sc + direction[1], newColor, target);
        }
    }
}
