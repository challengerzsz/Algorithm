package com.bsb.leetcode.tag.bytedane.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-25 19:50
 */
public class T7 {

    // 复原ip地址
    // 返回所有可能的ip地址
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        // IP地址其实只有3个. 但是这里因为继续向下递归的时候需要加上. 所以dotCount初始化为4
        backTrace(0, "", 4, s, res);
        return res;
    }

    private void backTrace(int index, String temp, int dotCount, String s, List<String> res) {

        if (dotCount < 0) return;

        // 已经选择到最后一个数字或者剩余待安排的点的数量为0
        if (index == s.length() && dotCount == 0) {
            // 去掉最后一个点
            res.add(temp.substring(0, temp.length() - 1));
            return;
        }

        for (int j = index; j < index + 3; j++) {
            if (j < s.length()) {
                // 如果是以前导0开始的 那么就只选择当前一位0
                if (index == j && s.charAt(j) == '0') {
                    backTrace(j + 1, temp + s.charAt(j) + ".", dotCount - 1, s, res);
                    break;
                }
                // 检查每一部分是不是在0～255之间的 并且不能以前导0开始
                // 如果合法就向下继续递归
                if (Integer.parseInt(s.substring(index, j + 1)) <= 255)
                    backTrace(j + 1, temp + s.substring(index, j + 1) + ".",
                            dotCount - 1, s, res);
            }
        }
    }

    public static void main(String[] args) {
        new T7().restoreIpAddresses("1111");
    }
}
