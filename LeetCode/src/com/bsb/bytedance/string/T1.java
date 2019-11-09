package com.bsb.bytedance.string;

import java.util.HashSet;

/**
 * @author : zengshuaizhi
 * @date : 2019-10-20 15:46
 */
public class T1 {

    public int lengthOfLongestSubstring(String s) {
        int max = 0, i = 0, j = 0;
        HashSet<Character> hashSet = new HashSet<>();
        while (j < s.length()) {
            if (!hashSet.contains(s.charAt(j))) {
                hashSet.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
            } else {
                hashSet.removeAll(hashSet);
                for (int o = i; o < j; o++) {
                    if (s.charAt(o) == s.charAt(j)) {
                        if (o == i) {
                            i++;
                            break;
                        }
                        i = o + 1;
                    }
                }
                for (int g = i; g <= j; g++) {
                    hashSet.add(s.charAt(g));
                }
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new T1().lengthOfLongestSubstring("tmmzuxt"));
    }
}
