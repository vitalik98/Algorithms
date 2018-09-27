package com;

public class CountingSort implements SortingAlgorithm{
    public void sort(int[] arr, int l, int r) {
        if(hasNoNegativeElements(arr)) {
            int max = getMax(arr);
            int[] countArray = new int[max + 1];
            for(int i: arr) {
                countArray[i]++;
            }
            for(int i = 0, j = 0; i <= max; i++) {
                for(int k = 0; k < countArray[i]; k++) {
                    arr[j] = i;
                    j++;
                }
            }
        }
    }

    private int getMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int i: arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    private boolean hasNoNegativeElements(int[] arr) {
        for(int i: arr) {
            if (i < 0) {
                return false;
            }
        }
        return true;
    }
}
