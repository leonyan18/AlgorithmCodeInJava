package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 001. 整数除法
 * https://leetcode.cn/problems/xoh6Oh/
 */
public class Offer001Solution implements Solution {
    public int divide(int a, int b) {
        int flag = 1;
        long ans = 0;
        long al = a;
        long bl = b;
        if (al < 0) {
            al = 0 - al;
            flag = flag ^ 1;
        }
        if (bl < 0) {
            bl = 0 - bl;
            flag = flag ^ 1;
        }
        long bit = 31;
        while (al > 0 && bit >= 0) {
            long temp = bl << bit;
            if (temp <= al) {
                al -= temp;
                ans += (1L << bit);
            }
            bit--;
        }
        if (flag == 0) {
            ans = 0 - ans;
        }
        if (ans >= (1L << 31) - 1 || ans < -(1L << 31)) {
            return (1 << 31) - 1;
        } else if (ans == -(1 << 31)) {
            return (1 << 31);
        } else {
            return (int) ans;
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}