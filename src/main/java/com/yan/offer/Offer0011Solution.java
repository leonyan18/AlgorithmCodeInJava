package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 011. 0 和 1 个数相同的子数组
 * https://leetcode.cn/problems/A1NYOS/
 */
public class Offer0011Solution implements Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(pre)) {
                map.put(pre, i);
            }
            pre = pre + (nums[i] == 1 ? 1 : -1);
            if (map.containsKey(pre)) {
                len = Math.max(len, i - map.get(pre) + 1);
            }
        }
        return len;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}