package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-19 11:13
 */
public class T927 {

    // 三等分
    // [0, i] [i + 1, j - 1] [j, A.length - 1]
    // 可以的话返回{i, j}
    // 不可以的话返回{-1, -1}
    // 允许前导0 和 无前导0的二进制值一致
    // 思路就是如果3部分的二进制值相等 那就说明每一部分的1的个数是一致的
    public int[] threeEqualParts(int[] A) {
        // 未找到 -1， -1
        int[] res = new int[]{-1, -1};
        int N = A.length;

        int count = 0;
        // 统计1的个数
        for (int x : A) count += x;
        if (count % 3 != 0) return res;
        
        int everyPeace = count / 3;
        if (everyPeace == 0) return new int[]{0, N - 1};

        // 三部分的区间边界
        int i1 = -1, j1 = -1, i2 = -1, j2 = -1, i3 = -1, j3 = -1;
        int one = 0;
        for (int i = 0; i < N; ++i) {
            // 从左到右走一遍 为了给每个区间分1
            if (A[i] == 1) {
                one += 1;
                if (one == 1) i1 = i;
                if (one == everyPeace) j1 = i;
                if (one == everyPeace + 1) i2 = i;
                if (one == 2 * everyPeace) j2 = i;
                if (one == 2 * everyPeace + 1) i3 = i;
                if (one == 3 * everyPeace) j3 = i;
            }
        }

        // 每一个区间
        int[] peace1 = Arrays.copyOfRange(A, i1, j1 + 1);
        int[] peace2 = Arrays.copyOfRange(A, i2, j2 + 1);
        int[] peace3 = Arrays.copyOfRange(A, i3, j3 + 1);

        // 检查区间代表的二进制是否相等
        if (!Arrays.equals(peace1, peace2)) return res;
        if (!Arrays.equals(peace1, peace3)) return res;


        int x = i2 - j1 - 1;
        int y = i3 - j2 - 1;
        int z = A.length - j3 - 1;

        if (x < z || y < z) return res;
        // 返回数组的两个等分点
        return new int[]{j1 + z, j2 + z + 1};
    }
}
