package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-28 21:05
 */
public class T947 {

    class UnionFindStruct {

        int[] array;

        public UnionFindStruct(int length) {
            array = new int[length];
            Arrays.fill(array, -1);
        }

        public int find(int index) {
            while (array[index] != -1) {
                index = array[index];
            }
            return index;
        }

        public void union(int x, int y) {
            int rootX = this.find(x);
            int rootY = this.find(y);
            this.array[rootX] = rootY;
        }
    }

    // 移除最多的同行或者同列的石头
    // 每次删除的时候该石头处于的行或者列上必须有别的石头存在才可以删除
    // 整个stones矩阵中最多进行多少次删除
    // 列最多为2
    // 如果某个石头所在的行和列没有别的石头存在 那么这块石头也就不能被移除
    // 并查集思路
    // 将某个石头存在的行和列组成一个连通图 通过并查集来实现计数
    // 原理上 能够删除的石头数量就是合并行列的次数
    public int removeStones(int[][] stones) {
        UnionFindStruct uFS = new UnionFindStruct(stones.length);
        int res = 0;
        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    // 这里并不去合并每个石头 只需要去考虑合并石头所在的行和列即可
                    if (uFS.find(i) != uFS.find(j)) {
                        uFS.union(i, j);
                        res++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] stones = {{0, 0}, {0, 2}, {1, 1}, {2, 0}, {2, 2}};
        new T947().removeStones(stones);
    }

}
