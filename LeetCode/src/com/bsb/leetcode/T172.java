package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-14 17:33
 */
public class T172 {

    // 阶乘后0的个数
    // 这题一开始看是简单题 直接上来就想算阶乘了.. 阶乘在一定的程度就会溢出了
    // 找找规律 其实可以想像到 如果说出现0了 那么肯定是阶乘的某一阶段产生了10这个因子 10 = 2 * 5
    // 比如5! = 1 * 2 * 3 * 4 * 5 一个2 一个5 那么肯定结果有一个0
    // 如果数字过大呢 其实可以想像一下 5的话是5个数字出现一次 2的话是2个数字出现一次(包含因式分解)
    // 其实就是找5的个数了...
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }
}
