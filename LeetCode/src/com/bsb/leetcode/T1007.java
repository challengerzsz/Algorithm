package com.bsb.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 20:20
 */
public class T1007 {

    // 行相等的最少多米诺旋转
    public int minDominoRotations(int[] A, int[] B) {
        // 统计一张多米诺上下出现最多的点数和次数
        HashMap<Integer, Integer> mapA = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            mapA.put(A[i], B[i]);
        }
        HashMap<Integer, Integer> mapB = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            mapB.put(B[i], A[i]);
        }
        int maxA = 0, maxNumA = Integer.MIN_VALUE;
        int maxB = 0, maxNumB = Integer.MIN_VALUE;
        int count = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i + 1] != A[i]) {
                count = 0;
            }
            count++;
            if (count > maxA) {
                maxA = count;
                maxNumA = A[i];
            }
        }
        for (int i = 0; i < B.length - 1; i++) {
            if (B[i + 1] != B[i]) {
                count = 0;
            }
            count++;
            if (count > maxB) {
                maxB = count;
                maxNumB = B[i];
            }
        }
        boolean flag = maxA > maxB;
        int target = maxA > maxB ? maxNumA : maxNumB;
        int res = 0;
        if (flag) {
            for (int i = 0; i < A.length; i++) {
                if (A[i] != target) {
                    if (B[i] != target) return -1;
                    else res++;
                }
            }
        } else {
            for (int i = 0; i < B.length; i++) {
                if (B[i] != target) {
                    if (A[i] != target) return -1;
                    else res++;
                }
            }
        }

        return res;
    }

    public int minDominoRotations2(int[] A, int[] B) {
        // 牌的点数是1～6
        // flag数组记录的是可以反转成功的点数 只有两个数组中相同数字的数量和大于数组长度才可以完成反转
        int[] flag = new int[7];
        for (int i = 0; i < A.length; i++) {
            flag[A[i]]++;
            if (A[i] != B[i])
                flag[B[i]]++;
        }

        int res = -1;
        for (int i = 1; i < 7; i++) {
            if (flag[i] >= A.length) {
                // 累积i在数组A中的出现次数
                int countA = 0;
                for (int num : A) {
                    if (num == i) {
                        countA++;
                    }
                }
                // 累积在数组B中的出现次数
                int countB = 0;
                for (int num : B) {
                    if (num == i)
                        countB++;
                }
                res = Math.min(A.length - countA, A.length - countB);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array1 = {2, 1, 2, 4, 2, 2};
        int[] array2 = {5, 2, 6, 2, 3, 2};
        System.out.println(new T1007().minDominoRotations2(array1, array2));
    }
}
