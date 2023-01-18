package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 008. 和大于等于 target 的最短子数组
 * https://leetcode.cn/problems/2VG8Kg/
 */
public class Offer008Solution implements Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length + 1;
        int l = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                len = Math.min(i - l + 1, len);
                sum -= nums[l];
                l++;
            }
        }
        if (len == nums.length + 1) {
            return 0;
        }
        while (l < nums.length) {
            if (sum >= target) {
                len = Math.min(nums.length - l, len);
            }
            sum -= nums[l];
            l++;
        }
        return len;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}