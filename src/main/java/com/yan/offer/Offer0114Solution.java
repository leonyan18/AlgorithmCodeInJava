package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 114. 外星文字典
 * https://leetcode.cn/problems/Jf1JuT/
 */
public class Offer0114Solution implements Solution {
    public String alienOrder(String[] words) {
        int[] need = new int[26];
        Set<Integer> set = new HashSet<>();
        StringBuilder ans = new StringBuilder("");
        Map<Integer, List<Integer>> map = new HashMap<>();
        String pre = words[0];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j) - 'a');
            }
        }
        for (int i = 1; i < words.length; i++) {
            String now = words[i];
            int flag = 0;
            for (int j = 0; j < pre.length() && j < now.length(); j++) {
                if (now.charAt(j) != pre.charAt(j)) {
                    // System.out.println(pre.charAt(j)+" "+now.charAt(j));
                    int prev = pre.charAt(j) - 'a';
                    int nowv = now.charAt(j) - 'a';
                    need[nowv]++;
                    if (!map.containsKey(prev)) {
                        map.put(prev, new ArrayList<>());
                    }
                    map.get(prev).add(nowv);
                    flag = 1;
                    break;
                }
            }
            if (flag == 0 && pre.length() > now.length()) {
                return "";
            }
            pre = now;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (set.contains(i) && need[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            int top = queue.poll();
            ans.append("" + (char) ('a' + top));
            for (int v : map.getOrDefault(top, new ArrayList<>(1))) {
                need[v]--;
                if (need[v] == 0) {
                    queue.add(v);
                }
            }
        }
        if (ans.length() != set.size()) {
            return "";
        }
        return ans.toString();
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
