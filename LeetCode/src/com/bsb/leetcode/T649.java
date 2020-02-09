package com.bsb.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-09 10:11
 */
public class T649 {


    public String predictPartyVictory(String senate) {

        // 因为题目的议员出现是具有一定顺序的 所以使用队列
        Queue<Integer> queue = new LinkedList<>();
        // index == 0 => Dire
        // index == 1 => Radiant
        // people数组表示每一个阵营目前有能够投票的人数
        // bans数组表示每一个阵营目前被禁止权利的人数
        int[] people = new int[]{0, 0};
        int[] bans = new int[]{0, 0};

        for (char temp : senate.toCharArray()) {
            int index = temp == 'R' ? 1 : 0;
            people[index]++;
            queue.add(index);
        }

        while (people[0] > 0 && people[1] > 0) {
            int index = queue.poll();
            // 如果index阵营有被禁止表决权的人 people数组index阵营--
            // 并且更新bans[index]
            if (bans[index] > 0) {
                bans[index]--;
                people[index]--;
            } else {
                // 投票给另一个阵营 使另一个阵营丧失表决权
                // 这里用异或 0 ^ 1 = 1 1 ^ 1 = 0 表示给另一个阵营投禁止表决票
                bans[index ^ 1]++;
                // 这里需要重新入队 因为上面poll出来了 这个议员还需要参加下一轮的表决
                queue.add(index);
            }
        }

        // 根据最后people数组的情况决定是哪个阵营胜利
        return people[1] > 0 ? "Radiant" : "Dire";
    }

}
