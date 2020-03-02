package com.bsb.leetcode.interview;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author : zengshuaizhi
 * @date : 2020-03-02 10:15
 */
public class T50 {

    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new LinkedHashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Iterator it = map.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Character, Integer> entry = (Entry<Character, Integer>) it.next();
            System.out.println(entry.getKey());
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }
}
