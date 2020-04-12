package com.bsb.kuaishou.test;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-12 15:48
 */
public class T1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str == null || str.trim().length() == 0) System.out.println(0 + " " + 0 + " " + 0);

        int match = 0;
        int left = 0;
        int right = 0;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != '(' && str.charAt(i) != ')') continue;
            Character c = str.charAt(i);
            if (c == '(') stack.push(c);
            else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    match++;
                } else {
                    right++;
                }
            }
        }

        left = stack.size();
        System.out.println(match + " " + left + " " + right);
    }
}
