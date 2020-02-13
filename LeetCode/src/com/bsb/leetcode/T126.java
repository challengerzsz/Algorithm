package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-13 16:10
 */
public class T126 {

    int min = Integer.MAX_VALUE;
    
    // 单词接龙
    // 从beginWord转换为endWord 并且 转换每一次只能改动一个字符 且改动后的word必须为wordList中的
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        // temp 用来保存当前的路径
        temp.add(beginWord);
        helper(beginWord, endWord, wordList, temp, ans);
        return ans;
    }

    // dfs
    private void helper(String beginWord, String endWord, List<String> wordList,
                                   ArrayList<String> temp, List<List<String>> ans) {
        if (beginWord.equals(endWord)) {
            // 如果不是最小次数 就把结果集清空
            if (min > temp.size()) {
                ans.clear();
                min = temp.size();
                ans.add(new ArrayList<>(temp));
            } else if (min == temp.size()) {
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        // 剪枝 如果dfs的时候修改次数大于了min直接就return
        if (temp.size() >= min) {
            return;
        }
        // 遍历当前所有的单词
        for (int i = 0; i < wordList.size(); i++) {
            String curWord = wordList.get(i);
            // 路径中已经含有当前单词，如果再把当前单词加到路径，会使得路径更长，所以跳过
            if (temp.contains(curWord)) {
                continue;
            }
            // 如果begin和curWord只有一个字符不相等，就继续dfs
            if (change(beginWord, curWord)) {
                temp.add(curWord);
                helper(curWord, endWord, wordList, temp, ans);
                temp.remove(temp.size() - 1);
            }
        }
    }
    private boolean change(String beginWord, String curWord) {
        int count = 0;
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != curWord.charAt(i)) {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        return count == 1;
    }
}
