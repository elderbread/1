package com.zyb.sort;

import java.math.BigDecimal;
import java.math.RoundingMode;

import cn.hutool.core.util.ArrayUtil;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("----------------------------------------------");
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];
        for (int i = 0; i < 10; i++) {
            arr1[i] = new BigDecimal(Math.random()*100).setScale(0,RoundingMode.UP).intValue();
            arr2[i] = new BigDecimal(Math.random()*100).setScale(0,RoundingMode.UP).intValue();
        }
        System.out.println("original data:\narr1:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.printf(arr1[i]+"\t");
        }
        System.out.printf("\narr2:\n");
        for (int i = 0; i < arr2.length; i++) {
            System.out.printf(arr2[i]+"\t");
        }
        System.out.println();
        System.out.println("sort arr:");
        // int[] arr1 = new int[]{1,3,4,6};
        // int[] arr2 = new int[]{2,3,5,9};
        int[] sortArr = mergeAndSort(divideAndSort(arr1),divideAndSort(arr2));
        for (int i : sortArr) {
            System.out.printf(i+"\t");
        }
        System.out.println();
    }

    private static int[] mergeAndSort(int[] arr1, int[] arr2) {
        int index1 = 0;
        int index2 = 0;
        int[] sortArr = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length + arr2.length; i++) {
            if (index1 == arr1.length) {
                sortArr[i] = arr2[index2];
                index2++;
                continue;
            }
            if (index2 == arr2.length) {
                sortArr[i] = arr1[index1];
                index1++;
                continue;
            }
            if (arr1[index1] >= arr2[index2]) {
                sortArr[i] = arr2[index2];
                index2++;
            } else {
                sortArr[i] = arr1[index1];
                index1++;
            }
        }
        return sortArr;
    }

    private static int[] divideAndSort(int[] arr) {
        int length = arr.length;
        if (length == 1) {
            return arr;
        } else {
            int divideLength = new BigDecimal(length/2).setScale(0,RoundingMode.UP).intValue();
            int[] arr1 = ArrayUtil.sub(arr, 0, divideLength);
            int[] sortArr1 = divideAndSort(arr1);
            int[] arr2 = ArrayUtil.sub(arr, divideLength, length);
            int[] sortArr2 = divideAndSort(arr2);
            return mergeAndSort(sortArr1, sortArr2);
        }
    }

}