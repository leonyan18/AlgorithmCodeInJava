package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 014. 字符串中的变位词
 * https://leetcode.cn/problems/MPnaiL/
 */

public class Offer0014Solution implements Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len = s1.length();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            String temp = s1.charAt(i) + "";
            if (!map.containsKey(temp)) {
                map.put(temp, 0);
            }
            map.put(temp, map.get(temp) + 1);
        }
        int l = 0;
        int cnt = 0;
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < s2.length(); i++) {
            String temp = s2.charAt(i) + "";
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
                    String before = s2.charAt(l) + "";
                    System.out.println(l + " " + i);
                    map2.put(before, map2.get(before) - 1);
                    l++;
                    cnt--;
                }
                map2.put(temp, map2.get(temp) + 1);
                cnt++;
                if (cnt == len) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        checkInclusion("mart", "karma");
    }
}