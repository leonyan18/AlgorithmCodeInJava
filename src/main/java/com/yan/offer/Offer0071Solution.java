package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

/**
 * 剑指 Offer II 071. 按权重生成随机数
 * https://leetcode.cn/problems/cuyjEf/
 */

public class Offer0071Solution implements Solution {
    class Solution {
        long[] pre;
        long cnt;
        Random r;
        int len;

        public Solution(int[] w) {
            len = w.length;
            pre = new long[len];
            for (int i = 0; i < len; i++) {
                cnt += w[i];
                pre[i] = cnt;
            }
            r = new Random();
            // System.out.println(cnt);
        }

        public int pickIndex() {
            long val = r.nextLong(cnt);
            // System.out.println(val);
            return binSearch(0, len - 1, val + 1);
        }

        public int binSearch(int l, int r, long target) {
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (pre[mid] >= target) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            return l;
        }
    }


    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
