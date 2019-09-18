package com.bsb.sxf;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-18 16:01
 */
public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] strArray = input.split(" ");

        int[] intArray = new int[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            intArray[i] = Integer.parseInt(strArray[i]);
        }
        int count = 0;
        int max = 0, maxIdx = 0;
        int pos = intArray.length - 1;
        while (!checkIfSorted(intArray)) {
            for (int i = 0; i <= pos; i++) {
                if (intArray[i] > max) {
                    max = intArray[i];
                    maxIdx = i;
                }
            }
            if (max != intArray[pos]) {
                int temp = intArray[pos];
                intArray[pos] = intArray[maxIdx];
                intArray[maxIdx] = temp;
                count++;
            }
            pos--;
            max = 0;
        }
        System.out.println(count);
    }

    public static boolean checkIfSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i + 1] < array[i]) {
                return false;
            }
        }
        return true;
    }
}
