package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-31 15:47
 */
public class T319 {

    // 简单解 超时
    public int bulbSwitch(int n) {
        int result = 0;
        int[] array = new int[n];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }
        for (int i = 1; i <= array.length - 1; i++) {
            int times = i + 1;
            for (int j = 0; j < array.length; j++) {
                if ((j + 1) % times == 0) {
                    if (array[j] == 0) {
                        array[j] = 1;
                    } else {
                        array[j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1) {
                result++;
            }
        }
        return result;
    }

    // 1 2 3 4 5 6 7 8 9 10 11 12
    // 2   4   6   8   10    12
    // 3     6     9       12
    // 4       8         12
    // 5         10
    // 6             12
    // 7 8 9 10 11 12
    // 只有在平方数地方的灯泡会亮着
    int bulbSwitch2(int n) {
        return (int) Math.sqrt(n);
    }
}
