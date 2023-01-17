package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 005. 单词长度的最大乘积
 * https://leetcode.cn/problems/aseY1I/
 */
public class Offer005Solution implements Solution {
    public int maxProduct(String[] words) {
        int maxv = 0;
        int[] vals = new int[words.length + 5];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int temp = 1 << (words[i].charAt(j) - 'a');
                if ((vals[i] & temp) == 0) {
                    vals[i] += temp;
                }
            }
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if ((vals[i] & vals[j]) == 0) {
                    maxv = Math.max(maxv, words[i].length() * words[j].length());
                }
            }
        }
        return maxv;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}