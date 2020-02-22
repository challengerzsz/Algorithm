package com.bsb.leetcode.contest.twentith_double;

import java.util.HashSet;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 23:52
 */
public class T5326 {

    // 一共n个物流单
    // 只能先pick这个货物才能delivery这个货物
    // 保证pick在delivery之前 总共多少种情况？
    // 类似全排列
    // 一开始觉得是个全排列的题目 递归树画出来但是发现没办法解 这和全排列的回溯题目不太一样
    // 一开始其实上来就想到了排列组合 举了几个例子没写对我擦 其实就是tmd排列组合
    public int countOrders(int n) {
        // 题目要求对1000000007取余 直接想到用long 不然会溢出
        long yu = 1000000007;
        // 如果n = 2的话 则每一种排列的可能都是长度为4的 其实total就是每种排列的长度
        long res = 1, total = n * 2;
        for (int i = 1; i <= n; i++) {
            long now = total * (total - 1) / 2 % yu;
            res = res * now % yu;
            total -= 2;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        new T5326().countOrders(2);
    }
}
