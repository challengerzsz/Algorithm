package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-11 20:20
 */
public class T1013 {

    // 将数组划分为3个和相等的区域
    // 思路 3个区域 2个指针确定3个区域 相当于一个窗口在滑动 但是是3个窗口
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int temp : A) sum += temp;

        if (sum % 3 != 0) return false;

        int left = 0, partLeft = A[left], right = A.length - 1, partRight = A[A.length - 1];

        while (left + 1 < right) {
            if (partLeft == sum / 3 && partRight == sum / 3) return true;

            if (partLeft != sum / 3) partLeft += A[++left];
            if (partRight != sum / 3) partRight += A[--right];
        }
        return false;
    }

    public boolean canThreePartsEqualSum2(int[] A) {
        int time = 0;
        int sum = 0;
        for (int temp : A) sum += temp;
        if (sum % 3 != 0) return false;
        int cur = 0;
        for (int temp : A) {
            cur += temp;
            if (cur == sum / 3) {
                cur = 0;
                time++;
            }
        }

        return time >= 3;
    }

    public static void main(String[] args) {
        new T1013().canThreePartsEqualSum(new int[]{6, 1, 1, 13, -1, 0, -10, 20});
    }
}
