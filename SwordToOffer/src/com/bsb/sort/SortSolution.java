package com.bsb.sort;

public class SortSolution {
    //快速排序
    public void QuickSort(int a[], int start, int end) {
        int tmp, i, j, base;
        base = a[start];
        i = start;
        j = end;
        if (i >= j) return;
        while (i < j) {
            while (a[j] >= base && i < j) {
                j--;
            }
            while (a[i] <= base && i < j) {
                i++;
            }
            if (i < j) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        a[start] = a[i];
        a[i] = base;

        QuickSort(a, start, i - 1);
        QuickSort(a, i + 1, end);
    }

    //冒泡排序
    public void BubSort(int a[]) {
        int t;
        boolean b = true;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    t = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = t;
                    b = false;
                }
            }
            if (b) {
                break;
            }
        }
    }

//    public int[] sort(int [] a, int low, int high) {
//        int mid = (low + high) / 2;
//        if (low < high) {
//            sort(a, low, mid);
//            sort(a, mid + 1, high);
//            //左右归并
//            merge(a, low, mid, high);
//        }
//        return a;
//    }
//
//    public void merge(int [] a, int low, int mid, int high) {
//        int [] tmp = new int[high - low + 1];
//        int i = low;
//        int j = mid + 1;
//        int k = 0;
//
//        //把较小的数先放在新数组中
//        while (i <= mid && j <= high) {
//            if (a[i] < a[j]) {
//                tmp[k++] = a[i++];
//            } else {
//                tmp[k++] = a[j++];
//            }
//        }
//
//        //把左边剩余移入数组
//        while (i <= mid) {
//            tmp[k++] = a[i++];
//        }
//        while (j <= high) {
//            tmp[k++] = a[j++];
//        }
//
//        for (int o = 0; o < tmp.length; o++) {
//            a[o + low] = tmp[o];
//        }
//    }


    public int[] sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;

        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, high, mid);
        }

        return a;
    }

    public void merge(int[] a, int low, int high, int mid) {
        int i = low;
        int j = mid + 1;
        int[] newA = new int[high - low + 1];
        int index = 0;

        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                newA[index++] = a[i++];
            } else {
                newA[index++] = a[j++];
            }
        }

        while (i <= mid) {
            newA[index++] = a[i++];
        }

        while (j <= high) {
            newA[index++] = a[j++];
        }

        for (int o = 0; o < newA.length; o++) {
            a[o + low] = newA[o];
        }
    }

    //插入排序
    public void Isort(int[] number) {
//        int n = number.length;
//        int temp;
//        for(int i = 1; i< n; i++) {
//            for(int j = i; j>0 && number[j-1] > number[j]; j--) {
//                temp = number[j];
//                number[j] = number[j-1];
//                number[j-1] = temp;
//            }
//        }
        int temp;
        for (int i = 1; i < number.length; i++) {
            for (int j = i; j > 0 && number[j - 1] > number[j]; j--) {
                temp = number[j];
                number[j] = number[j - 1];
                number[j - 1] = temp;
            }
        }
    }

    //简单选择排序
    public void selectSort(int[] a) {
        int min = 0;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < a[min]) {
                    min = j;
                }
            }
            int t = a[min];
            a[min] = a[i];
            a[i] = t;
        }
    }


    public int search(int[] a, int target) {
        int mid;
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                high = mid - 1;
            } else low = mid + 1;

        }
        return 0;
    }
}
