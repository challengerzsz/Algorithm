package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-21 11:17
 */
public class T1276 {

    // 不浪费原料的汉堡制作方案
    // 巨无霸汉堡 4片番茄和1片奶酪
    // 小皇堡 2片番茄和1片奶酪
    // 如果能够不浪费任何的材料 就返回[巨无霸汉堡数量, 小皇堡]
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if (tomatoSlices % 2 == 1) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        if (tomatoSlices == 0 && cheeseSlices == 0) {
            res.add(0);
            res.add(0);
            return res;
        }
        if (tomatoSlices < 4 && cheeseSlices == 1) {
            res.add(0);
            res.add(1);
            return res;
        } else if (tomatoSlices >= 4 && cheeseSlices >= 1) {
            for (int small = cheeseSlices; small >= 1; small--) {
                if (small * 2 + (cheeseSlices - small) * 4 == tomatoSlices) {
                    res.add(cheeseSlices - small);
                    res.add(small);
                    return res;
                }
            }
        }
        return res;
    }
}
