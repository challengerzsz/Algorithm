package com.bsb.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-27 19:50
 */
public class T1239 {

    // 串联字符串的最大长度
    // 假设s是arr中某个子序列的拼接
    // 如果s中的字符都只出现了一次 那就是一次可行的拼接 返回可能的拼接串中长度的最大值
    int max = 0;

    public int maxLength(List<String> arr) {
        dfs(arr, 0, 0, 0);
        return max;
    }

    /**
     * 这里的bitMap其实就是判断一个子序列之中连续的两个字符串是否是存在相同字符
     * bitMap至少有26bit 用int就够了 每一位就代表一个字母是否存在 第26位表示a 25表示b ... 最低位0表示z是否存在
     * @param arr 字符串数组 题目给定
     * @param index 当前是否需要加入这个字符串
     * @param bitMap 判断两字符串之间是否存在相同字符
     * @param tempMax 目前来说合法的拼接字符串的最大长度
     */
    private void dfs(List<String> arr, int index, int bitMap, int tempMax) {
        if (index == arr.size()) {
            max = Math.max(max, tempMax);
            return;
        }

        String str = arr.get(index);
        int result = helper(bitMap, str);
        // 如果目前的index字符串和之前已经组成的字符串未出现重复字符 那么继续从当前开始选择下一个字符串
        if (result != -1) dfs(arr, index + 1, result, tempMax + str.length());

        // 如果目前index的字符串和之前的bitMap标记过的字符串发生了字符重复 那么直接从index + 1开始选择 放弃index
        dfs(arr, index + 1, bitMap, tempMax);
    }

    /**
     * 如果两个字符串之间没有重复字符 那么就返回bitMap 如果两个字符之间有重复字符那就返回-1
     * @param bitMap
     * @param str
     * @return
     */
    private int helper(int bitMap, String str) {
        char[] chars = str.toCharArray();
        for (char c : chars) {
            int tempInt = c - 'a';
            if ((bitMap & (1 << tempInt)) != 0) {
                return -1;
            }
            // 这里需要更新bitMap 相当于标记当前遍历到的c已经存在
            bitMap = bitMap | (1 << tempInt);
        }
        return bitMap;
    }

    public static void main(String[] args) {
        String[] strs = {"un", "iq", "ue"};
        new T1239().maxLength(Arrays.asList(strs));
    }

}
