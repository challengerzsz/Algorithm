package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 15:15
 */
public class T881 {

    // 救生艇 每次装2个 2人体重不能超过limit
    // 贪心 先装体重等于limit的人 之后才有可能能装下体重最小的人
    public int numRescueBoats(int[] people, int limit) {
        // 排序后双指针
        int res = 0;
        Arrays.sort(people);
        int i = 0, j = people.length - 1;
        while (i <= j) {
            if (people[j] == limit) {
                res++;
                j--;
            } else {
                if (people[i] + people[j] <= limit) {
                    res++;
                    i++;
                    j--;
                } else {
                    res++;
                    j--;
                }
            }
        }
        return res;
    }
}
