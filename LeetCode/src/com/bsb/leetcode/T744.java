package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-26 19:37
 */
public class T744 {

    // 寻找比target大的最小字符
    // target可能不在数组中
    public char nextGreatestLetter(char[] letters, char target) {
        for (char temp : letters)
            if (temp > target) return temp;
        return letters[0];
    }

    public char nextGreatestLetter2(char[] letters, char target) {
        boolean[] seen = new boolean[26];
        for (char temp : letters)
            seen[temp - 'a'] = true;

        while (true) {
            // 直接target++ 找比target大的元素
            target++;
            // 这里重置为a是因为letters数组是一个环形
            if (target > 'z') target = 'a';
            if (seen[target - 'a']) return target;
        }
    }
}
