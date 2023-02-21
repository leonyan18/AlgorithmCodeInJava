package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer II 086. 分割回文子字符串
 * https://leetcode.cn/problems/M99OJA/
 */

public class Offer0086Solution implements Solution {
    public String[][] partition(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        String[] now = new String[len];
        List<List<String>> nowList = new ArrayList<>();
        String[][] ans;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j <= i + 1; j++) {
                if (j <= 1) {
                    dp[i][j] = 1;
                } else {
                    if (s.charAt(i) != s.charAt(i - j + 1)) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j - 2];
                    }
                }
            }
        }
        gen(dp, s, 0, 0, now, nowList);
        ans = new String[nowList.size()][];
        for (int i = 0; i < nowList.size(); i++) {
            ans[i] = new String[nowList.get(i).size()];
            for (int j = 0; j < nowList.get(i).size(); j++) {
                ans[i][j] = nowList.get(i).get(j);
            }
        }
        return ans;
    }

    public void gen(int[][] dp, String s, int pos, int cnt, String[] now, List<List<String>> nowList) {
        if (pos == s.length()) {
            List<String> temp = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                temp.add(now[i]);
            }
            nowList.add(temp);
            return;
        }
        for (int i = 1; i < s.length() - pos + 1; i++) {
            if (dp[pos + i - 1][i] == 1) {
                now[cnt] = s.substring(pos, pos + i);
                gen(dp, s, pos + i, cnt + 1, now, nowList);
            }
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
