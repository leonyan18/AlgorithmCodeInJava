package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 068. 查找插入位置
 * https://leetcode.cn/problems/N6YdxV/
 */

public class Offer0068Solution implements Solution {
    public int searchInsert(int[] nums, int target) {
        return binSearch(nums, 0, nums.length - 1, target);
    }

    public int binSearch(int nums[], int l, int r, int target) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
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
