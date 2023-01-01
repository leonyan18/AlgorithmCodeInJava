package com.yan.string;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * BM90 最小覆盖子串
 * https://www.nowcoder.com/practice/c466d480d20c4c7c9d322d12ca7955ac
 */
//@Service
public class MiniCoverageSubstring implements Solution {

    public String minWindow(String S, String T) {
        // write code here
        Map<String, Integer> tMap = new HashMap<>(60);
        Map<String, Integer> sMap = new HashMap<>(60);
        for (int i = 0; i < T.length(); i++) {
            String t = T.charAt(i) + "";
            if (!tMap.containsKey(t)) {
                tMap.put(t, 0);
            }
            tMap.put(t, tMap.get(t) + 1);
        }
        int len = S.length()+1, start = 0, ansStart = -1, end = 0, cnt = 0;
        while (end < S.length()) {
            // 全部加入队列,直到满足条件
            String temp;
            while (cnt < T.length() && end < S.length()) {
                temp = S.charAt(end) + "";
                if (!sMap.containsKey(temp)) {
                    sMap.put(temp, 0);
                }
                int val = sMap.get(temp) + 1;
                sMap.put(temp, val);
                // 如果小于等于计数才统计
                if (tMap.containsKey(temp) && tMap.get(temp) >= val) {
                    cnt++;
                }
                end++;
            }
            if (cnt < T.length())
                break;
            while (start<=end){
                temp = S.charAt(start) + "";
                if (tMap.containsKey(temp)&& Objects.equals(sMap.get(temp), tMap.get(temp)))
                    break;
                sMap.put(temp, sMap.get(temp) - 1);
                start++;
            }
            if (len>end-start){
                len=end-start;
                ansStart=start;
            }
            temp = S.charAt(start) + "";
            sMap.put(temp, sMap.get(temp) - 1);
            cnt--;
            start++;
        }
        if (ansStart == -1)
            return "";
        return S.substring(ansStart, ansStart + len);
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        System.out.println(minWindow("a", "a"));
    }

}
