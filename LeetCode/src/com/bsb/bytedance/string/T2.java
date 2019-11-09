package com.bsb.bytedance.string;

import java.util.HashSet;

/**
 * @author : zengshuaizhi
 * @date : 2019-10-20 16:52
 */
public class T2 {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

    public static void main(String[] args) {
//        String[] strs = {"flower", "flow", "flight"};
//        System.out.println(new T2().longestCommonPrefix(strs));

        Character a = '我';
        Character b = '我';
        HashSet<Character> hashSet = new HashSet<>();
        hashSet.add(a);
        System.out.println(hashSet.contains(b));
    }
}
