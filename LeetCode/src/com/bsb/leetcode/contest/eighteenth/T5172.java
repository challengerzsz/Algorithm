package com.bsb.leetcode.contest.eighteenth;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-23 10:42
 */
public class T5172 {

    public String largestMultipleOfThree(int[] digits) {
        List<Integer> list = new ArrayList<>();
        for (int temp : digits) list.add(temp);
        list.sort((o1, o2) -> o2 - o1);
        StringBuilder res = new StringBuilder();
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            res.append(list.get(i));
            sum += list.get(i);
        }
        if (sum % 3 == 0) return res.toString();

        int i = list.size() - 1;
        if (sum % 3 != 0) {
            for (; i >= 0; i++) {
                sum -= list.get(i);
                if (sum % 3 == 0) {
                    break;
                }
            }
        }

        return res.toString().substring(0, i);
    }
}
