package com.bsb.leetcode.contest.seventeenth;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-16 12:28
 */
public class T4 {

    // 给定一个初始数组A 其中的元素全为1
    // 每次都可以对A数组求sum 并且把sum放置在A的某个位置上
    // 是否可以变换为target数组
    public boolean isPossible(int[] target) {

        while (true) {
            int index = 0;
            long max = 0;
            long sum = 0;
            for (int i = 0; i < target.length; i++) {
                if (target[i] <= 0) return false;
                sum += target[i];
                // 找当前这一趟的最大值
                if (target[i] > max) {
                    index = i;
                    max = target[i];
                }
            }
            // 不符合条件
            if (sum < 0) break;
            // 已经转换到了原始A数组 全1序列
            if (max == 1 && sum == target.length) return true;
            // 上一轮的数组最大值
            if (2 * max - sum <= 0) return false;
            // 逆向还原上一轮的数组被改变的值
            target[index] = (int) (2 * max - sum);
        }
        return false;
    }
}
