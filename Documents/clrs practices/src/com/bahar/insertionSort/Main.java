package com.bahar.insertionSort;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] numbers={2,8,7,4,3,2,3,0,5,1,23,65,98,77 };
        //version 1 {}; version2 {2}; version 3 {4,3,5};
        InsertionSort sorter= new InsertionSort();
        sorter.sort(numbers);
        System.out.println(Arrays.toString(numbers));

    }
}
