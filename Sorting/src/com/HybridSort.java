package com;

public class HybridSort implements SortingAlgorithm {
    int switchLength;

    HybridSort(int switchLength) {
        if (switchLength > 2) {
            this.switchLength = switchLength;
        }
    }

    HybridSort() {
        this.switchLength = 16;
    }


    public void sort(int[] arr, int l, int r) {
        if(l < r) {
            if (r - l <= switchLength) {
                insertionSort(arr, l, r);
                return;
            }

            int q = findQ(arr, l, r);
            sort(arr, l, q - 1);
            sort(arr, q + 1, r);
        }
    }

    int findQ(int[] arr, int l, int r) {
        int x = arr[r];
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
    }

    private void insertionSort(int[] arr, int l, int r) {
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

    public void setSwitchLength(int switchLength) {
        if (switchLength > 2) {
            this.switchLength = switchLength;
        }
    }
}
