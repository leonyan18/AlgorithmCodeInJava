package com.yan.string;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 2531. 使字符串总不同字符的数目相等
 * https://leetcode.cn/contest/weekly-contest-327/problems/make-number-of-distinct-characters-equal/
 */
//@Service
public class Solution2531 implements Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] cnt1 = new int[27];
        int[] cnt2 = new int[27];
        int word1cnt = 0;
        int word2cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            int pos = word1.charAt(i) - 'a';
            if (cnt1[pos] == 0) {
                word1cnt++;
            }
            cnt1[pos]++;
        }
        for (int i = 0; i < word2.length(); i++) {
            int pos = word2.charAt(i) - 'a';
            if (cnt2[pos] == 0) {
                word2cnt++;
            }
            cnt2[pos]++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt1[i] == 0) {
                continue;
            }
            for (int j = 0; j < 26; j++) {
                if (cnt2[j] == 0) {
                    continue;
                }
                int temp1 = word1cnt;
                int temp2 = word2cnt;
                if (i == j && word1cnt == word2cnt) {
                    return true;
                }
                if (i == j) {
                    continue;
                }
                if (cnt1[j] == 0) {
                    temp1++;
                }
                if (cnt1[i] == 1) {
                    temp1--;
                }
                if (cnt2[i] == 0) {
                    temp2++;
                }
                if (cnt2[j] == 1) {
                    temp2--;
                }
                System.out.println((i) + "  " + (j));
                System.out.println("temp1 " + temp1);
                System.out.println("temp2 " + temp2);
                if (temp1 == temp2) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        System.out.println(isItPossible("ca", "acac"));
    }
}