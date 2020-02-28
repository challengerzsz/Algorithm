package com.bsb.leetcode;

import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-28 09:54
 */
public class T841 {

    // 钥匙和房间
    // 一开始只有0号房间是开锁的
    // 每个房间都有一个钥匙列表 判断能否走完整个屋子
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0) return false;

        boolean[] visited = new boolean[rooms.size()];
        dfs(rooms, 0, visited);
        return canVisitAllRooms(visited);
    }

    private void dfs(List<List<Integer>> rooms, int index, boolean[] visited) {
        if (visited[index]) return;

        visited[index] = true;
        for (int temp : rooms.get(index)) {
            dfs(rooms, temp, visited);
        }
    }

    private boolean canVisitAllRooms(boolean[] visited) {
        for (boolean temp : visited) {
            if (!temp) return false;
        }
        return true;
    }
}
