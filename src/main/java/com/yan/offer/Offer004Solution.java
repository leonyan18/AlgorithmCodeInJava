package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 004. 只出现一次的数字
 * https://leetcode.cn/problems/WGki4K/
 */
public class Offer004Solution implements Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        int one = 0, two = 0;
        for (int i = 0; i < n; i++) {
            one = one ^ nums[i] & ~two;
            two = two ^ nums[i] & ~one;
        }
        return one;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}