package com.bsb.leetcode.vip.bytedance;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-04 11:43
 */
public class T3 {

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int res = 0, left = 0, right = 0;

        // 滑动窗口
        while (left < s.length() && right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                // 右窗口右滑 加入set
                set.add(s.charAt(right++));
                res = Math.max(res, right - left);
            } else {
                // 左窗口右滑
                set.remove(s.charAt(left++));
            }
        }
        return res;
    }

    /**
     * 优化滑动窗口
     * 不需要像上面哪种方法一样出现重复之后左窗口一格一格滑动
     * 左窗口右移至目前窗口中出现字符的下标 + 1处 越过重复字符检查下一窗口
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringBetter(String s) {
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int j = 0, i = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            res = Math.max(res, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return res;
    }

    // 其实上面那种思路就已经是和dp一个思路了
    // 我就记得这题能用dp解 并且也符合dp的要求
    // 所以还是写一下吧
    public int lengthOfLongestSubstringDp(String s) {

        if (s == null || s.length() == 0) return 0;

        // dp[i] 表示以 s[i] 结尾的最长不重复子串的长度
        // 因为自己肯定是不重复子串，所以初始值设置为 1
        int[] dp = new int[s.length()];
        // dp[i]表示 以s[i]为结尾的无重复子串的长度
        // 初始化每个字符本身就是最长子串 长度为1
        for (int i = 0; i < s.length(); i++) {
            dp[i] = 1;
        }

        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 0);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (dp[i - 1] >= i - map.get(c)) {
                    // 相当于左窗口右移
                    dp[i] = i - map.get(c);
                } else {
                    // 这里需要注意 因为我们用的map存储的之前出现过的字符的下标
                    // 因为dp[i] 的状态是根据dp[i - 1]转换而来的
                    // 就需要注意如果以s[i - 1]组成的无重复子串长度dp[i - 1]是不包括之前重复的s[i]的 那么这个情况右窗口还是可以右滑
                    // 之前都忘记这个了 只是一股脑去想着dp[i]和dp[i - 1]的关系了 结果解错了
                    dp[i] = dp[i - 1] + 1;
                }
            } else {
                // 目前无重复 相当于上面滑动窗口的右窗口右移
                dp[i] = dp[i - 1] + 1;
            }
            map.put(c, i);
        }

        // dp[i]的定义不是题目最后的解的意思 所以还需要再走一遍dp数组
        int res = dp[0];
        for (int i = 1; i < s.length(); i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
