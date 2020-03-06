package com.bsb.leetcode.vip.bytedance;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-06 14:31
 */
public class T7 {

    // 整数翻转
    // 这题转换成字符串会很好做 但是面试官估计也不会想看到 easy
    public int reverse(int x) {

        // 题目最后会给出int最大最小值 翻转之后肯定是溢出int的
        // long存 最后判断输出
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }
}
