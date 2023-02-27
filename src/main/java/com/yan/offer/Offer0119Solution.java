package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 119. 最长连续序列
 * https://leetcode.cn/problems/WhsWhI/
 */
public class Offer0119Solution implements Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int v : nums) {
            map.put(v, 1);
        }
        int max = 0;
        for (int v : nums) {
            if (!map.containsKey(v)) {
                continue;
            }
            int l = v;
            while (map.containsKey(l - 1)) {
                map.remove(l - 1);
                l--;
            }
            int r = v;
            while (map.containsKey(r + 1)) {
                map.remove(r + 1);
                r++;
            }
            map.remove(v);
            max = Math.max(max, r - l + 1);
        }
        return max;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
