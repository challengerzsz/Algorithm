package com.bsb.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2019-11-10 17:29
 */
public class T17 {

    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
        if (digits.trim().length() == 0) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        new T17().letterCombinations("23");
    }
}
