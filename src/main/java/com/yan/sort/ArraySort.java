package com.yan.sort;

import java.util.Random;

public class ArraySort {
    public static void quickSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int v = array[l];
        int rp = r;
        int lp = l;
        while (rp > lp) {
            while (rp > lp && array[rp] >= v) {
                rp--;
            }
            array[lp] = array[rp];
            while (rp > lp && array[lp] <= v) {
                lp++;
            }
            array[rp] = array[lp];
        }
        array[lp] = v;
        quickSort(array, l, lp - 1);
        quickSort(array, lp + 1, r);
    }

    public static void mergeSort(int[] array, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (r - l) / 2 + l;
        mergeSort(array, l, mid);
        mergeSort(array, mid + 1, r);
        merge(array, l, r);
    }

    public static void merge(int[] array, int l, int r) {
        int[] copy = new int[r - l + 1];
        int mid = (r - l) / 2 + l;
        int rp = mid + 1;
        int lp = l;
        int p = 0;
        while (lp <= mid && rp <= r) {
            if (array[lp] <= array[rp]) {
                copy[p++] = array[lp++];
            } else {
                copy[p++] = array[rp++];
            }
        }
        while (lp <= mid) copy[p++] = array[lp++];
        while (rp <= r) copy[p++] = array[rp++];
        while (p-- > 0) {
            array[l + p] = copy[p];
        }
    }

    public static void main(String[] args) {
        int len = 1000;
        int[] a = new int[len];
        Random r = new Random();
        for (int i = 0; i < len; i++) {
            a[i] = r.nextInt(len);
        }
        mergeSort(a, 0, a.length - 1);
        System.out.println();
        for (int i = 0; i < len; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
