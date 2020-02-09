package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-09 20:04
 */
public class T738 {

    // 单调递增数字
    public int monotoneIncreasingDigits(int N) {
        // 例如 1234378
        // =>   1233378
        // => 123399
        char[] array = String.valueOf(N).toCharArray();
        int i = 1;
        while (i < array.length && array[i - 1] <= array[i]) i++;
        while (0 < i && i < array.length && array[i - 1] > array[i]) array[--i]--;
        // 当排除了递减的第一个数字之后就要开始填充9
        for (int j = i + 1; j < array.length; ++j) array[j] = '9';

        return Integer.parseInt(String.valueOf(array));
    }
}
