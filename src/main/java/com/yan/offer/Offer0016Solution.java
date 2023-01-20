package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer II 016. 不含重复字符的最长子字符串
 * https://leetcode.cn/problems/wtcaE1/
 */
//@Service
public class Offer0016Solution implements Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        Set<String> set = new HashSet<String>();
        int len = 0;
        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i) + "")) {
                set.remove(s.charAt(l) + "");
                l++;
            }
            set.add(s.charAt(i) + "");
            len = Math.max(set.size(), len);
        }
        return len;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}