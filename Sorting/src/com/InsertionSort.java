package com;

import java.time.Duration;
import java.time.Instant;

public class InsertionSort implements SortingAlgorithm {

    public void sort(int[] arr, int l, int r) {
        int rightEl = l;
        for(int i = l + 1; i <= r;) {
            if (arr[i] < arr[rightEl]) {;
                while (i > l && arr[i - 1] > arr[i]) {
                    swap(arr, i - 1, i);
                    i--;
                }
            }
            rightEl++;
            i = rightEl + 1;
        }
    }

    private void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
