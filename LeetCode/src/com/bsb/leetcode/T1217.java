package com.bsb.leetcode;

import java.util.Arrays;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-20 20:00
 */
public class T1217 {

    // 玩筹码
    // chips数组保存每个筹码所在的位置
    // 最终 使用最小的代价将所有的筹码都放在一个位置
    // 让某个筹码向左或向右移动2步的代价为0 向左或向右移动1步的代价为1
    // 思路 计算整个筹码位置数组的众数 所有其余的位置的筹码向众数位置移动 能移动2步就移动2步 否则移动1步
    // 想到这里写了10行代码 突然感觉这样很麻烦
    // 其实思路应该是这样的 如果移动偶数位数 那么代价为0 那么肯定贪心地去移动2步
    // 如果某个筹码在奇数位 移动到奇数位是不需要代价的 偶数位也同理
    // 那么其实就是计算落在奇数位上的筹码多还是偶数位上的筹码多了
    // 如果奇数位的筹码多 那么直接返回落在偶数位置上的筹码数就好了 因为偶数的筹码都可以移动一位到奇数位 然后无代价地移动
    public int minCostToMoveChips(int[] chips) {
        int ji = 0, ou = 0;
        for (int chip : chips) {
            if (chip % 2 == 0) ou++;
            else ji++;
        }
        return Math.min(ji, ou);
    }
}
