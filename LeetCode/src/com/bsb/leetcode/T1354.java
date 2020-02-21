package com.bsb.leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-21 17:09
 */
public class T1354 {

    // 贪心系列最后一题
    // 多次求和 构造目标数组
    // 思路 target数组所有元素放入set
    // 对原数组求和之后contains
    // 45/68 解答错误
    // 这种思路不能够满足如果每次求和的值不再set里需要继续求和的情况
    public boolean isPossible(int[] target) {
        HashSet<Integer> set = new HashSet<>();
        for (int temp : target) {
            set.add(temp);
        }
        // 一开始是全1数组
        int initSum = target.length;
        while (!set.isEmpty()) {
            if (!set.contains(initSum)) return false;
            set.remove(initSum);
            initSum = 2 * initSum - 1;
        }
        return true;
    }

    // 基本相同的思路 超时
    public boolean isPossible2(int[] target) {
        // 大顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < target.length; i++) {
            queue.add(target[i]);
            sum += target[i];
        }

        while (sum != target.length) {
            int cur = queue.poll();
            int rest = sum - cur;
            int pre = cur - rest;
            if (pre >= cur || pre < 1) {
                return false;
            }
            sum = cur;
            queue.offer(pre);
        }
        return true;
    }

    // 上面两种思路都是从最开始向后递推
    // 但是都超时了
    // 逆向思维 从后向前推
    public boolean isPossible3(int[] target) {
        while (true) {
            int index = 0;
            long max = 0;
            long sum = 0;
            for (int i = 0; i < target.length; i++) {
                if (target[i] <= 0) return false;
                sum += target[i];
                if (target[i] > max) {
                    index = i;
                    max = target[i];
                }
            }
            if (sum < 0) break;
            if (max == 1 && sum == target.length) return true;
            if (2 * max - sum <= 0) return false;
            target[index] = (int) (2 * max - sum);
        }
        return false;
    }

}
