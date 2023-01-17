package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 003. 前 n 个数字二进制中 1 的个数
 * https://leetcode.cn/problems/w3tCBm/
 */
public class Offer003Solution implements Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int bit = 0;
            int cnt = 0;
            while ((1 << bit) <= i && bit < 20) {
                cnt = (i & (1 << bit)) == 0 ? cnt : cnt + 1;
                bit++;
            }
            ans[i] = cnt;
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}