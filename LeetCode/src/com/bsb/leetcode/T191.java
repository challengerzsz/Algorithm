package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-14 22:01
 */
public class T191 {

    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    // 将 n 和 n - 1 做与运算，会把最后一个 1 的位变成 0
    // 直到全0的时候就证明二进制中没有1了
    public int hammingWeight2(int n) {

        int sum = 0;
        while (n != 0) {
            sum++;
            n &= (n - 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        long temp = Long.parseLong("11111111111111111111111111111101", 2);
        System.out.println(temp);
        System.out.println(4 & 1);
    }
}
