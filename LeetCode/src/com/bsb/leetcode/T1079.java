package com.bsb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-27 16:03
 */
public class T1079 {

    // 活字印刷
    public int numTilePossibilities(String tiles) {

        boolean[] visited = new boolean[tiles.length()];
        // 去重
        Set<String> set = new HashSet<>();
        dfs(visited, set, tiles, new StringBuilder());
        // 这里需要减去刚入dfs的时候add进去的""空串
        return set.size() - 1;
    }

    public void dfs(boolean[] visited, Set<String> set, String tiles, StringBuilder sb) {

        set.add(sb.toString());

        for (int i = 0; i < tiles.length(); i++) {

            if (!visited[i]) {
                visited[i] = true;
                sb.append(tiles.charAt(i));
                dfs(visited, set, tiles, sb);
                // 回溯 删除sb最后一位 和修改visited数组
                sb.deleteCharAt(sb.length() - 1);
                visited[i] = false;
            }

        }
    }

    public static void main(String[] args) {
        new T1079().numTilePossibilities("AAB");
    }
}
