package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2019-07-07 10:52
 */
public class T135 {

    public int candy(int[] ratings) {
        int tang[] = new int[ratings.length];
        Arrays.fill(tang, 1);
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                tang[i] = tang[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                tang[i] = Math.max(tang[i], tang[i + 1]);
            }
        }

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += tang[i];
        }

        return sum;
    }

    public int fbnq(int n) {
        int i = 1, j = 1;
        int ans = 0;
        if (n == 1 || n == 2) {
            return 1;
        }
        for (int t = 1; t < n - 1; t++) {
            ans = i + j;
            i = j;
            j = ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new T135().fbnq(5));
    }
}
