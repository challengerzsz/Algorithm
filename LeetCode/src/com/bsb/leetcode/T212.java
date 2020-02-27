package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-14 22:21
 */
public class T212 {

    // board中同时存在的words中的单词
    // 这题一看就是dfs + 回溯的题所以基本思路是这样
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (board == null || board.length == 0) return res;

        for (String word : words) {
            if (helper(board, word)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean helper(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index) {
        // 边界
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }
        if (board[row][col] != word.charAt(index)) {
            return false;
        }

        // 搜到这个单词
        if (index == word.length() - 1) {
            return true;
        }
        // 为回溯作准备
        char temp = board[row][col];
        // 避免一次递归中重复对该元素dfs
        board[row][col] = '$';

        // 这里因为一旦从某个方向搜到该word存在 就可以直接return了 不需要在某一步继续向其他方向去dfs了
        // 但同时还需要注意 如果某一步return之前 一定要把当前递归方法改变原board数组还原
        if (dfs(board, row - 1, col, word, index + 1)) {
            board[row][col] = temp;
            return true;
        }

        if (dfs(board, row + 1, col, word, index + 1)) {
            board[row][col] = temp;
            return true;
        }
        if (dfs(board, row, col - 1, word, index + 1)) {
            board[row][col] = temp;
            return true;
        }
        if (dfs(board, row, col + 1, word, index + 1)) {
            board[row][col] = temp;
            return true;
        }
        board[row][col] = temp;
        return false;
    }


    // 首次尝试前缀树
    // 首先思考 上面的递归规模过于大 
    // 如果在board中搜索到过某串 那么这个串的所有前缀串都是可以被搜索到的 所以需要借助前缀树
    // 前缀树是一种自实现的数据结构
    // 其实思考清楚之后就是一棵26叉树。。
    class Trie {
        class TrieNode {
            TrieNode[] children;
            boolean flag;

            // 前缀树初始化
            public TrieNode() {
                children = new TrieNode[26];
                flag = false;
                for (int i = 0; i < 26; i++) {
                    children[i] = null;
                }
            }
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * 向前缀树插入一个单词
         */
        public void insert(String word) {
            char[] array = word.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < array.length; i++) {
                // 当前孩子是否存在
                if (cur.children[array[i] - 'a'] == null) {
                    cur.children[array[i] - 'a'] = new TrieNode();
                }
                // cur更新为刚刚新创建的前缀树节点
                cur = cur.children[array[i] - 'a'];
            }
            // 当前节点代表结束
            cur.flag = true;
        }

        /**
         * 判断这个前缀树中是否有包含prefix的结果
         */
        public boolean startsWith(String prefix) {
            char[] array = prefix.toCharArray();
            TrieNode cur = root;
            for (int i = 0; i < array.length; i++) {
                if (cur.children[array[i] - 'a'] == null) {
                    return false;
                }
                cur = cur.children[array[i] - 'a'];
            }
            return true;
        }

    }

    public List<String> findWords2(char[][] board, String[] words) {
        // 将单词的长度从大到小排序
        // 因为较短的串可能是较长串的前缀 
        // 先搜较长的串 添加进前缀树 
        // 之后搜索某个word之前 在前缀树中查找即可
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        
        Trie trie = new Trie();
        List<String> res = new ArrayList<>();
        for (String word : words) {
            // 简单说就是希望这里待搜索的word已经存在于前缀树中
            // 就能进一步说明board中能够搜索到这个word
            if (trie.startsWith(word)) {
                res.add(word);
                continue;
            }
            if (helper(board, word)) {
                res.add(word);
                // 加入到前缀树中
                trie.insert(word);
            }
        }
        return res;
    }



    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] strs = {"eat", "oath"};
        new T212().findWords2(board, strs);
    }

}
