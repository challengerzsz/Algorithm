package com.bsb.leetcode.contest.twentith_double;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 22:30
 */
public class T5323 {

    public int[] sortByBits(int[] arr) {
        List<Integer> res = new ArrayList<>();
        for (int temp : arr) res.add(temp);

        Collections.sort(res, (o1, o2) -> {
            int temp1 = o1;
            int temp2 = o2;
            int count1 = 0;
            while (o1 != 0) {
                if ((o1 & 1) == 1) count1++;
                o1 = o1 >> 1;
            }
            int count2 = 0;
            while (o2 != 0) {
                if ((o2 & 1) == 1) count2++;
                o2 = o2 >> 1;
            }
            return count1 == count2 ? temp1 - temp2 : count1 - count2;
        });
        int i = 0;
        for (int temp : res) {
            arr[i] = temp;
            i++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] array = {1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1};
        new T5323().sortByBits(array);
    }
}
