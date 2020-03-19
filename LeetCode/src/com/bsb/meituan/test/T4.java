package com.bsb.meituan.test;

import java.util.Scanner;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-19 17:20
 */
public class T4 {

    static class TrieTree {
        TrieTree[] map;
        int count;

        public TrieTree() {
            this.map = new TrieTree[26];
            this.count = 0;
        }

        public void insert(String str) {
            if (str == null || str.trim().length() == 0) return;
            TrieTree p = this;
            for (int i = 0; i < str.length(); i++) {
                if (p.map[str.charAt(i) - 'a'] == null) {
                    p.map[str.charAt(i) - 'a'] = new TrieTree();
                    p = p.map[str.charAt(i) - 'a'];
                } else {
                    p = p.map[str.charAt(i) - 'a'];
                }
                p.count++;
            }
        }

        public int findEnd(String str) {
            TrieTree p = this;
            int i;
            for (i = 0; i < str.length() && p != null; i++) {
                int index = str.charAt(i) - 'a';
                if (p.count == 1) break;
                p = p.map[index];
            }

            return i;
        }
    }

    // 前缀树
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strs = new String[n];
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.next();
        }
        TrieTree root = new TrieTree();
        for (String str : strs) {
            root.insert(str);
        }

        for (String temp : strs) {
            if (temp == null || temp.trim().length() == 0) {
                System.out.println("");
            }
            System.out.println(temp.substring(0, root.findEnd(temp)));
        }

    }
}
