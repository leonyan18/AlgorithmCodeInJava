package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 018. 有效的回文
 * https://leetcode.cn/problems/XltzEq/
 */

public class Offer0018Solution implements Solution {
    public boolean isPalindrome(String s) {
        String s1 = "";
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp >= 'a' && temp <= 'z') {
                s1 += temp;
            }
            if (temp >= 'A' && temp <= 'Z') {
                s1 += temp;
            }
            if (temp >= '0' && temp <= '9') {
                s1 += temp;
            }
        }
        int len = s1.length();
        s1 = s1.toLowerCase();
        // System.out.println(s1);
        for (int i = 1; i <= len / 2; i++) {
            if (s1.charAt(i - 1) != s1.charAt(len - i)) {
                // System.out.println(i);
                return false;
            }
        }
        return true;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}