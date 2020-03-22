package com.bsb.leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-20 21:13
 */
public class T40 {

    // 最小的k个数
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[0];

        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) list.add(arr[i]);

        int[] res = Arrays.copyOfRange(arr, 0, k);
        return res;
    }
}
