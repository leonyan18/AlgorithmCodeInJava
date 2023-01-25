package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 剑指 Offer II 035. 最小时间差
 * https://leetcode.cn/problems/569nqc/
 */
//@Service
public class Offer0035Solution implements Solution {
    public int findMinDifference(List<String> timePoints) {
        int len = timePoints.size();
        int[] a = new int[len];
        for (int i = 0; i < len; i++) {
            String[] ss = timePoints.get(i).split(":");
            int val = Integer.valueOf(ss[0]) * 60 + Integer.valueOf(ss[1]);
            a[i] = val;
        }
        Arrays.sort(a);
        int pre = a[0];
        int min = a[len - 1];
        int max = 24 * 60;
        for (int i = 1; i < len * 2; i++) {
            min = Math.min(min, (a[i % len] - pre + max) % max);
            min = Math.min(min, (pre - a[i % len] + max) % max);
            pre = a[i % len];
        }
        return min;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
