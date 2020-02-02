package com.bsb.leetcode;

import java.util.HashMap;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-02 14:29
 */
public class T76 {

    // 滑动窗口
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> needMap = new HashMap<>();
        HashMap<Character, Integer> haveMap = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int count = 0;
        String str = "";

        // 初始化对1的
        for (char c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }
        int l = 0, r = 0;
        for (; r < s.length(); r++) {
            char temp = s.charAt(r);
            haveMap.put(temp, haveMap.getOrDefault(temp, 0) + 1);
            if (needMap.get(temp) != null && haveMap.getOrDefault(temp, 0) <= needMap.get(temp)) {
                count++;
                haveMap.put(temp, haveMap.getOrDefault(temp, 0) + 1);
            }
            // 缩小窗口 从左边缩小 同时保证有效
            while (count == t.length()) {
                temp = s.charAt(l);
                if (needMap.get(temp) != null && needMap.get(temp) > 0 && haveMap.get(temp) <= needMap.get(temp))
                    count--;
                if ((r - l - 1) < min) {
                    str = s.substring(l, r + 1);
                    min = r - l - 1;
                }
                haveMap.put(temp, haveMap.get(temp) - 1);
                l++;
            }
        }

        return str;
    }

    public static void main(String[] args) {
        new T76().minWindow("ADOBECODEBANC", "ABC");
    }

}
