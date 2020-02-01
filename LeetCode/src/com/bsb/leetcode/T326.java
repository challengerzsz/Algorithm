package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-01 14:37
 */
public class T326 {

    // 判断是不是3的幂次 题目要求不递归或循环
    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        return n == 1;
    }

    // 这就是数学解了
    // 我们所要做的就是将数字转换为以3为底的基数，并检查它是否为前导1，后面跟所有的0
    // lgn
    // ---
    // lg3
    public boolean isPowerOfThree2(int n) {
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toString(27, 3));
    }
}
