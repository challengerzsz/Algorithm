package com.bsb.leetcode.interview;

import java.util.ArrayList;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-30 15:34
 */
public class T62 {

    // 约瑟夫环
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (n > 1) {
            index = (index + m - 1) % n;
            list.remove(index);
            n--;
        }
        return list.get(0);
    }
}
