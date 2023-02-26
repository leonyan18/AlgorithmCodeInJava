package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 117. 相似的字符串
 * https://leetcode.cn/problems/H6lPxb/
 */
public class Offer0117Solution implements Solution {
    public int numSimilarGroups(String[] strs) {
        int len = strs.length;
        int[] parent = new int[len];
        for (int i = 0; i < len; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (check(strs[i], strs[j])) {
                    union(parent, i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (parent[i] == i) {
                ans++;
            }
        }
        return ans;
    }

    public void union(int[] parent, int l, int r) {
        parent[find(parent, r)] = find(parent, l);
    }

    public int find(int[] parent, int pos) {
        if (parent[pos] != pos) {
            parent[pos] = find(parent, parent[pos]);
        }
        return parent[pos];
    }

    public boolean check(String a, String b) {
        int pre = 0;
        int flag = 0;
        if (a.length() != b.length()) {
            return false;
        }
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                if (flag == 1) {
                    if (a.charAt(i) != b.charAt(pre) || a.charAt(pre) != b.charAt(i)) {
                        return false;
                    }
                }
                flag++;
                pre = i;
            }
            if (flag > 2) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
