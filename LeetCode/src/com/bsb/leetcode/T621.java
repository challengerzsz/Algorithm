package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-09 9:26
 */
public class T621 {


    // 任务调度
    // 尽量选择任务数较多的优先安排 因为题意要求任务之间必须间隔n次才能又被安排
    public int leastInterval(char[] tasks, int n) {
        // 用一个26长度的一维数组来做每个任务的次数缓存
        // 第二种思路就是利用Java的优先队列 利用堆去进行解答
        int[] map = new int[26];
        for (char c : tasks) map[c - 'A']++;
        // 我们这里只需要知道每个任务的次数 所以按照升序排序一下
        Arrays.sort(map);
        int time = 0;
        // 优先安排最多的任务 如果map中不存在最多的任务即任务已经全部安排完毕
        while (map[25] > 0) {
            int i = 0;
            while (i <= n) {
                // 不管有没有满足条件的任务 time每次都是++的 因为需要满足题意说明的CPU等待条件
                if (map[25] == 0)
                    break;
                if (i < 26 && map[25 - i] > 0)
                    map[25 - i]--;
                time++;
                i++;
            }
            Arrays.sort(map);
        }
        return time;
    }

    public static void main(String[] args) {
        char[] array = {'A', 'A', 'A', 'B', 'B', 'B'};
        System.out.println(new T621().leastInterval(array, 2));
    }

}
