package com.bsb.recursive;

public class RecursiveSolution {

    //输出第n项斐波那契
    public int Fibonacci(int n) {
        int pre1 = 1, pre2 = 1;
        int result = 1;
        if (n == 0) result = 0;
        if (n >= 3) result = pre1 + pre2;

        for (int i = 4; i <= n; i++) {
            pre1 = pre2;
            pre2 = result;
            result += pre1;
        }
        return result;
    }

    public int Fibonacci2(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return Fibonacci2(n - 1) + Fibonacci2(n - 2);
    }


    //跳台阶
    public int JumpFloor(int target) {
        if (target == 1) return 1;
        else if (target == 2) return 2;
        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }


    //矩形覆盖
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        return RectCover(target - 1) + RectCover(target - 2);
    }


    //变态跳台阶
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        return 2 * JumpFloorII(target - 1);
    }
}
