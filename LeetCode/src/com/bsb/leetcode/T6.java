package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2019-12-28 13:00
 */
public class T6 {

    public String convert(String s, int numRows) {
        // numRows为1或0 的时候是特殊情况 会导致下面index越界
        if (numRows < 2) return s;
        String[] resArray = new String[numRows];
        // flag是组成z型排列的时候决定是从上到下还是从下到上
        // abcdefg 3
        // a   e  -> resArray[0] = ae
        // b d f  -> resArray[1] = bdf
        // c   g  -> resArray[2] = cg
        // 遍历resArray组合字符串即可
        int flag = -1, index = 0;
        for (int i = 0; i < numRows; i++) resArray[i] = "";
        for (int i = 0; i < s.length(); ++i) {
            resArray[index] += s.charAt(i);
            if (index == 0 || index == numRows - 1) flag = -flag;
            index += flag;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : resArray) {
            stringBuilder.append(str);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        new T6().convert("11", 1);
    }
}
