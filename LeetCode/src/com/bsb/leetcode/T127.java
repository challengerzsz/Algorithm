package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-14 11:08
 */
public class T127 {

    // 单词接龙I
    // 初始状态为beginWord 结束状态为endWord 需要从wordList中选择可行的一些中间状态添加进开始与结束状态中
    // 每次只允许变更一个字符
    // 广搜找从beginWord到endWord变化的最短路径
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // endWord必须存在于wordList中, 否则返回0, 表示无法从beginWord变成endWord
        if (!wordList.contains(endWord))
            return 0;

        // 每个单词 beginWord endWord 和wordList中的所有单词长度一致
        int n = beginWord.length();
        // key是通用状态; value是拥有该通用状态的词
        HashMap<String, ArrayList<String>> commonsMap = new HashMap<>();
        // 记录wordList中所有元素对应的所有通用状态
        // 什么是通用状态 通用状态就是从某种begin状态能够转换成的wordList中的状态
        // 例如 wordList中有"hot" "dot" "lot" 那么这三个状态的共同状态就为"*ot"并且把这种中间状态记录为key
        // 可能的word记录为对应的value
        // 这里这么做其实主要是为了在bfs的时候需要根据这个commonMap去找自己的邻居顶点 如果说没有这个commonMap的话
        // 那么就需要花很多功夫去做当前word能转换成什么在wordList中的某个单词的操作
        wordList.forEach(
                word -> {
                    for (int i = 0; i < n; i++) {
                        String common = word.substring(0, i) + "*" + word.substring(i + 1);
                        if (!commonsMap.containsKey(common))
                            commonsMap.put(common, new ArrayList<>());
                        commonsMap.get(common).add(word);
                    }
                }
        );
        // 使用HashSet实现bfs
        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        // 记录访问过的节点 这不太好制定特殊的数组去表示 所以联想到了Set
        HashSet<String> visited = new HashSet<>();
        // 返回值的初始化为1, 由于题目提示beginWord != endWord, 所以至少需要一步变化
        int len = 1;
        while (!begin.isEmpty() && !end.isEmpty()) {
            // 双向bfs
            // 控制当前循环从哪个方向进行bfs; 让begin指向size更小的集合, 这样就不会一直从一个方向bfs了
            if (begin.size() > end.size()) {
                HashSet<String> tmp = begin;
                begin = end;
                end = tmp;
            }
            // 记录bfs时每个元素的邻居, 也就是cur的邻居
            HashSet<String> neighbor = new HashSet<>();
            for (String cur : begin) {
                // 这里的for循环是为了找begin中某个word的所有邻居节点
                // 例如commonMap中已经包含"*ot" -> "hot", "dot", "lot"这种键值对
                // 例如cur是"hot" 则cur的所有共同状态为"*ot", "h*t", "ho*"这三种情况
                // 把这三种情况在commonMap中查找 如果查找到 也就能找到cur的所有邻居
                // 说白了 也就是从begin开始bfs的时候每一步bfs到的顶点的所有可能的邻居
                for (int i = 0; i < n; i++) {
                    String tmp = cur.substring(0, i) + "*" + cur.substring(i + 1);
                    // 有了commonsMap哈希表,就不用每个位置都遍历'a'~'z'去找能够变化成的字符串是不是在wordList中了
                    // 如果cur是beginWord的话, commonsMap没有统计beginWord的通用状态
                    // 所以commonsMap.get(tmp)可能返回null, 所以要提前检查一下
                    if (!commonsMap.containsKey(tmp))
                        continue;
                    for (String str : commonsMap.get(tmp)) {
                        if (end.contains(str))
                            return len + 1;
                        if (!visited.contains(str)) {
                            visited.add(str);
                            // 记录cur的邻居
                            neighbor.add(str);
                        }
                    }
                }
            }
            // 处理完begin中的元素后, 让begin指向begin中的元素的邻居
            begin = neighbor;
            // 路径长度++
            len++;
        }
        // 执行到这里说明双向bfs没有相遇, 也就是没有找到从beginWord到endWord的路径
        return 0;
    }

    public static void main(String[] args) {
        String[] strs = {"hot", "dot", "dog", "lot", "log", "cog"};
        new T127().ladderLength("hit", "cog", Arrays.asList(strs));

    }
}
