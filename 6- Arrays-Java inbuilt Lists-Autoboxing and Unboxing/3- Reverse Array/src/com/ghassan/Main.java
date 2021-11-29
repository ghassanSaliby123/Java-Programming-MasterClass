package com.ghassan;

import java.util.Arrays;

public class Main {
    //This example is described in the Description text file
    //It tends to reverse the numbers in an array
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println("The reversed Array is :" + Arrays.toString(reversedArray(array)));
    }

    public static int[] reversedArray(int[] array) {
        int[] reversedArray = new int[array.length];
        int j = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            reversedArray[j] = array[i];
            j++;
        }
        return reversedArray;
    }
}
