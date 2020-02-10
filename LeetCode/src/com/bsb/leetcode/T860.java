package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 10:44
 */
public class T860 {

    // 柠檬水找零
    public boolean lemonadeChange(int[] bills) {
        int[] map = new int[2];
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                map[0]++;
                continue;
            }
            if (bills[i] == 10) {
                map[1]++;
                if (map[0] == 0) return false;
                else map[0]--;
            }
            if (bills[i] == 20) {
                if (map[0] > 0 && map[1] > 0) {
                    map[0]--;
                    map[1]--;
                } else if (map[0] >= 3) {
                    map[0] -= 3;
                } else return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] array = {5, 5, 5, 5, 10, 5, 20, 10, 5, 5};
        System.out.println(new T860().lemonadeChange(array));
    }
}
