package com.bsb.leetcode;

/**
 * @author : zengshuaizhi
 * @date : 2020-02-14 17:02
 */
public class T165 {

    // 版本号比较
    public int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int i = 0, j = 0;
        while (i < nums1.length || j < nums2.length) {
            // 这里需要做一些处理 因为如果后序没有有效的版本号了我们用0代替
            String num1 = i < nums1.length ? nums1[i] : "0";
            String num2 = j < nums2.length ? nums2[j] : "0";
            int res = compare(num1, num2);
            if (res == 0) {
                i++;
                j++;
            } else {
                return res;
            }
        }
        return 0;
    }

    private int compare(String num1, String num2) {
        // 这里用Integer的api直接能解决前导有0的情况
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        return Integer.compare(a, b);
    }
}
