package com.bsb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-02 15:01
 */
public class T77 {

    // 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合
    // 类似全排列
    private List<List<Integer>> res = new LinkedList<>();
    int n;
    int k;

    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        backtrack(1, new LinkedList<>());
        return res;
    }
    private void backtrack(int first, LinkedList<Integer> curr) {

        if (curr.size() == k) res.add(new LinkedList<>(curr));

        for (int i = first; i < n + 1; ++i) {
            curr.add(i);
            backtrack(i + 1, curr);
            // 回溯
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        new T77().combine(5, 2);
    }
    
}
