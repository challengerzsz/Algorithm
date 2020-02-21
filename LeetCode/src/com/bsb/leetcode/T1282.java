package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-21 12:15
 */
public class T1282 {

    // 用户分组
    // groupSizes保存的是每一个用户所在的用户组的人数
    // 思路 首先借助HashMap将用户组人数相等的用户放入同一个key下 然后遍历HashMap实现分组
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!hashMap.containsKey(groupSizes[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(groupSizes[i], list);
            } else {
                hashMap.get(groupSizes[i]).add(i);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : hashMap.entrySet()) {
            List<Integer> tempList = entry.getValue();
            for (int i = 0; i < tempList.size(); i++) {
                if (i % entry.getKey() == 0) {
                    res.add(new ArrayList<>());
                }
                res.get(res.size() - 1).add(tempList.get(i));
            }
        }
        return res;
    }
}
