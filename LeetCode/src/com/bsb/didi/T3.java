package com.bsb.didi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-19 19:42
 */
public class T3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int a = 0; int b = 0;
        for (int i = 1; i < n; i++) {
            hashMap.put(i, 0);
        }

        if (n == 1 || n == 0) {
            System.out.println(0);
            return;
        }
        if (n == 2) {
            System.out.println(2);
            return;
        }

        int count = 0;
        for (int i = 0; i < m; i++) {
            if ((n - count) / 2 == 0) {
                break;
            }
            int p = scanner.nextInt();
            int q = scanner.nextInt();
            int value;
            if ((value = hashMap.get(p)) != 0 && hashMap.get(q) == 0) {
                if (value == 1) {
                    hashMap.put(q, 2);
                    b++;
                    count++;
                } else if (value == 2) {
                    hashMap.put(q, 1);
                    a++;
                    count++;
                }
                continue;
            }
            if ((value = hashMap.get(q)) != 0 && hashMap.get(p) == 0) {
                if (value == 1) {
                    hashMap.put(p, 2);
                    b++;
                    count++;
                } else if (value == 2) {
                    hashMap.put(p, 1);
                    a++;
                    count++;
                }
                continue;
            }

            hashMap.put(p, 1);
            hashMap.put(q, 2);
            a++;
            b++;
        }


        int left = 0;
        for (Map.Entry e : hashMap.entrySet()) {
            if ((int)e.getValue() == 0) {
                left++;
            }
        }

        System.out.println(a + b + left / 2);
    }
}
