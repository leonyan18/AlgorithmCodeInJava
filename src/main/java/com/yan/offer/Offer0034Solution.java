package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 034. 外星语言是否排序
 * https://leetcode.cn/problems/lwyVBB/
 */
//@Service
public class Offer0034Solution implements Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<String, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i) + "", i);
        }
        Map<String, String> map = new HashMap<>();
        String[] nwords = new String[words.length];
        int pos = 0;
        for (String s : words) {
            String ans = "";
            for (int i = 0; i < s.length(); i++) {
                ans += (char) (orderMap.get(s.charAt(i) + "") + 'a');
            }
            nwords[pos++] = ans;
            map.put(ans, s);
        }
        Arrays.sort(nwords);
        for (int i = 0; i < words.length; i++) {
            if (!words[i].equals(map.get(nwords[i]))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
