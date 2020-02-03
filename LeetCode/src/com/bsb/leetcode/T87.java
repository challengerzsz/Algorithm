package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-03 20:27
 */
public class T87 {

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        // 判断两个字符串每个字母出现的次数是否一致
        // 只有小写字母
        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        // 如果两个字符串中的字符出现次数不一样 也就证明不管通过怎么转换非叶子结点都不能进行两个字符串之间的转换
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        // 遍历每个切割位置
        for (int i = 1; i < s1.length(); i++) {
            // 判断 S1 的子树能否变为 S2 相应部分
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) {
                return true;
            }
            // S1 两个子树先进行了交换，然后判断 S1 的子树能否变为 S2 相应部分
            if (isScramble(s1.substring(i), s2.substring(0, s2.length() - i)) &&
                    isScramble(s1.substring(0, i), s2.substring(s2.length() - i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isScramble2(String s1, String s2) {
        // dp[len][i][j]来表示s1[i, i + len)和s2[j, j + len) 两个字符串是不是满足田间

        if (s1.length() != s2.length()) {
            return false;
        }
        if (s1.equals(s2)) {
            return true;
        }

        int[] letters = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        int length = s1.length();
        boolean[][][] dp = new boolean[length + 1][length][length];
        // 遍历所有的字符串长度
        for (int len = 1; len <= length; len++) {
            // S1 开始的地方
            for (int i = 0; i + len <= length; i++) {
                // S2 开始的地方
                for (int j = 0; j + len <= length; j++) {
                    // 长度是 1 无需切割
                    if (len == 1) {
                        dp[len][i][j] = s1.charAt(i) == s2.charAt(j);
                    } else {
                        // 遍历切割后的左半部分长度
                        for (int q = 1; q < len; q++) {
                            dp[len][i][j] = dp[q][i][j] && dp[len - q][i + q][j + q]
                                    || dp[q][i][j + len - q] && dp[len - q][i + q][j];
                            //  如果当前是 true 就 break，防止被覆盖为 false
                            if (dp[len][i][j]) {
                                break;
                            }
                        }
                    }
                }
            }
        }
        return dp[length][0][0];
    }
}
