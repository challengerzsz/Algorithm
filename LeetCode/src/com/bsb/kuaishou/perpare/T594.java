package com.bsb.kuaishou.perpare;

import java.util.HashMap;

/**
 * @author : zengshuaizhi
 * @date : 2020-04-12 11:04
 */
public class T594 {


    public int findLHS(int[] nums) {
        // 要求是在nums中找出一个子序列 满足子序列中最大元素 - 最小元素差值为1
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.containsKey(num + 1))
                res = Math.max(res, map.get(num) + map.get(num + 1));
            if (map.containsKey(num - 1))
                res = Math.max(res, map.get(num) + map.get(num - 1));
        }
        return res;
    }
}
