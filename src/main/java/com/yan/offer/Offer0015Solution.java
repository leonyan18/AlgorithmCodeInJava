package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 015. 字符串中的所有变位词
 * https://leetcode.cn/problems/VabMRr/
 */
//@Service
public class Offer0015Solution implements Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int len = p.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            String temp = p.charAt(i) + "";
            if (!map.containsKey(temp)) {
                map.put(temp, 0);
            }
            map.put(temp, map.get(temp) + 1);
        }
        int l = 0;
        int cnt = 0;
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String temp = s.charAt(i) + "";
            // 如果1中不存在，那么清空map2
            if (!map.containsKey(temp)) {
                map2.clear();
                cnt = 0;
                l = i + 1;
            } else {
                if (!map2.containsKey(temp)) {
                    map2.put(temp, 0);
                }
                // 如果数字比原来多 先舍首
                while (map.get(temp) <= map2.get(temp) && l < i) {
                    String before = s.charAt(l) + "";
                    map2.put(before, map2.get(before) - 1);
                    l++;
                    cnt--;
                }
                map2.put(temp, map2.get(temp) + 1);
                cnt++;
                if (cnt == len) {
                    ans.add(l);
                }
            }
        }
        return ans;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}