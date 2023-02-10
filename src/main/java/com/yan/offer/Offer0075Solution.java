package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 075. 数组相对排序
 * https://leetcode.cn/problems/0H97ZC/
 */
@Service
public class Offer0075Solution implements Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer[] copy = new Integer[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            map.put(arr1[i], 1000 + arr1[i]);
            copy[i] = arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        Arrays.sort(copy, Comparator.comparingInt(map::get));
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = copy[i];
        }
        return arr1;
    }


    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
