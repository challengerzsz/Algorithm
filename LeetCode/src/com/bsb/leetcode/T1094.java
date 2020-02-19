package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-19 16:09
 */
public class T1094 {

    // 拼车
    // trips[][]，其中 trips[i] = [num_passengers, start_location, end_location]
    // num_passengers是本次行程需要拉的乘客 start_location起始位置 end_location结束位置
    // 其实就是重点关注每一趟旅程的起始点 并且注意能够装下多少人
    // 一趟过 标记每个起始结束点还剩多少座位
    public boolean carPooling(int[][] trips, int capacity) {
        int[] map = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            int num = trips[i][0];
            int start = trips[i][1];
            int end = trips[i][2];
            // 计算一下从某个起点开始的时候车上的剩余座位是多少
            map[start] -= num;
            // 结束点加回来
            map[end] += num;
        }
        for (int i = 0; i < map.length; i++) {
            // 计算累计的容量数 如果出现负值则肯定表示无法拉下那么多人
            capacity += map[i];
            if (capacity < 0) return false;
        }
        return true;
    }
}
