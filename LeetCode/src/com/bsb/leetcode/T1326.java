package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-21 15:35
 */
public class T1326 {

    // 灌溉花园的最少水龙头数目
    // 花园长度为n 从0～n
    // 第i个水龙头可以灌溉的区域为[i - ranges[i], i + ranges[i]]
    // 如果不能覆盖整个花园 那么返回-1
    // 0～1之间是一块土地
    // 水龙头的位置是在每个下标位置
    // 贪心
    public int minTaps(int n, int[] ranges) {

        int[] land = new int[n];
        for (int i = 0; i < ranges.length; i++) {
            // 找寻每一个水龙头能够覆盖的最左 最右边界
            int left = Math.max(i - ranges[i], 0);
            int right = Math.min(i + ranges[i], n);
            // 从这个水龙头能覆盖到的最左侧土地下标开始 更新land数组
            // land数组表示水龙头能够覆盖到当前土地且能覆盖到的最右侧的位置是在哪里
            for (int j = left; j < right; j++) {
                land[j] = Math.max(land[j], right);
            }
        }

        int res = 0;
        int current = 0;
        while (current < n) {
            // 如果land数组的某一项还是0的话 证明所有的水龙头都走了一遍都没有办法覆盖上这个土地
            if (land[current] == 0) return -1;
            // 移动current指针到能够覆盖到这块土地的水龙头能偷覆盖到的最右侧土地
            current = land[current];
            res++;
        }
        return res;
    }
}
