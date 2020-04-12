package com.bsb.kuaishou.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-12 15:48
 */
public class T2 {

    List<Integer> res;

    public int[] GetPowerFactor(int R, int N) {
        // write code here
        // 感觉是dfs
        List<Integer> list = new ArrayList<>();
        int num = (int) (Math.log(R) / Math.log(N));

        dfs(R, N, 0, list, 0, num);

        if (res == null) return new int[0];
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    private void dfs(int R, int N, int now, List<Integer> list, int sum, int num) {

        if (now > num) {
            if (sum == R) {
                res = new ArrayList<>(list);
                return;
            }
            return;
        }

        List<Integer> newList = new ArrayList<>(list);
        dfs(R, N, now + 1, list, sum, num);

        newList.add(now);
        sum += Math.pow(N, now);
        dfs(R, N, now + 1, newList, sum, num);
    }

    public static void main(String[] args) {
        int[] a = new T2().GetPowerFactor(33 ,3);
        for (int temp : a) System.out.println(temp);
    }
}
