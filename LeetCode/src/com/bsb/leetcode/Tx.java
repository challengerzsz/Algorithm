package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-11-07 21:19
 */
public class Tx {

    private static int array[] = {2, 3, 5, 6, 10, 12, 11, 9, 7, 8};

    public static void main(String[] args) {

        int i = 0, j = array.length - 1;
        while (i != j) {
            if (array[j] < array[i]) {
                j--;
                continue;
            }
            else if (array[j] > array[i]) {
                i++;
                continue;
            }
            else {
                System.out.println("相同");
                return;
            }
        }
        System.out.println("无");
    }
}
