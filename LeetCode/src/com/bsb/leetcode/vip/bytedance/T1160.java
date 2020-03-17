package com.bsb.leetcode.vip.bytedance;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-17 21:41
 */
public class T1160 {

    // 拼写单词
    public int countCharacters(String[] words, String chars) {
        int[] map = new int[26];
        for (char c : chars.toCharArray()) map[c - 'a']++;
        int res = 0;
        for (String str : words) {
            int[] temp = Arrays.copyOfRange(map, 0, map.length);
            boolean flag = true;
            for (char c : str.toCharArray()) {
                if (temp[c - 'a'] == 0) {
                    flag = false;
                    break;
                }
                temp[c - 'a']--;
            }
            if (flag) res += str.length();
        }

        return res;
    }

    public static void main(String[] args) {
        new T1160().countCharacters(new String[]{"cat","bt","hat","tree"}, "atach");
    }
}
