package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-30 20:41
 */
public class T299 {

    // 猜数字 这题感觉比较神叨
    public String getHint(String secret, String guess) {
        int m = secret.length();
        int[] arraySecret = new int[10];
        int[] arrayGuess = new int[10];
        int a, b;
        int A = 0, B = 0;
        for (int i = 0; i < m; i++) {
            a = secret.charAt(i) - '0';
            b = guess.charAt(i) - '0';
            if (a == b)
                A++;
            arraySecret[a]++;
            arrayGuess[b]++;
        }
        for (int i = 0; i < 10; i++) {
            B += Math.min(arraySecret[i], arrayGuess[i]);
        }
        B -= A;
        return A + "A" + B + "B";
    }
}
