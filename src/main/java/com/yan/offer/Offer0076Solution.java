package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 076. 数组中的第 k 大的数字
 * https://leetcode.cn/problems/xx4gT2/
 */
@Service
public class Offer0076Solution implements Solution {
    public int findKthLargest(int[] nums, int k) {
        // PriorityQueue<Integer> queue=new PriorityQueue<>();
        // for(int i=0;i<nums.length;i++){
        //     queue.add(nums[i]);
        //     if(queue.size()>k){
        //         queue.poll();
        //     }
        // }
        return quickSort(nums, k, 0, nums.length - 1);
    }

    public int quickSort(int[] nums, int k, int l, int r) {
        // System.out.println(" "+k+" "+l+" "+r);
        if (r < l) {
            return -1;
        }
        if (r == l) {
            return nums[l];
        }
        int pos = merge(nums, l, r);
        // for(int i=0;i<nums.length;i++){
        //     System.out.print(" "+nums[i]);
        // }
        // System.out.println(" ");
        if (pos == k - 1) {
            return nums[k - 1];
        } else if (pos > k - 1) {
            return quickSort(nums, k, l, pos - 1);
        } else {
            return quickSort(nums, k, pos + 1, r);
        }
    }

    public int merge(int[] nums, int l, int r) {
        // System.out.println(l+" "+r);
        if (r < l) {
            return -1;
        }
        if (l == r) {
            return l;
        }
        int p = nums[l];
        while (l < r) {
            while (nums[r] < p && r > l) r--;
            nums[l] = nums[r];
            while (nums[l] >= p && r > l) l++;
            nums[r] = nums[l];
        }
        nums[l] = p;
        return l;
    }


    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
