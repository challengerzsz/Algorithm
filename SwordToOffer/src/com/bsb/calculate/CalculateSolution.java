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

    // 1-n之间1出现的次数
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            count += checkIfNumberHas1(i);
        }
        return count;
    }

    private int checkIfNumberHas1(int n) {
        int count = 0;
        while (n != 0) {
            if (n % 10 == 1) count++;
            n /= 10;
        }
        return count;
    }


    public static void main(String[] args) {
//        CalculateSolution calculateSolution = new CalculateSolution();
//        System.out.println(calculateSolution.Sum_Solution(10));
        System.out.println(new CalculateSolution().NumberOf1Between1AndN_Solution(5));
    }
}
