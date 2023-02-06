package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 069. 山峰数组的顶部
 * https://leetcode.cn/problems/B1IidL/
 */
@Service
public class Offer0069Solution implements Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // for(int i=1;i<arr.length-1;i++){
        //     if(arr[i]>arr[i-1]&&arr[i]>arr[i+1]){
        //         return i;
        //     }
        // }
        return binSearch(arr, 1, arr.length - 2);
    }

    public int binSearch(int[] arr, int l, int r) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
