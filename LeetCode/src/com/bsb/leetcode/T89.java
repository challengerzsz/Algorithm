package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-27 09:49
 */
public class T89 {

    // 格雷编码
    // 二进制数字系统 每两个相邻的数字之间的格雷编码只能有一位不同
    // 例如n = 2
    // 输出: [0,1,3,2]
    // 解释:
    // 00 - 0
    // 01 - 1
    // 11 - 3 此处如果是2的话那么所对应的二进制两位与1所表示的两位二进制发生改变 不符合题意
    // 10 - 2
    // 格雷编码必须以0开头
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        // 初始化 n = 0 的解 格雷编码的结果数量为2^n
        res.add(0);

        for (int i = 0; i < n; i++) {
            // 下一个数字要加的数
            int add = 1 << i;
            // 从后向前遍历之前得出的编码，并且加上add添加到结果中
            // 从后往前的目的是为了让新的格雷编码和之前res最后一位能够只有一位是不同的
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + add);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new T89().grayCode(3);
    }
}
