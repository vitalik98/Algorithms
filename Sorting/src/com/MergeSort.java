package com;

public class MergeSort implements SortingAlgorithm{

    public void sort(int[] arr,  int left, int right) {
    int start = left;
    int end = right;

    mergeSort(arr, start, end);
    }

    private void mergeSort(int[] arr, int start, int end) {
        if ( start < end ) {
            int middle = start + (end - start) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);

            merge(arr, start, middle, end);
        }
    }

    private void merge(int[] arr, int start, int middle, int right){
        int lengthLeft = middle - start + 1;
        int lengthRight = right - middle;

        int[] leftArray = new int[lengthLeft];
        for(int i = 0; i < lengthLeft; i++) {
            leftArray[i] = arr[i + start];
        }

        int[] rightArray = new int[lengthRight];
        for(int i = 0; i < lengthRight; i++) {
            rightArray[i] = arr[i + middle + 1];
        }

        int i = 0, j = 0, k = start;
        while(i < lengthLeft && j < lengthRight) {
            if(leftArray[i] <= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < lengthLeft) {
            arr[k] = leftArray[i];
            i++; k++;
        }

        while (j < lengthRight) {
            arr[k] = rightArray[j];
            j++; k++;
        }
    }
}