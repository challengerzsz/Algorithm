package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 16:24
 */
public class T944 {

    public int minDeletionSize(String[] A) {
        if (A == null || A.length == 0) return 0;
        int res = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j].charAt(i) < A[j - 1].charAt(i)) {
                    res++;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] array = {"cba", "daf", "ghi"};
        System.out.println(new T944().minDeletionSize(array));
    }
}
