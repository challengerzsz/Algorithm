package com.bsb.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-21 16:01
 */
public class T1338 {

    // 数组大小减半
    // 删除数组中的元素 使得数组长度减半
    // 返回最少的删除次数
    // 数组中出现的元素会有重复
    // 如果数组中只有值相等的一个元素 那么返回1 删除所有值相同的元素使数组为空
    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 统计每个数字出现的次数
        for (int temp : arr)
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        int[] lens = new int[map.size()];
        int index = 0;
        for (int temp : map.values()) {
            lens[index] = temp;
            index++;
        }
        Arrays.sort(lens);

        // 题目描述已经说明 arr数量为偶数
        int len = arr.length / 2;
        // 贪心 优先取出现次数最多的
        // 取够一半 剩下的就是需要删除的
        for (int i = lens.length - 1; i >= 0; i--) {
            len -= lens[i];
            // 返回 至少 删除数组的一半
            if (len <= 0) return lens.length - i;
        }
        return -1;
    }
}
