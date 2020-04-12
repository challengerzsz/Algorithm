package com.bsb.kuaishou.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-12 15:48
 */
public class T3 {

    List<Integer> res;
    boolean[] key;
    int length;
    long min = Long.MAX_VALUE;

    public int[] WaitInLine (int[] a, int[] b) {
        if (a == null || b == null) return new int[0];
        // write code here
        length = a.length;
        key = new boolean[length];
        dfs(a, b, new LinkedList<>(), 0);
        int[] arr = new int[length];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void dfs(int[] a, int[] b, List<Integer> list, long sum) {

        if (list.size() == length) {
            if (sum < min) {
                min = sum;
                res = new LinkedList<>(list);
            }
            return;
        }
        for (int i = 0; i < length; i++) {
            if (key[i]) continue;
            key[i] = true;

            list.add(i + 1);
            dfs(a, b, list, sum + a[i] * (list.size() - 1) +
                    b[i] * (length - list.size()));
            list.remove(list.size() - 1);
            key[i] = false;
        }
    }
}
