package com.bsb.calculate;

public class CalculateSolution {

    //不使用关键字求和前n项
    public int Sum_Solution(int n) {
        return ((n + 1) * n) / 2;
    }

    //字符串转换成整数
    public int StrToInt(String str) {
        int ans = 0;
        try {
            ans = Integer.parseInt(str);

        } catch (NumberFormatException ex) {
            ans = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        CalculateSolution calculateSolution = new CalculateSolution();
        System.out.println(calculateSolution.Sum_Solution(10));
    }
}
