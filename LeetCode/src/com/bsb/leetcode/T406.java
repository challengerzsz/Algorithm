package com.bsb.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-08 19:35
 */
public class T406 {

    // 拿到题看了示例以为直接排序就ok但是只过了2个用例
    // 输入:
    // [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    // 输出:
    // [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    // 注意[4,4]排到了后面 我以为people[i][1]的意思是这个人前面还有这么多大于或等于他身高的人
    public int[][] reconstructQueue(int[][] people) {
        // 按照身高降序排列
        // 先安排最高身高的 直接把安排的一组身高相同的人通过k的不同安排到不同的index上去
        Arrays.sort(people, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0]);
        List<int[]> res = new LinkedList<>();
        for(int[] temp : people){
            // 利用list的插入方式解决index冲突问题
            res.add(temp[1], temp);
        }

        int n = people.length;
        // list转换为数组 这次终于学会了list转数组不会报error或者警告了
        return res.toArray(new int[n][2]);
    }
}
