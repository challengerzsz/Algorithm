package com.bsb.leetcode.contest.twenty_first_double;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 21:59
 */
public class T5336 {

    // 上升下降字符串
    // 从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
    // 从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
    // 重复步骤 2 ，直到你没法从 s 中选择字符。
    // 从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
    // 从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
    // 重复步骤 5 ，直到你没法从 s 中选择字符。
    // 重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
    public String sortString(String s) {
        int total = s.length();
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            map[c - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        while (total != 0) {
            // 1
            int i = 0;
            for (; i < map.length; i++) {
                if (map[i] != 0) {
                    res.append((char) (i + 'a'));
                    map[i]--;
                    total--;
                    break;
                }
            }

            // 2
            int j = i + 1;
            for (; j < map.length; j++) {
                if (map[j] != 0) {
                    res.append((char) (j + 'a'));
                    map[j]--;
                    total--;
                }
            }

            // 3
            int k = map.length - 1;
            for (; k >= 0; k--) {
                if (map[k] != 0) {
                    res.append((char) (k + 'a'));
                    map[k]--;
                    total--;
                    break;
                }
            }

            // 4
            int l = k - 1;
            for (; l >= 0; l--) {
                if (map[l] != 0) {
                    res.append((char) (l + 'a'));
                    map[l]--;
                    total--;
                }
            }

        }
        return res.toString();
    }
}
