package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-27 16:21
 */
public class T1286 {

    private String characters;
    private int index = 0;
    private List<int[]> combination = new ArrayList<>();

    public T1286(String characters, int combinationLength) {
        this.characters = characters;
        helper(new int[combinationLength], 0, 0, characters.length());
    }
    // 回溯生成combinationLength长度的下标数组 在next方法中拼接调用
    private void helper(int[] pos, int index, int start, int len) {
        if (index >= pos.length) {
            combination.add(Arrays.copyOf(pos, pos.length));
            return;
        }
        for (int i = start; i < len; i++) {
            pos[index] = i;
            helper(pos, index + 1, i + 1, len);
        }
    }

    public String next() {
        int[] next = this.combination.get(index);
        StringBuilder sb = new StringBuilder();
        for (int temp : next) {
            sb.append(characters.charAt(temp));
        }
        index++;
        return sb.toString();
    }

    public boolean hasNext() {
        return index < combination.size();
    }


    public static void main(String[] args) {
        T1286 t = new T1286("123", 2);
        System.out.println(t.next());
    }
}
