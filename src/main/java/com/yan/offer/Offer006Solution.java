package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 006. 排序数组中两个数字之和
 * https://leetcode.cn/problems/kLl5u1
 */
public class Offer006Solution implements Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int l = 0, r = numbers.length - 1;
        Map<Integer, Integer> map = new HashMap<>(numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                ans[0] = map.get(target - numbers[i]);
                ans[1] = i;
            }
            map.put(numbers[i], i);
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}