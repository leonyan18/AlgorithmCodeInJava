package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 019. 最多删除一个字符得到回文
 * https://leetcode.cn/problems/RQku0D/
 */

public class Offer0019Solution implements Solution {
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        int flag = 0;
        while (l < r) {
            // System.out.println(l+" "+r);
            if (s.charAt(l) != s.charAt(r)) {
                if (flag == 1) {
                    return false;
                }
                flag = 1;
                return check(s, l + 1, r) || check(s, l, r - 1);
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean check(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}