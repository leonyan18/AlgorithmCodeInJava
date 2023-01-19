package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * https://leetcode.cn/problems/QTMn0o/
 */
public class Offer0010Solution implements Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        map.put(0, 1);
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (map.containsKey(pre - k)) {
                cnt += map.get(pre - k);
            }
            if (!map.containsKey(pre)) {
                map.put(pre, 0);
            }
            map.put(pre, map.get(pre) + 1);
        }
        return cnt;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}