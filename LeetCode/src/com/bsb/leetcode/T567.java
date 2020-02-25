package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-25 17:17
 */
public class T567 {

    // 字符串排列
    // 判断s2中是否有s1的排列
    // 超时
    public boolean checkInclusion(String s1, String s2) {
        List<String> combinations = new ArrayList<>();
        helper(s1.toCharArray(), 0, combinations);
        for (String str : combinations) {
            if (s2.contains(str)) return true;
        }
        return false;
    }

    private void helper(char[] chars, int index, List<String> combinations) {
        if (index == chars.length) {
            combinations.add(new String(chars));
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            helper(chars, index + 1, combinations);
            swap(chars, index, i);
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }


    // 数组统计每个字符出现的频率
    public boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        
        int[] map1 = new int[26];
        for (int i = 0; i < s1.length(); i++) map1[s1.charAt(i) - 'a']++;

        // 枚举s2的所有和s1等长的子串 判断两者构成的map中相同字符出现频率是否一致
        // 排列问题在这里其实是不分先后顺序的
        for (int i = 0; i <= s2.length() - s1.length(); i++) {
            int[] map2 = new int[26];
            for (int j = 0; j < s1.length(); j++) {
                map2[s2.charAt(i + j) - 'a']++;
            }
            if (helper(map1, map2)) return true;
        }
        return false;
    }

    private boolean helper(int[] map1, int[] map2) {
        for (int i = 0; i < 26; i++) {
            if (map1[i] != map2[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new T567().checkInclusion("abc", "eidbaooo"));
    }
}
