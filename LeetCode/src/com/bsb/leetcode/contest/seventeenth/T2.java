package com.bsb.leetcode.contest.seventeenth;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-16 10:39
 */
public class T2 {

    private List<Integer> list = new ArrayList<>();

    public T2() {

    }

    public void add(int num) {
        this.list.add(num);
    }

    public int getProduct(int k) {
        int res = 1;
        for (int i = list.size() - 1; i >= list.size() - k; i--) {
            if (list.get(i) == 0) return 0;
            res *= list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        T2 t2 = new T2();
        t2.add(3);
        t2.add(0);
        t2.add(2);
        t2.add(5);
        t2.add(4);
        System.out.println(t2.getProduct(2));
    }

}
