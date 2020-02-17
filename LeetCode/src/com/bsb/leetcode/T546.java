package com.bsb.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-17 12:07
 */
public class T546 {

    // 移除盒子 hard
    // 每一次都可以移除k个相同颜色的盒子 每一次移除 都可以获得k*k的积分 求如何操作能获取到的最大积分
    // 删除的盒子必须是颜色相同和连续的
    // lc的题目描述总是那么出神入化 直译外网 醉了
    // 未通过
    public int removeBoxes(int[] boxes) {
        if (boxes == null || boxes.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int temp : boxes) {
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int res = 0;
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> entry = iterator.next();
            res += entry.getValue() * entry.getValue();
            iterator.remove();
        }
        return res;
    }
    // 这题dp解看不懂 放弃了

    public static void main(String[] args) {
        int[] array = {1, 2, 1, 2, 1};
        new T546().removeBoxes(array);
    }
}
