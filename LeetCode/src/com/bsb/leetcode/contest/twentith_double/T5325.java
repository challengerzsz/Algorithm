package com.bsb.leetcode.contest.twentith_double;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-22 22:49
 */
public class T5325 {

    // 超时
    public int numberOfSubstrings(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean a = false;
            boolean b = false;
            boolean c = false;
            for (int j = i; j < s.length(); j++) {

                if (s.charAt(j) == 'a') a = true;
                if (s.charAt(j) == 'b') b = true;
                if (s.charAt(j) == 'c') c = true;
                if (a && b && c) {
                    res += s.length() - i - j;
                    break;
                }
            }
        }
        return res;
    }

    public int numberOfSubstrings2(String s) {
        int res = 0;
        int n = s.length();
        int[] map = new int[3];
        map[s.charAt(0) - 'a']++;
        map[s.charAt(1) - 'a']++;
        int i = 0;
        // 这里其实和上面map预留的值有关系  并且和下面的左窗口移动也有关系
        // 左窗口每次向右移动一格 j = i + 2 我们希望的是i ～j能够满足三个字符同时存在
        for (int j = i + 2; j < n; j++) {
            map[s.charAt(j) - 'a']++;
            while (map[0] != 0 && map[1] != 0 && map[2] != 0) {
                // 这里的res其实就是以i为开头的所有结果
                // 我思路就是这样 没想到滑动窗口来了个O(n^2)超时 唉
                res += n - j;
                // 滑动窗口 移动左侧i的标记 直到窗口中不满足同时存在abc 然后j右移 窗口向右拓展
                map[s.charAt(i++) - 'a']--;
            }
        }
        return res;
    }


    public static void main(String[] args) {
//        System.out.println("123".substring(0, 2));
        System.out.println(new T5325().numberOfSubstrings2("aaacb"));
    }
}
