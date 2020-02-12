package com.bsb.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-12 19:15
 */
public class T473 {

    // 火柴拼正方形
    // 不能折断火柴
    public List<Integer> nums;
    // 火柴的四个边的和 这个在每一步dfs的时候都会把填充进入的边长度减掉
    public int[] sums = new int[4];
    public int possibleSide;

    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }

        // 计算围成正方形的周长 因为每根火柴都需要用到 所以给定数组之后的正方形周长就固定了
        int perimeter = 0;
        for (int temp : nums) {
            perimeter += temp;
        }

        // 可能的边长
        possibleSide = perimeter / 4;
        // 这里有可能周长不能围成正方形 所以判断一下 过用例的时候没过掉
        if (this.possibleSide * 4 != perimeter) {
            return false;
        }

        // 降序排序 这一步的操作有点类似贪心 每一步都是归位的最大的火柴
        // 这里选择先找大的火柴并且把长火柴归位
        // 流编程把数组包装成List
        this.nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        this.nums.sort(Collections.reverseOrder());
        return this.dfs(0);
    }

    public boolean dfs(int index) {

        // 如果我们dfs完了所有的火柴 就需要判断是不是每个边都是一样的 因为需要满足正方形
        if (index == this.nums.size()) {
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];
        }

        // 当前这根火柴长度
        int cur = this.nums.get(index);

        // 尝试加入四条边
        for (int i = 0; i < 4; i++) {
            // 不超过边长
            if (this.sums[i] + cur <= possibleSide) {
                this.sums[i] += cur;
                if (this.dfs(index + 1)) {
                    return true;
                }
                // 加入火柴长度之后减掉每一个边需要的长度
                this.sums[i] -= cur;
            }
        }

        return false;
    }
}
