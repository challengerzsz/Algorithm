package com.bsb.alibaba;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2019-09-17 20:02
 */
public class AllPaiLie {
    private static ArrayList<String> result = new ArrayList<>();
    private static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) {
        String inputString = new Scanner(System.in).nextLine();
        ArrayList<String> result = Permutation(inputString);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }

    public static ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0)
            return result;
        else
            Permutation(str, 0, str.length() - 1);
        result.addAll(set);
        return result;
    }

    public static void Permutation(String str, int start, int end) {
        char[] array = str.toCharArray();
        String r = null;
        if (start == end) {
            r = String.valueOf(array);
            set.add(r);
        } else {
            for (int i = start; i <= end; i++) {
                char tmp = array[start];
                array[start] = array[i];
                array[i] = tmp;

                Permutation(String.valueOf(array), start + 1, array.length - 1);

                tmp = array[start];
                array[start] = array[i];
                array[i] = tmp;
            }
        }
    }
}
