package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 092. 翻转字符
 * https://leetcode.cn/problems/cyJERH/
 */
@Service
public class Offer0092Solution implements Solution {
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int[] back = new int[len + 1];
        back[len] = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                back[i] = back[i + 1] + 1;
            } else {
                back[i] = back[i + 1];
            }
        }
        int cnt = 0;
        int minv = len;
        for (int i = 0; i < len; i++) {
            minv = Math.min(minv, cnt + back[i]);
            if (s.charAt(i) == '1') {
                cnt++;
            }
        }
        minv = Math.min(minv, cnt);
        return minv;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
