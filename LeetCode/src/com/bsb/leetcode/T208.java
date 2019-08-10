package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-07-27 15:51
 */
public class T208 {

    class Trie {



        /** Initialize your data structure here. */
        public Trie() {

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return true;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return true;
        }
    }

    class Node {
        private char content;
        /**
         * 0 非结尾 1 单词结束符
         */
        private int flag;

        private Node left;

        private Node right;

        public Node(char content, int flag) {
            this.content = content;
            this.flag = flag;
        }
    }
}
