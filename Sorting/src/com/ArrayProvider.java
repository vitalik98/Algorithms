package com;

import java.util.Random;

public class ArrayProvider {
    Random r;

    public int[] getSmallArray() {
     r = new Random();

     int[] smallArr = new int[10];
     for (int i = 0; i < smallArr.length; i++) {
         smallArr[i] = r.nextInt(11);
     }
     return smallArr;
    }

    public int[] getExtraSmallArray() {
        r = new Random();

        int[] smallArr = new int[8];
        for (int i = 0; i < smallArr.length; i++) {
            smallArr[i] = r.nextInt(11);
        }
        return smallArr;
    }

    public int[] getArray(int size) {
        r = new Random();

        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt();
        }
        return arr;
    }

    public int[] getBigArray() {
        r = new Random();

        int[] bigArr = new int[100000];
        for (int i = 0; i < bigArr.length; i++) {
            bigArr[i] = r.nextInt();
        }
        return bigArr;
    }

    public int[] getNearlySortedArray() {
        int[] arr = getBigArray();
        Random random = new Random();
        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length - 1);

        for(int i = 0; i < 100; i++) {
            int pos1 = random.nextInt(arr.length);
            int pos2 = random.nextInt(arr.length);
            int temp = arr[pos1];
            arr[pos2] = arr[pos1];
            arr[pos1] = temp;
        }
        return arr;
    }

    public int[] getArrayWithSmallRange() {
        r = new Random();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(11);
        }
        return arr;
    }
}
