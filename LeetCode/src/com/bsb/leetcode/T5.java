package com.bsb.leetcode;

import java.util.Stack;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-04-07 23:47
 */
public class T5 {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int[] max = {0, 0, 0};
        int length;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (checkIfCircleStr(s, i, j)) {
                    length = j - i + 1;
                    if (length > max[0]) {
                        max[0] = length;
                        max[1] = i;
                        max[2] = j;
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = max[1]; i <= max[2]; i++) {
            stringBuilder.append(s.charAt(i));
        }

        return stringBuilder.toString();
    }

    private boolean checkIfCircleStr(String str, int start, int end) {

        Stack<Character> stack = new Stack<>();
        for (int i = start; i <= end; i++) {
            stack.push(str.charAt(i));
        }

        for (int i = start; i <= end; i++) {
            if (str.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    public static String makeItBetter(String str) {

        if (str == null || str.trim().length() < 1) return "";
        int begin = 0, end = 0, max = 0;
        int lengthOfStr1 = 0, lengthOfStr2 = 0, maxgth = 0;
        for (int i = 0; i < str.length(); i++) {
            lengthOfStr1 = findReverseIndex(str, i, i);
            lengthOfStr2 = findReverseIndex(str, i, i + 1);
            maxgth = Math.max(lengthOfStr1, lengthOfStr2);
            if (maxgth > max) {
                max = maxgth;
                begin = i - (max - 1) / 2;
                end = i + max / 2;
            }
        }
        return str.substring(begin, end + 1);
    }

    private static int findReverseIndex(String s, int start, int end) {
        int l = start, r = end;
        while (l >= 0 && r < s.length() && (s.charAt(l) == s.charAt(r))) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    // 突然想起来有个这个题 来练练动态规划
    public String longestPalindromeByDp(String str) {

        // 定义二维dp数组 dp[i][j]表示str从i～j是否为回文串
        // 这里i <= j
        boolean[][] dp = new boolean[str.length()][str.length()];
        // 初始化dp数组 i == j的也就是单个字符肯定是一个回文串 初始化为1
        for (int i = 0; i < str.length(); i++) dp[i][i] = true;
        int max = 1;
        int index = 0;
        for (int j = 1; j < str.length(); j++) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == str.charAt(j)) {
                    // j - 1 - (i + 1) + 1 < 2 这个是i～j之间不能组成字串的边界条件 => j - i < 3
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        // 如果i + 1 ~ j - 1是回文串 那么在这里 dp[i][j]应该也是true
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                } else {
                    dp[i][j] = false;
                }

                // 只要 dp[i][j] == true 成立，就表示子串 s[i, j] 是回文，此时记录回文长度和起始位置
                if (dp[i][j]) {
                    int curLen = j - i + 1;
                    if (curLen > max) {
                        max = curLen;
                        index = i;
                    }
                }
            }
        }
        return str.substring(index, index + max);
    }

    public static void main(String[] args) {
//        System.out.println(new T5().longestPalindrome("121"));
//        String str = "1232";
//        System.out.println(str.indexOf("2", 2) + " " + str.substring(1, 5));
        System.out.println(makeItBetter("cbbdasdddsa"));
    }
}
