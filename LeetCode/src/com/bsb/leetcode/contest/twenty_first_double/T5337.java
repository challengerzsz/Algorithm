package com.bsb.leetcode.contest.twenty_first_double;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-07 22:00
 */
public class T5337 {

    // 暴力超时
    public int findTheLongestSubstring(String s) {
        int[] map = new int[5];
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String str = s.substring(i, j + 1);
                for (char c : str.toCharArray()) {
                    switch (c) {
                        case 'a':
                            map[0]++;
                            break;
                        case 'e':
                            map[1]++;
                            break;
                        case 'i':
                            map[2]++;
                            break;
                        case 'o':
                            map[3]++;
                            break;
                        case 'u':
                            map[4]++;
                            break;
                    }
                }
                int flag = 0;
                for (int temp : map) {
                    if (temp % 2 != 0) {
                        flag++;
                        break;
                    }
                }
                if (flag == 0) max = Math.max(max, j - i + 1);
                Arrays.fill(map, 0);
            }

        }

        return max;
    }

    // 前缀异或和
    public int findTheLongestSubstring2(String s) {
        int[] map = new int[32];
        Arrays.fill(map, Integer.MAX_VALUE);
        map[0] = -1;

        // cur的低5位分别表示a e i o u 的出现次数异或位
        // cur就是一个异或和
        int cur = 0;
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            switch (s.charAt(i)) {
                case 'a':
                    cur ^= 1;
                    break;
                case 'e':
                    cur ^= 2;
                    break;
                case 'i':
                    cur ^= 4;
                    break;
                case 'o':
                    cur ^= 8;
                    break;
                case 'u':
                    cur ^= 16;
                    break;
                default:
                    break;
            }
            if (map[cur] == Integer.MAX_VALUE) map[cur] = i;
            else res = Math.max(res, i - map[cur]);
        }
        return res;
    }


    public static void main(String[] args) {
        new T5337().findTheLongestSubstring("eleetminicoworoep");
    }
}
