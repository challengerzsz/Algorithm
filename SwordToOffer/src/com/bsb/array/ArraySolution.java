package com.bsb.array;

import java.util.*;

public class ArraySolution {

    //二维数组查找
    public boolean Find(int target, int[][] array) {
        boolean result = false;

        for (int i = 0; i < array.length; i++) {
            for (int o = 0; o < array[0].length; o++) {
                if (array[i][o] == target) result = true;
            }
        }


        return result;
    }

    //数组旋转最小值
    public int minNumberInRotateArray(int[] array) {
        if (array.length != 0) {
            Arrays.sort(array);
            return array[0];
        }
        return 0;
    }
    //统计一个数字在排序数组的次数
    public int GetNumberOfK(int [] array , int k) {

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == k) {
                count++;
                if (i + 1 < array.length && array[i + 1] != k) {
                    break;
                }
            }
        }
        return count;
    }

    //数值二进制中1的个数
    public int NumberOf1(int n) {
        int count = 0;
        char [] ans = Integer.toBinaryString(n).toCharArray();
        for (char temp :ans) {
            if (temp == '1') count++;
        }
        return count;
    }

    //奇数位于数组前半部分，偶数位于后半部分
    public void reOrderArray(int [] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] % 2 == 0 && array[j + 1] % 2 == 1) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //数组中只出现一次的数字
    //todo
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int count = 0;
        int [] newArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            count = newArray[array[i]];
            count++;
            newArray[array[i]] = count;
        }
        int ansCount = 0;
        for (int i = 0; i < newArray.length; i++) {
            if (ansCount < 1 && newArray[i] == 1) {
                num1[0] = i;
            }
        }
    }

    // 连续子数组最大和
    public int FindGreatestSumOfSubArray(int[] array) {

        if (array == null || array.length == 0) {
            return 0;
        }

        int max = 0;
        int sum = 0;
        for (int i = 0; i <= array.length - 1; i++) {
            for (int j = i; j <= array.length - 1; j++) {
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += array[k];
                }

                if (sum > max) {
                    max = sum;
                }
            }
        }

        return max;
    }

    // 数组中出现超过一半的数字
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array.length == 0) {
            return 0;
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        Integer count = 0;
        for (int i = 0; i < array.length; i++) {
             count = hashMap.get(array[i]);
             if (count == null) {
                 hashMap.put(array[i], 1);
                 continue;
             }
             count++;
             hashMap.put(array[i], count);
        }

        int[] max = {0, 0};
        Set<Integer> set = hashMap.keySet();
        for (Integer integer : set) {
            count = hashMap.get(integer);
            if (count > max[0]) {
                max[0] = count;
                max[1] = integer;
            }
        }
        if (max[0] > array.length / 2) {
            return max[1];
        }

        return 0;
    }
    // 最小的k个数
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        if (input.length < 0) return null;
        if (k > input.length) return null;
        ArrayList arrayList = new ArrayList();
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }

        return arrayList;

    }

    public static void main(String[] args) {
        int[] a = {4,5,1,6,2,7,3,8};
//        System.out.println(new ArraySolution().MoreThanHalfNum_Solution(a));
        System.out.println(new ArraySolution().GetLeastNumbers_Solution(a, 10));
    }
}
