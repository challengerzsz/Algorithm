package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-27 18:40
 */
public class T1291 {

    // 顺次数
    // 给定[left, right]之间 存在的数字 要求 数字的后一位都比前一位大1
    // 10 <= low <= high <= 10^9
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();

        // 在low和high之间可能存在的顺次数都是base的子串
        String base = "123456789";

        int lowLength = String.valueOf(low).length();
        int highLength = String.valueOf(high).length();


        // 类似滑动窗口
        for (int i = 0; i <= 9; i++) {
            for (int j = lowLength; j <= highLength; j++) {
                if (i + j > 9) {
                    continue;
                }
                String temp = base.substring(i, i + j);

                if (Integer.parseInt(temp) > high || Integer.parseInt(temp) < low) {
                    continue;
                }
                res.add(Integer.parseInt(temp));
            }
        }

        // 这里的窗口滑动会造成一个问题
        // 第一次12 123 12345
        // 这三个顺次数并不是连续的 应该是
        // 12 123 234 ... 12345
        // 排序
        res.sort(Comparator.comparingInt(o -> o));

        return res;
    }
}
