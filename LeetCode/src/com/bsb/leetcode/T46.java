package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-02 20:56
 */
public class T46 {

    // 回溯思想
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(result, nums, 0);
        return result;
    }

    public void helper(List<List<Integer>> result, int[] arr, int index) {
        if (index == arr.length) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int t : arr) {
                list.add(t);
            }
            result.add(list);
            return;
        }
        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            helper(result, arr, index + 1);
            swap(arr, index, i);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        new T46().permute(array);
    }
}