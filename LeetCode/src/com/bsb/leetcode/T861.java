package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-10 11:11
 */
public class T861 {

    // 翻转矩阵后的得分
    // 这题因为最后要保证每一行求和是最大的 那其实也就是说要保证每一行是最大的
    // 因为矩阵中只包含01 最后组合出来的数字也是二进制的 二进制的话就需要保证高位尽量为1来保证最大
    // 那思路就很简单了 以列为单位进行遍历 尽量保证高位为1
    // 一开始的思路把除了第一列之外的每一列的第一行都变成了1保证最大 想错了 应该是后面的每一列的1比0多
    public int matrixScore(int[][] A) {
        if (A == null || A.length == 0) return 0;
        for (int j = 0; j < A[0].length; j++) {
            if (j == 0) {
                for (int i = 0; i < A.length; i++) {
                    if (A[i][j] == 0) {
                        helperToChangeHang(A, i);
                    }
                }
            } else {
                int count1 = 0, count0 = 0;
                for (int i = 0; i < A.length; i++) {
                    if (A[i][j] == 0) count0++;
                    else count1++;
                }
                if (count0 > count1) helperToChangeLie(A, j);
            }
        }
        int res = 0;
        StringBuilder sb = new StringBuilder();
        for (int[] tempA : A) {
            sb.delete(0, sb.length());
            for (int temp : tempA) {
                sb.append(temp);
            }
            res += Integer.parseInt(sb.toString(), 2);
        }
        return res;
    }

    private void helperToChangeHang(int[][] A, int i) {
        for (int j = 0; j < A[0].length; j++) A[i][j] = A[i][j] ^ 1;
    }

    private void helperToChangeLie(int[][] A, int j) {
        for (int i = 0; i < A.length; i++) A[i][j] = A[i][j] ^ 1;
    }

    public static void main(String[] args) {
//        System.out.println(Integer.parseInt("1111", 2));
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("1234");
//        System.out.println(stringBuilder.delete(0, stringBuilder.length()));

        int[][] array = {{0, 1, 1}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(new T861().matrixScore(array));
    }
}
