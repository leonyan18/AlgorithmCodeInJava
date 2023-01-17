package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 002. 二进制加法
 * https://leetcode.cn/problems/JFETK5/
 */
public class Offer002Solution implements Solution {
    public String addBinary(String a, String b) {
        int lena = a.length();
        int lenb = b.length();
        int add = 0;
        String ans = "";
        while (lena > 0 && lenb > 0) {
            int temp = (a.charAt(lena - 1) - '0') + (b.charAt(lenb - 1) - '0') + add;
            add = temp > 1 ? 1 : 0;
            if (temp == 1 || temp == 3) {
                ans = "1" + ans;
            } else {
                ans = "0" + ans;
            }
            lena--;
            lenb--;
        }
        while (lena > 0) {
            int temp = (a.charAt(lena - 1) - '0') + add;
            add = temp > 1 ? 1 : 0;
            if (temp == 1 || temp == 3) {
                ans = "1" + ans;
            } else {
                ans = "0" + ans;
            }
            lena--;
        }
        while (lenb > 0) {
            int temp = (b.charAt(lenb - 1) - '0') + add;
            add = temp > 1 ? 1 : 0;
            if (temp == 1 || temp == 3) {
                ans = "1" + ans;
            } else {
                ans = "0" + ans;
            }
            lenb--;
        }
        if (add == 1) {
            ans = "1" + ans;
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}