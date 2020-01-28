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
}
