package com.bsb.str;

import java.util.*;

public class StrSolution {
    //字符串替换
    public String replaceSpace(StringBuffer str) {
        String strR = String.valueOf(str);
        String newStr = strR.replace(" ", "%20");

        return newStr;
    }

    //左旋字符串
    public String LeftRotateString(String str, int n) {

        if (n > str.length()) return "";
        String temp = str.substring(0, n);

        return str.substring(n, str.length()) + temp;
    }

    // 全排列
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        HashSet<String> set = new HashSet<>();

        fun(set, str.toCharArray(), 0);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }

    private void fun(HashSet<String> re, char[] str, int k) {
        if (k == str.length) {
            re.add(new String(str));
            return;
        }
        for (int i = k; i < str.length; i++) {
            swap(str, i, k);
            fun(re, str, k + 1);
            swap(str, i, k);
        }
    }

    private void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }

    // 第一次只出现一次的字符
    LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(map.containsKey(ch)) {
            map.put(ch,-1);
        } else {
            map.put(ch, 1);
        }
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        Iterator<Character> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            char cur = iterator.next();
            if(map.get(cur) == 1) {
                return cur;
            }
        }
        return '#';
    }


    public static void main(String[] args) {

        System.out.println(new StrSolution().FirstAppearingOnce());
//        String str1 = new String("1") + new String("2");
//        String str2 = new String("1") + new String("12");
//        String str3 = new String("1") + new String("12231");
//        String str4 = new String("a") + new String("90184");
//        String str5 = new String("2") + new String("190kb");
//        System.out.println(str1.intern() == str1);
//        System.out.println(str2.intern() == str2);
//        System.out.println(str3.intern() == str3);
//        System.out.println(str4.intern() == str4);
//        System.out.println(str5.intern() == str5);
//        String tt = "1212";


//        String str = new String("1") + new String("122");
//        System.out.println(str == str.intern());


//        String str1 = new String("123");
//        String str = "123";
//        System.out.println(str1.intern() == str1);

//        int i = 100;
//        System.out.println(i % 10);
//        System.out.println(i);

        new StrSolution().Permutation("");
    }

}
