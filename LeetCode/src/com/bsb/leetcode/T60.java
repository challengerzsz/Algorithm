package com.bsb.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : zengshuaizhi
 * @date : 2020-01-04 16:20
 */
public class T60 {

    // 全排列 + 第k项
    // 这题题解五花八门.. 其中还有很多数学解法
    public String getPermutation(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int[] fac = new int[n + 1];
        fac[0] = 1;
        for(int i = 1; i <= n; i++){
            fac[i] = fac[i - 1] * i;
        }
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int cnt = (k - 1) / fac[n - 1] + 1;
            int num = 0;
            while(cnt > 0){
                num ++;
                if(!set.contains(num)){
                    cnt --;
                }
            }
            sb.append(num);
            set.add(num);
            k = (k - 1) % fac[n - 1] + 1;
            n--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        new T60().getPermutation(123, 3);
    }
}
