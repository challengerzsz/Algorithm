package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
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


    List<List<Integer>> res = new LinkedList<>();

    /* 主函数，输入一组不重复的数字，返回它们的全排列 */
    List<List<Integer>> permute2(int[] nums) {
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return res;
    }

    // 路径：记录在 track 中
    // 选择列表：nums 中不存在于 track 的那些元素
    // 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track);
            // 取消选择
            track.removeLast();
        }
    }

}