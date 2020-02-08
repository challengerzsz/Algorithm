package com.bsb.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-08 21:11
 */
public class T452 {

    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int cur = points[0][1];
        int count = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= cur) continue;
            count++;
            cur = points[i][1];
        }
        return count;
    }


    public static void main(String[] args) {
        int[][] array = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
        System.out.println(new T452().findMinArrowShots(array));
    }
}
