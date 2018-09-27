package com;

import java.time.Duration;
import java.time.Instant;

public class SortAnalyzer  {
    public void printInfo(SortingAlgorithm algorithm) {
        ArrayProvider arrProvider = new ArrayProvider();
        int[] smallArray = arrProvider.getSmallArray();
        int[] bigArray = arrProvider.getBigArray();
        int[] rangedArray = arrProvider.getArrayWithSmallRange();
        int[] nearlySortedArray = arrProvider.getNearlySortedArray();
        int[] array;

        array = smallArray.clone();
        printData("small array", array, algorithm);

        array = bigArray.clone();
        printData("big array", array, algorithm);

        array = nearlySortedArray.clone();
        printData("nearly sorted array", array, algorithm);

        array = rangedArray.clone();
        printData("array with a small range of elements", array, algorithm);
        System.out.println('\n');
    }

    public double avgTime(SortingAlgorithm algorithm){
        long[] values = new long[50];
        double avg = 0;
        ArrayProvider arrProvider = new ArrayProvider();
        for(int i = 0; i <50; i++ ){
            int[] bigArray = arrProvider.getBigArray();
            Instant start = Instant.now();
            algorithm.sort(bigArray,0,bigArray.length - 1);
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            values[i] = timeElapsed;
        }
        for ( int i = 0; i < 50; i++ ){
            avg += values[i];
        }
        return avg/50;
    }

    public double avgTime(SortingAlgorithm algorithm, int[] arr){
        long[] values = new long[50];
        double avg = 0;
        for(int i = 0; i <50; i++ ){
            int[] bigArray = arr.clone();
            Instant start = Instant.now();
            algorithm.sort(bigArray,0,bigArray.length - 1);
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toNanos();
            values[i] = timeElapsed;
        }
        for ( int i = 0; i < 50; i++ ){
            avg += values[i];
        }
        return avg/50;
    }


    public void compareHsIs(){
        HybridSort hs = new HybridSort();
        InsertionSort is = new InsertionSort();
        ArrayProvider ap = new ArrayProvider();
        for ( int i = 7; i < 200; i++) {
            int[] arr = ap.getArray(i);
            System.out.println("HS: " + avgTime(hs, arr) + "  IS: "+ avgTime(is, arr));
        }
    }

    public void compareQsHs(){
        long[] values = new long[50];
        long[] values2 = new long[50];

        double avg = 0;
        double avg2 = 0;

        QuickSort qs = new QuickSort();
        HybridSort hs = new HybridSort();
        ArrayProvider arrProvider = new ArrayProvider();

        for ( int k = 4; k < 200; k = k + 4){
            avg = 0;
            avg2 = 0;
            hs.setSwitchLength(k);
            System.out.println(">>>>switch on " + k);

            for(int i = 0; i <50; i++ ){
                int[] bigArray = arrProvider.getBigArray();
                int[] bigArray2 = bigArray.clone();
                Instant start = Instant.now();
                hs.sort(bigArray,0,bigArray.length - 1);
                Instant finish = Instant.now();
                long timeElapsed = Duration.between(start, finish).toMillis();
                values[i] = timeElapsed;

                Instant start2 = Instant.now();
                qs.sort(bigArray2,0,bigArray2.length - 1);
                Instant finish2 = Instant.now();
                long timeElapsed2 = Duration.between(start2, finish2).toMillis();
                values2[i] = timeElapsed2;
            }
            for ( int i = 0; i < 50; i++ ){
                avg += values[i];
                avg2 += values2[i];
            }
            System.out.println("HybridSort: " + avg/50 + "  QuickSort: " + avg2/50);

        }

    }

    public void printData(String arrayType, int[] arr, SortingAlgorithm algorithm) {
        System.out.println("Sorting on a "  + arrayType);

        Instant start = Instant.now();
        algorithm.sort(arr, 0, arr.length - 1);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();

        if(isSorted(arr)) {
            System.out.println("Time elapsed: " + timeElapsed + "ms");
        } else {
            System.out.println("Algorithm not working");
        }
    }

    private boolean isSorted(int[] arr) {
        for (int i=0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]) {
                return false;
            }
        }
        return true;
    }
}
