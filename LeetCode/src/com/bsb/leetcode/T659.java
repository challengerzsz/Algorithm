package com.bsb.leetcode;


import java.util.HashMap;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-09 10:47
 */
public class T659 {

    // 这题我的思路就是尽量组成较长的连续子序列
    public boolean isPossible(int[] nums) {
        if (nums.length < 3) return false;
        int[] map = new int[10];
        for (int temp : nums) map[temp]++;
        int i = 1;
        int count = 0;
        while (i <= 9) {
            count = 0;
            if (map[i] == 0) {
                i++;
                continue;
            }
            int j = i;
            while (j <= 9 && map[j + 1] != 0) {
                count++;
                map[j]--;
                map[j + 1]--;
                j++;
            }
            if (count < 3) return false;
            i++;
        }
        return count != 0 && count % 3 == 0;
    }

    public boolean isPossible2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            // 子数组的元素个数
            int subNum = 0;
            int p = 1;
            // 下个元素
            int next = i;
            // 这里需要>= p 这里的意思就是如果下一个数字的出现次数大于p的话才有可能继续组成连续序列
            // 例如1 2 2 3 4 只能组成1234 或 12 234 每一个子数组的元素数小于3 不符合题意
            // 所以 如果当前数字的出现次数大于后面一位连续数字的出现次数 就不往后继续添加 到后面判断目前组成的子序列是不是有效的
            while (map.getOrDefault(next, 0) >= p) {
                p = map.get(next);
                map.put(next, p - 1);
                ++subNum;
                ++next;
            }
            if (subNum > 0 && subNum < 3) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 3, 4, 5};
        System.out.println(new T659().isPossible2(array));
    }
}
