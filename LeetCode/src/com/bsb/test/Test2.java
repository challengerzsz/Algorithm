package com.bsb.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-06 14:26
 */
public class Test2 {

    public int removeMin(int[][] list) {
        if (list == null || list.length == 0) return 0;
        int removeCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(list[0][0], list[0][1]);

        boolean flag;
        for (int i = 1; i < list.length; i++) {
            flag = false;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if ((entry.getKey() <= list[i][0] && list[i][0] > entry.getValue()
                        || entry.getKey() == list[i][0] && entry.getValue() == list[i][1])) {
                    removeCount++;
                    flag = true;
                    break;
                }
            }
            if (!flag) map.put(list[i][0], list[i][1]);
        }

        return removeCount;
    }

    /**
     * 将区间数组按照结束的位置进行排序
     * 从最早结束的区间开始 如果发现有与这个最早结束的区间重合的 直接删除
     * 如果遇到不与第一个重叠的区间则将这个区间视为第一个最早结束的区间 继续上述操作
     * 直到数组遍历完成
     * @param intvs
     * @return
     */
    public int intervalSchedule(int[][] intvs) {
        if (intvs.length == 0) return 0;
        // 按区间结束的位置升序排序区间
        Arrays.sort(intvs, (a, b) -> a[1] - b[1]);
        // 至少有一个区间不相交
        // count到最后表示保留下来的区间
        int count = 1;
        // 将第一个区间end视为最早完成的end
        int earlyEnd = intvs[0][1];
        for (int[] interval : intvs) {
            int start = interval[0];
            // 如果这个区间和最早结束区间不重叠 更新最早结束区间的end
            if (start >= earlyEnd) {
                count++;
                earlyEnd = interval[1];
            }
        }
        return intvs.length - count;
    }


    public static void main(String[] args) {
        int[][] test1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        int[][] test2 = {{1, 2}, {1, 2}, {1, 2}};
        int[][] test3 = {{1, 2}, {2, 3}};
        Test2 test2Obj = new Test2();
        System.out.println(test2Obj.removeMin(test1));
        System.out.println(test2Obj.removeMin(test2));
        System.out.println(test2Obj.removeMin(test3));

    }
}
