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

    // 第n个丑数
    public int GetUglyNumber_Solution(int index) {
        if (index == 0) return 0;
        // 当前的丑数都是上一个丑数* 2 3 5 得到的结果，完善这个丑数数组
        int[] uglyArray = new int[index];
        uglyArray[0] = 1;
        int m2 = 0, m3 = 0, m5 = 0, t;
        for (int i = 1; i < index; ++i) {
            t = getMin(uglyArray[m2] * 2, uglyArray[m3] * 3, uglyArray[m5] * 5);
            uglyArray[i] = t;
            if (t == uglyArray[m2] * 2) m2++;
            if (t == uglyArray[m3] * 3) m3++;
            if (t == uglyArray[m5] * 5) m5++;
        }
        return uglyArray[index - 1];
    }

    private int getMin(int a, int b, int c) {
        return Math.min(Math.min(a, b), Math.min(b, c));
    }

    public static void main(String[] args) {
//        CalculateSolution calculateSolution = new CalculateSolution();
//        System.out.println(calculateSolution.Sum_Solution(10));
//        System.out.println(new CalculateSolution().NumberOf1Between1AndN_Solution(5));
        System.out.println(new CalculateSolution().GetUglyNumber_Solution(3));
    }
}
