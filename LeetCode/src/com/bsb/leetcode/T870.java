package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 14:49
 */
public class T870 {

    // 优势洗牌
    // 跟田忌赛马的思路差不多
    // 给A数组排序 遍历B数组 每一次都找大于B[i]的最小值 如果没有的话返回A的最小值
    public int[] advantageCount(int[] A, int[] B) {
        Arrays.sort(A);
        List<Integer> list = new ArrayList<>();
        for (Integer i : A) {
            list.add(i);
        }
        for (int i = 0; i < B.length; i++) {
            A[i] = helper(list, B[i]);
        }
        for (int i = 0; i < A.length; i++) {
            if (A[i] == -1) {
                A[i] = list.get(0);
                list.remove(0);
            }
        }
        return A;
    }

    private int helper(List<Integer> list, int x) {
        for (Integer temp : list) {
            if (temp > x) {
                list.remove(temp);
                return temp;
            }
        }
        return -1;
    }
}
