package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 21:29
 */
public class T90 {

    /**
     * 这种回溯的问题还是得多练 并且回溯可能还包括重复解
     * 有的时候重复解不一定能在最后输出结果集的时候进去重 可能会带来额外的时间复杂度
     * 所以还需要必要的回溯过程中剪枝 还是得多练
     * 合理地画出递归树能帮助好好理解题目...
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);

        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        res.add(temp);
        if (nums.length == 1) return res;

        int last = 1;
        for (int i = 1; i < nums.length; i++) {
            int size = res.size();
            if (nums[i] != nums[i - 1]) {
                last = size;
            }

            for (int j = size - last; j < size; j++) {
                List<Integer> tempList = new ArrayList(res.get(j));
                tempList.add(nums[i]);
                res.add(tempList);
            }
        }
        return res;
    }


}
