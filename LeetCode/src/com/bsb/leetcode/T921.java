package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 16:15
 */
public class T921 {

    // 添加最小的括号 使S成为有效括号对
    public int minAddToMakeValid(String S) {
        int left = 0, right = 0;
        for (char temp : S.toCharArray()) {
            if (temp == '(') left++;
            if (temp == ')') {
                if (left != 0) {
                    left--;
                } else right++;
            }
        }
        return left + right;
    }

    public static void main(String[] args) {
        System.out.println(new T921().minAddToMakeValid("())"));
    }
}
