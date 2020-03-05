package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-05 11:52
 */
public class T1103 {

    // 分糖果II
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int count = 1;
        while (candies != 0) {
            for (int i = 0; i < num_people; i++) {
                if (candies < count) {
                    res[i] += candies;
                    candies = 0;
                    break;
                }
                res[i] += count;
                candies -= count;
                count++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new T1103().distributeCandies(7, 4);
    }
}
