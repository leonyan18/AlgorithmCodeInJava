package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 070. 排序数组中只出现一次的数字
 * https://leetcode.cn/problems/skFtm2/
 */

public class Offer0070Solution implements Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return binSearch(nums, 0, nums.length - 1);
    }

    public int binSearch(int[] arr, int l, int r) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            int pre = mid == 0 ? -1 : arr[mid - 1];
            int next = mid == arr.length - 1 ? -1 : arr[mid + 1];
            int pos = mid;
            if (arr[mid] == pre) {
                pos++;
            }
            if (arr[mid] != pre && arr[mid] != next) {
                return arr[mid];
            } else if (pos % 2 == 0) {
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
