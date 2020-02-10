package com.bsb.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 9:46
 */
public class T842 {

    // 将数组分成斐波那契序列
    public List<Integer> splitIntoFibonacci(String num) {
        int length = num.length();
        List<Integer> res = new ArrayList<>();
        // 题目要求每一个斐波那契项最大不超过Integer.MAX_VALUE 10位数
        for (int i = 1; i <= length / 2 && i <= 10; i++) {         
            for (int j = 1; j <= length / 2 && j <= 10; j++) {    
                int max = Math.max(i, j);
                // 判断选择两个数字之后是否还能组成第三个数字 如果第三个数字的长度小于前两个中最大数字的长度 就不考虑
                if (length - i - j < max)
                    break;
                if (helper(num, i, j, res))
                    return res;
                // 排除以0开头的数字
                if (num.charAt(i) == '0')
                    break;
            }
            if (num.charAt(0) == '0')
                break;
        }
        return res;
    }
    
    // 主要是数字可能超出Integer.MAX_VALUE 所以直接判定长度不超过10即可(Integer.MAX的位数是10)
    public boolean helper(String num, int first, int second, List<Integer> res) {
        int begin = 0;
        int first1, second1, sum;
        for (int i = first + second; i < num.length(); ) {
            String sub1 = num.substring(begin, first);
            String sub2 = num.substring(first, first + second);
            // 这里取Long然后去判断是不是超过Integer的界限
            long f1 = Long.valueOf(sub1);
            long f2 = Long.valueOf(sub2);
            long sum1 = f1 + f2;
            if (f1 > Integer.MAX_VALUE || f2 > Integer.MAX_VALUE || sum1 > Integer.MAX_VALUE) {
                res.clear();
                return false;
            }
            first1 = Integer.valueOf(sub1);
            second1 = Integer.valueOf(sub2);
            sum = first1 + second1;
            String s = String.valueOf(sum);
            if (first + second + s.length() > num.length() ||
                    !num.substring(first + second, first + second + s.length()).equals(s)) {
                res.clear();
                return false;
            }
            res.add(first1);
            if (first + second + s.length() == num.length()) {
                res.add(second1);
                res.add(sum);
                break;
            }
            begin = first;
            first += second;
            second = s.length();
        }
        return true;
    }
}
