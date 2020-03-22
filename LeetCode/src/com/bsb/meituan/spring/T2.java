package com.bsb.meituan.spring;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-19 18:46
 */
public class T2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        scanner.close();
        int max = 0;

        int left = 0, right = 1;
        int lastInWindow = nums[left];
        boolean del = false;
        int delIndex = 0;
        while (right <= n - 1) {
            if (nums[right] > lastInWindow) {
                lastInWindow = nums[right];
                max = del ? Math.max(max, right - left) :
                        Math.max(max, right - left + 1);
                right++;

            } else if (nums[right] <= lastInWindow) {
                if (!del) {
                    delIndex = right;
                    right++;
                    del = true;
                } else {
                    left = delIndex;
                    del = false;
                    right = left + 1;
                    lastInWindow = nums[left];
                }
            }
        }
        System.out.println(max);
    }
}
