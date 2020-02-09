package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-09 20:43
 */
public class T763 {

    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();
        if (S == null || S.length() == 0) return res;
        int[] map = new int[26];
        System.out.println(S.charAt(0) - 'a');
        map[S.charAt(0) - 'a'] = 1;
        int count;
        for (int i = 1; i < S.length(); i++) {
            count = 1;
            if (map[S.charAt(i) - 'a'] != 0) count++;
            else {
                if (i + 1 < S.length() && S.indexOf(S.charAt(i), i + 1) != -1) {
                    count++;
                    continue;
                }
                res.add(count);
            }
        }

        return res;
    }

    public List<Integer> partitionLabels2(String S) {
        // 遇到每一个字符都去寻找这个字符出现的最后一个位置
        // 如果最后一次出现的位置比当前这个位置大 即后面还会再出现一次 那么这个划分的子区间将会被扩大 并且目前不会被统计进res 
        int[] map = new int[26];
        // map存放每一个字符出现的最后位置
        for (int i = 0; i < S.length(); ++i)
            map[S.charAt(i) - 'a'] = i;

        // index为目前划分小区间的起始位置
        int j = 0, index = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length(); ++i) {
            // 寻找j和该字符出现的最后位置最大值 用于判断当前i下标是不是该字符出现的最后位置
            j = Math.max(j, map[S.charAt(i) - 'a']);
            if (i == j) {
                res.add(i - index + 1);
                index = i + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        String str = "abcc";
//        System.out.println(str.indexOf("b", 2));
        System.out.println(new T763().partitionLabels2("abc"));
//        System.out.println('a' - 'a');
    }
}
