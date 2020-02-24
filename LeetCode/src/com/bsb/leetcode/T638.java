package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-24 15:53
 */
public class T638 {

    // 大礼包
    // price表示每种单个商品的价格
    // special表示大礼包的内容 其中0 ～ n - 2表示每个单品捆绑在大礼包中的个数 [n - 1]表示某个大礼包的价格
    // needs表示最终需要的每个单品的个数
    // 求组合成needs中每个单品的个数的花费最少的方案是多少
    // 可以考虑大礼包 + 单品的组合
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 记忆化
        // 记忆化的本质需要区分在递归过程中会重复计算的子问题是什么
        // 这里很显然就是每一趟还需要的单个商品集合 所以将needs作为map的key进行记忆化优化递归时间复杂度
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        return helper(price, special, needs, map);
    }

    private int helper(List<Integer> price, List<List<Integer>> special,
                       List<Integer> needs, HashMap<List<Integer>, Integer> map) {
        if (map.containsKey(needs)) return map.get(needs);
        int i;
        // 计算所需的商品全部用单品来购买的总价
        int res = countBySingle(needs, price);
        // 每一趟都遍历所有的大礼包
        // 选择是否需要这个大礼包
        for (List<Integer> temp : special) {
            ArrayList<Integer> newNeeds = new ArrayList<>(needs);
            // 对每一种商品进行判断
            for (i = 0; i < needs.size(); i++) {
                // 用礼包中的每种商品的数量减去所需的每种商品的数量
                int stillNeed = newNeeds.get(i) - temp.get(i);
                // stillNeed表示买掉这个大礼包后还需要多少该商品
                // 如果这个stillNeed < 0的话也就证明这一个大礼包所需的这个单品太多了 就选择不要
                if (stillNeed < 0) break;
                // 更新还需要的商品数量
                newNeeds.set(i, stillNeed);
            }

            // 这里i == need.size()的时候temp.get(i) 就是决定买当前这个大礼包的价格 题目规定
            if (i == needs.size())
                res = Math.min(res, temp.get(i) + helper(price, special, newNeeds, map));
        }
        map.put(needs, res);
        return res;
    }

    // 计算每一趟所需的每种商品全部用单品的价格购买的总价
    private int countBySingle(List<Integer> price, List<Integer> need) {
        int count = 0;
        for (int i = 0; i < price.size(); i++) {
            count += price.get(i) * need.get(i);
        }
        return count;
    }
}
