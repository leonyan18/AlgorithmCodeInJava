package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer II 032. 有效的变位词
 * https://leetcode.cn/problems/dKk3P7/
 */
//@Service
public class Offer0032Solution implements Solution {
    public boolean isAnagram(String s, String t) {
        if (s.equals(t) || s.length() != t.length()) {
            return false;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String ch = s.charAt(i) + "";
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            String ch = t.charAt(i) + "";
            if (!map.containsKey(ch) || map.get(ch) <= 0) {
                return false;
            }
            map.put(ch, map.get(ch) - 1);
        }
        return true;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
