package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-31 18:18
 */
public class T315 {

    
    // 这题看了评论区 基础解法直接就是超时的
    // 想起了之前做过的逆序对的题 
    // 归并的时候统计
    // 这种题必须通过归 + 并实现排序 要不会出现重复统计
    public List<Integer> countSmaller(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        // 泛型果然能这样写..
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int[] tmp = {nums[i], 0, i};
            list.add(tmp);
        }
        list = sort(list);
        Integer[] results = new Integer[nums.length];
        for (int[] temp : list) {
            results[temp[2]] = temp[1];
        }
        return Arrays.asList(results);
    }

    private List<int[]> sort(List<int[]> list) {

        if (list.size() == 1) {
            return list;
        }
        int size = list.size() / 2;
        List<int[]> left = list.subList(0, size);
        List<int[]> right = list.subList(size, list.size());
        left = sort(left);
        right = sort(right);
        int i = 0, j = 0;
        List<int[]> results = new ArrayList<>();
        while (i < left.size() || j < right.size()) {
            if (j == right.size()) {
                results.add(i + j, left.get(i));
                i++;
                continue;
            }
            if (i == left.size()) {
                results.add(i + j, right.get(j));
                j++;
                continue;
            }
            if (left.get(i)[0] > right.get(j)[0]) {
                results.add(i + j, left.get(i));
                left.get(i)[1] = left.get(i)[1] + (right.size() - j);
                i++;
            } else {
                results.add(i + j, right.get(j));
                j++;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 2, 1, 0};
        new T315().countSmaller(array);
    }
}
