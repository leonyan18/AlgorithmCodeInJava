package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 109. 开密码锁
 * https://leetcode.cn/problems/zlDJc7/
 */
public class Offer0109Solution implements Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < deadends.length; i++) {
            set.add(deadends[i]);
        }
        if (set.contains("0000")) {
            return -1;
        }
        queue.add("0000");
        map.put("0000", 0);
        set.add("0000");
        if (target.equals("0000")) {
            return 0;
        }
        while (!queue.isEmpty()) {
            String top = queue.poll();
            int topv = map.get(top);
            int flag = 1;
            for (int i = 0; i < 8; i++) {
                int pos = i / 2;
                int val = top.charAt(pos) - '0';
                if (i % 2 == 0) {
                    val = (val + 11) % 10;
                } else {
                    val = (val + 9) % 10;
                }
                String replace = top.substring(0, pos) + (char) (val + '0') + top.substring(pos + 1);
                if (target.equals(replace)) {
                    return topv + 1;
                }
                if (!set.contains(replace)) {
                    map.put(replace, topv + 1);
                    set.add(replace);
                    queue.add(replace);
                }
            }
        }
        return -1;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
