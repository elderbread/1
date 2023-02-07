package com.zyb.sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,3,4,6};
        int[] arr2 = new int[]{2,3,5,9};
        int[] sortArr = mergeAndSort(arr1,arr2);
        for (int i : sortArr) {
            System.out.println(i);
        }
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

    // private static String[] merge() {

    // }

}