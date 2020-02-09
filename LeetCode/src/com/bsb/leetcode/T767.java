package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-09 21:31
 */
public class T767 {

    public String reorganizeString(String S) {
        
        int length = S.length();
        if (length == 1) return S;
        
        int[] map = new int[26];
        // 统计出现次数最多的字符次数
        int max = 0;
        for (char temp : S.toCharArray()) {
            if (++map[temp - 'a'] > max) max = map[temp - 'a'];
        }
        // 如果出现最多的次数大于数组长度的一半 那么一定不能够组成交替出现不同字符的结果
        if (max > (length + 1) / 2) return  "";

        char[] res = new char[S.length()];
        // even表示偶数 odd表示奇数
        int even = 0, odd = 1;
        for (int i = 0; i < 26; i++) {
            // 奇偶位置交替放置字符
            while (map[i] > 0 && map[i] < (length / 2 + 1) && odd < length) {
                res[odd] = (char) (i + 'a');
                map[i]--;
                odd += 2;
            }
            while (map[i] > 0) {
                res[even] = (char) (i + 'a');
                map[i]--;
                even += 2;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        new T767().reorganizeString("abc");
    }
}
