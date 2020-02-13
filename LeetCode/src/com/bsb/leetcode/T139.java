package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-28 17:38
 */
public class T139 {

    public boolean wordBreak(String s, List<String> wordDict) {

        // bfs解
        // 写的好像有点麻烦
        // 参照题解写的.. 理解还是花了半天
        Set<String> set = new HashSet(wordDict);
        Queue<Integer> queue = new LinkedList<>();
        // 是否访问过的数组
        int[] visited = new int[s.length()];
        queue.add(0);
        while (!queue.isEmpty()) {
            int start = queue.remove();
            if (visited[start] == 0) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (set.contains(s.substring(start, end))) {
                        queue.add(end);
                        if (end == s.length()) {
                            return true;
                        }
                    }
                }
                visited[start] = 1;
            }
        }
        return false;
    }


    // dp[i,j] 表示从 s 的第 i 个字符开始 到第 j 个字符的前一个结束的字符串是否能由 wordDict 构成
    // 根据dp定义尝试着递归写
    // 超时
    public boolean wordBreak2(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper(s, set);
    }

    private boolean helper(String s, HashSet<String> set) {
        if (s.length() == 0) {
            return true;
        }
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(i)) && helper(s.substring(0, i), set)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak3(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        return helper2(s, set, new HashMap<>());
    }

    // map记忆化存储递归结果
    private boolean helper2(String s, HashSet<String> set, HashMap<String, Boolean> map) {
        if (s.length() == 0) {
            return true;
        }
        if (map.containsKey(s)) {
            return map.get(s);
        }
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.substring(i)) && helper2(s.substring(0, i), set, map)) {
                map.put(s, true);
                return true;
            }
        }
        map.put(s, false);
        return false;
    }

    // dp解
    // dp[i] 表示字符串 s[0,i) 能否由wordDict构成
    public boolean wordBreak4(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[j] && wordDict.contains(s.substring(j, i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
