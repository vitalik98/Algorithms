package com;

public class Main {

    public static void main(String[] args) {
	SortAnalyzer analyzer = new SortAnalyzer();

//    System.out.println("-----------Quick sort-----------");
//    QuickSort qs = new QuickSort();
//    System.out.println(analyzer.avgTime(qs));
//
//    System.out.println("------------Merge Sort-----------");
//    MergeSort ms = new MergeSort();
//    System.out.println(analyzer.avgTime(ms));
//
//    System.out.println("------------Hybrid Sort-----------");
//    HybridSort hs = new HybridSort();
//    for ( int i = 4; i < 200; i = i + 4){
//        hs.setSwitchLength(i);
//        System.out.println(">>>>switch on " + i);
//        System.out.println(analyzer.avgTime(hs));
//    }
//
//    System.out.println("------------Counting Sort-----------");
//    CountingSort cs = new CountingSort();
//    analyzer.printInfo(cs);

    System.out.println("------------COMPARE HS FEAT QS-----------");

    analyzer.compareQsHs();
//    System.out.println("------------COMPARE HS FEAT QS-----------");
//    analyzer.compareHsIs();

    }
}
