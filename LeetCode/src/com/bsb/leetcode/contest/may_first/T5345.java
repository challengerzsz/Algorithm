package com.bsb.leetcode.contest.may_first;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-01 11:17
 */
public class T5345 {
    public String rankTeams(String[] votes) {
        // key是参赛团队，value是该团队每个排位获得的票数
        Map<Character, int[]> rankMap = new HashMap<>();

        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                // 这里需要注意的是 因为每个队伍可能是26个大写字母 所以value直接丢一个26长度的数组
                int[] rankArr = rankMap.getOrDefault(vote.charAt(i), new int[26]);
                rankArr[i]++;
                rankMap.put(vote.charAt(i), rankArr);
            }
        }

        List<Map.Entry<Character, int[]>> rankList = new ArrayList<>(rankMap.entrySet());

        rankList.sort((team1, team2) -> {
            int[] ranks1 = team1.getValue();
            int[] ranks2 = team2.getValue();
            // 根据投票排序
            for (int i = 0; i < 26; i++) {
                if (ranks1[i] != ranks2[i]) {
                    return ranks2[i] - ranks1[i];
                }
            }
            // 字母顺序排序
            return team1.getKey() - team2.getKey();
        });

        // 此时的map已经完成排序
        // 获得每个名次的票数最高的靠前 票数一致的按字典序排序
        return rankList.stream().map(entry -> String.valueOf(entry.getKey())).collect(Collectors.joining());
    }
}
