package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-14 21:15
 */
public class T190 {

    // 颠倒二进制
    // 我这解法直接没过..
    public int reverseBits(int n) {
        // 这里无法考虑无符号数的转换为二进制时出现的溢出情况 所以没了..
        String str = Integer.toBinaryString(n);
        return Integer.parseInt(new StringBuilder(str).reverse().toString(), 2);
    }

    public int reverseBits2(int n) {
        int res = 0;
        int count = 0;
        while (count < 32) {
            // res 左移一位为了保证最低位一直为0 因为下一步需要或运算计算结果
            res <<= 1;
            // 逐步把n的最高位添加到res的最低位
            res |= (n & 1);
            // 对原n的移位
            n >>= 1;
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
//        int a = 4294967293;
        // 我都忘了java没有无符号int了...
//        unsigned int a = 4294967293;
        System.out.println(new T190().reverseBits(43261596));
    }
}
