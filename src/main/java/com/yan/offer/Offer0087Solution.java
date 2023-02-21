package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 087. 复原 IP
 * https://leetcode.cn/problems/0on3uN/
 */

public class Offer0087Solution implements Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        gen(ans, s, 0, 0, "");
        return ans;
    }

    public void gen(List<String> ans, String s, int pos, int cnt, String now) {
        if (cnt == 4 && pos == s.length()) {
            ans.add(now);
        }
        if (cnt == 4) {
            return;
        }
        for (int i = 1; i <= 3 && i + pos <= s.length(); i++) {
            if (s.charAt(pos) == '0' && i > 1) {
                return;
            }
            String temp = s.substring(pos, pos + i);
            if (Integer.valueOf(temp) > 255) {
                break;
            }
            if (cnt == 0) {
                gen(ans, s, pos + i, cnt + 1, now + temp);
            } else {
                gen(ans, s, pos + i, cnt + 1, now + "." + temp);
            }
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
