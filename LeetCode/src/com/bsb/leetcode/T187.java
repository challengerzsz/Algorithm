package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-14 20:45
 */
public class T187 {


    // 重复的DNA序列
    // 查找一个序列这个序列长度大于10 并且不止出现过一次
    // 超时
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= len - 10; i++) {
            String key = s.substring(i, i + 10);
            // 之前是否存在
            if (set.contains(key)) {
                res.add(key);
            } else {
                set.add(key);
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        String str = "123";
//        System.out.println(str.indexOf("1", 1));
//        System.out.println(str.substring(0, 2));
        System.out.println(new T187().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }
}
