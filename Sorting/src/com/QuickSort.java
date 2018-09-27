package com;

public class QuickSort implements  SortingAlgorithm {
    public void sort(int[] arr, int l, int r) {
        if(l < r) {
          int q = findQ(arr, l, r);
          sort(arr, l, q - 1);
          sort(arr, q + 1, r);
        }
    }

    int findQ(int[] arr, int l, int r) {
        int x = arr[r];
//        System.out.println("pivot: " + x + " left: " + l +" right: " + r);
//        swap(arr, l, r);

        int q = l;
        for(int i = l; i <= r; i++) {
            if (arr[i] < x) {
                swap(arr, i, q);
                q++;
            }
        }
        swap(arr, r, q);
        return q;
    }

    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
//        System.out.println("Swap arr["+i+"] = " + arr[i] + " with arr[" + j + "] = " + arr[j]);
//        print(arr);
    }

    void print(int[] arr) {
        for(int i: arr) System.out.print(i + " ");
        System.out.println('\n');
    }
}
