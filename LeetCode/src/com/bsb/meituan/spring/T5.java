package com.bsb.meituan.spring;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-19 18:47
 */
public class T5 {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String mn = scanner.nextLine();
//        int n = Integer.parseInt(mn.split(" ")[0]);
//        int m = Integer.parseInt(mn.split(" ")[1]);
//        String nums = scanner.nextLine();
//        int[] arr = new int[nums.length()];
//        for (int i = 0; i < nums.length(); i++) {
//            arr[i] = nums.charAt(i) - '0';
//        }
//        for (int i = 0; i < m; i++) {
//            String query = scanner.nextLine();
//            if (query.charAt(0) == 'q') {
//                System.out.println(find(arr));
//            } else {
//                String[] range = query.split(" ");
//                int p = Integer.parseInt(range[1]);
//                int q = Integer.parseInt(range[2]);
//                for (int j = p - 1; j < q; j++) {
//                    arr[j] = arr[j] == 0 ? 1 : 0;
//                }
//            }
//        }
//    }

    private static int find(int[] nums) {
        if (nums.length == 1) return 1;
        int res = 1;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1]) {
                res++;
            } else {
                res = 1;
            }

            if (res > max) max = res;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(find(new int[]{0, 0, 0, 1, 1, 1, 0, 0, 0}));
    }
}
