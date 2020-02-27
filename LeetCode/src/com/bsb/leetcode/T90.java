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
     * 这题目不知道什么时候写的了 一点印象都没有
     * 题意是这样 和子集I不同的是子集II 给定的nums数组中可能包含重复元素
     * 例如[1, 2, 2]
     * 如果按照子集I的第二种解法计算出来的结果是
     * [] | [1] | [2] [1, 2] | [2] [1, 2] [2, 2] [1, 2, 2] |
     * 可以发现结果集中出现了重复的子集
     * 这里其实还可以发现 我用竖线分割成了4部分 其实就是每一步求解加入res的结果
     * 其实可以观察的到 如果第二个重复的2需要被处理的时候 只需要找到上一步相同元素新产生的子集 并将这个重复元素加入即可
     * 即：向| [2] [1, 2] | 末尾加入2 得到| [2, 2] [1, 2, 2] 这样的话就不会出现重复的解集
     *
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
        // 排序 排序帮助我们识别当前是否发生了重复
        Arrays.sort(nums);

        List<Integer> temp = new ArrayList<>();
        temp.add(nums[0]);
        res.add(temp);
        if (nums.length == 1) return res;

        // last表示的是不重复元素添加入res之后的位置
        int last = 1;
        for (int i = 1; i < nums.length; i++) {
            int size = res.size();
            if (nums[i] != nums[i - 1]) {
                last = size;
            }

            // size - last即表示重复元素需要被纳入子集中时 为保证不出现重复子集 需要从最初的相同元素所得解集开始加入
            for (int j = size - last; j < size; j++) {
                List<Integer> tempList = new ArrayList<>(res.get(j));
                tempList.add(nums[i]);
                res.add(tempList);
            }
        }
        return res;
    }


}
