package com.bsb.array;

import java.math.BigInteger;
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
    public int GetNumberOfK(int[] array, int k) {

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
        char[] ans = Integer.toBinaryString(n).toCharArray();
        for (char temp : ans) {
            if (temp == '1') count++;
        }
        return count;
    }

    //奇数位于数组前半部分，偶数位于后半部分
    public void reOrderArray(int[] array) {
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
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int count = 0;
        int[] newArray = new int[array.length];
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
    public int MoreThanHalfNum_Solution(int[] array) {
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
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {

        if (input.length < 0) return null;
        if (k > input.length) return null;
        ArrayList arrayList = new ArrayList();
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            arrayList.add(input[i]);
        }

        return arrayList;

    }

    public boolean isContinuous(int[] numbers) {
        if (numbers.length == 0 || numbers == null) {
            return false;
        }
        Arrays.sort(numbers);
        int count = 0, poker = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0) {
                poker++;
                continue;
            }
            if (numbers[i + 1] - numbers[i] == 0) {
                return false;
            }
            if (numbers[i + 1] - numbers[i] != 1) {
                count += numbers[i + 1] - numbers[i] - 1;
            }
        }
        if (count <= poker) return true;
        return false;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int low = 1, high = 2;
        int half = sum % 2 == 0 ? sum / 2 : sum / 2 + 1;
        int count = 0;
        boolean flag = false;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (low < half && high < half) {
            int i = low;
            for (; i <= high; i++) {
                count += i;
                if (count == sum) {
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    for (int j = low; j <= high; j++) {
                        arrayList.add(j);
                    }
                    result.add(arrayList);
                    count = 0;
                    flag = true;
                    break;
                }

                if (count > sum) {
                    high--;
                    count = 0;
                    break;
                }
            }

            if (count < sum && !flag) {
                high++;
                count = 0;
                flag = false;
                continue;
            }
            low++;
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence2(int sum) {
//        int half = sum % 2 == 0 ? sum / 2 : sum / 2 + 1;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int i = 2; i < sum; i++) {
            if (checkIfCorrect(sum, i)) {
                ArrayList<Integer> list = new ArrayList<>();
                int ans = (int) ((sum / (double) i) - ((double) i / 2) + 0.5);
                if (ans == 0) {
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    list.add(ans + j);
                }
                result.add(list);
            }
        }

        Collections.sort(result, new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o2.size() - o1.size();
            }
        });

        return result;
    }

    private boolean checkIfCorrect(int sum, int i) {
        double a1 = (sum / (double) i) - ((double) i / 2) + 0.5;
        int a1int = (int) a1;
        if (a1 != a1int || a1int < 0) {
            return false;
        }
        return true;
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> result = new ArrayList<>();
        if (array == null || array.length == 0) {
            return result;
        }

        int[] min = {0, 0, 0};
        int x = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == sum) {
                    x = array[i] * array[j];
                    if (x < min[0] || min[0] == 0) {
                        min[0] = x;
                        min[1] = array[i];
                        min[2] = array[j];
                    }
                }
            }
        }

        if (min[1] == 0 && min[2] == 0) {
            return result;
        }

        result.add(min[1]);
        result.add(min[2]);

        return result;
    }

    public String ReverseSentence(String str) {
        if (str == null) {
            return null;
        }
        if (str.trim().equals("")) {
            return str;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = str.split(" ");
        for (int i = strings.length - 1; i >= 0; i--) {
            if (i == 0) {
                stringBuilder.append(strings[i]);
                break;
            }
            stringBuilder.append(strings[i]).append(" ");
        }

        return stringBuilder.toString();
    }

    public int Add(int num1, int num2) {
        BigInteger bi1 = new BigInteger(String.valueOf(num1));
        BigInteger bi2 = new BigInteger(String.valueOf(num2));
        return bi1.add(bi2).intValue();
    }

    // 不考虑进位 二进制每位做异或相当于求和 如 5 + 5 = 101 + 101
    // 不考虑进位 101 ^ 101 = 000
    // 计算进位使用按位与，将之后的结果左移1位 101 & 101 = 101 << 1 = 1010
    // 进位值和求和值相加 为1010 = 10
    public int Add2(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args) {
//        int[] a = {0, 3, 2, 6, 4};
////        System.out.println(new ArraySolution().MoreThanHalfNum_Solution(a));
//        ArrayList<ArrayList<Integer>> arrayLists = new ArraySolution().FindContinuousSequence2(9);
//        System.out.println(arrayLists.size());
//        for (ArrayList<Integer> arrayList : arrayLists) {
//            for (Integer i : arrayList) {
//                System.out.print(i + " ");
//            }
//            System.out.println(" ");
//        }

//        double a = 1.0;
//        System.out.println(a == 1);
        System.out.println(new ArraySolution().ReverseSentence(" "));
    }
}
