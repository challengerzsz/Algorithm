package com.bsb.sword;

/**
 * @Author: zengshuaizhi
 * @Date: 2019-03-31 16:43
 */
public class DuplicateArrayMember {

    public boolean duplicate(int numbers[],int length,int [] duplication) {

         if (null == numbers || numbers.length == 0) {
             duplication[0] = -1;
             return false;
         }

         int temp = 0;
         int numberi = 0;
         for (int i = 0; i <= length - 1; i++) {

             while (true) {
                 numberi = numbers[i];
                 if (numberi != i) {
                     if (numbers[numberi] == numberi) {
                         duplication[0] = numberi;
                         return true;
                     } else {
                         numbers[i] = numbers[numberi];
                         numbers[numberi] = numberi;
                     }
                 }else {
                     break;
                 }
             }
         }
         return false;
    }

    public static void main(String[] args) {
        int [] numbers = null;
        if (new DuplicateArrayMember().duplicate(numbers, 0, new int[] {1})) {
            System.out.println("yes");
        }

    }
}
