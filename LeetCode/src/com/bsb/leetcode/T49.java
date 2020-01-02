package com.bsb.leetcode;

import java.util.*;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-02 21:20
 */
public class T49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> strMap = new HashMap<>();
        for (String str : strs) {
            char chars[] = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (!strMap.containsKey(key)) {
                strMap.put(key, new ArrayList<>());
            }
            strMap.get(key).add(str);
        }
//        List<List<String>> res = new ArrayList<>();
//        for (Map.Entry<String, ArrayList<String>> e : strMap.entrySet()) {
//            res.add((ArrayList<String>) e);
//        }
        // 这没找到好的办法把HashMap的值搬过来
        List<List<String>> res = new ArrayList<>(strMap.values());
        return res;
    }
}
