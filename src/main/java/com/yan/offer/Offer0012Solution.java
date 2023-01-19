package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * https://leetcode.cn/problems/tvdfij/
 */
public class Offer0012Solution implements Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (pre == sum - pre - nums[i]) {
                return i;
            }
            pre += nums[i];
        }
        return -1;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}