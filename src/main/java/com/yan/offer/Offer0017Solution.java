package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 剑指 Offer II 017. 含有所有字符的最短字符串
 * https://leetcode.cn/problems/M1oyTv/
 */
//@Service
public class Offer0017Solution implements Solution {
    public String minWindow(String s, String t) {
        int len = t.length();
        int ans = s.length() + 1;
        String ansString = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            String temp = t.charAt(i) + "";
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }
        int l = 0;
        int cnt = 0;
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String temp = s.charAt(i) + "";
            map2.put(temp, map2.getOrDefault(temp, 0) + 1);
            if (map.containsKey(temp) && map.get(temp) >= map2.get(temp)) {
                cnt++;
            }
            // System.out.println("cnt"+cnt);
            if (cnt == len) {
                while (check(map, map2, s, l) && l < i) {
                    String before = s.charAt(l) + "";
                    map2.put(before, map2.get(before) - 1);
                    l++;
                }
                // System.out.println(l+" "+i);
                if ((i - l + 1) < ans) {
                    ans = (i - l) + 1;
                    ansString = s.substring(l, i + 1);
                }
                if (l <= i) {
                    String before = s.charAt(l) + "";
                    map2.put(before, map2.get(before) - 1);
                    if (map.containsKey(before) && map.get(before) >= map2.get(before)) {
                        cnt--;
                    }
                    l++;
                }
            }
        }
        return ansString;
    }

    public boolean check(Map<String, Integer> map, Map<String, Integer> map2, String s, int l) {
        String temp = s.charAt(l) + "";
        if (!map.containsKey(temp)) {
            return true;
        }
        if (map.get(temp) < map2.get(temp)) {
            return true;
        }
        return false;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}