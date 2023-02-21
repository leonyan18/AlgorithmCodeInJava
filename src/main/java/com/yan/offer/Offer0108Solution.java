package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer II 108. 单词演变
 * https://leetcode.cn/problems/om3reC/
 */

public class Offer0108Solution implements Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[][] can = new boolean[wordList.size()][wordList.size()];
        boolean[] vis = new boolean[wordList.size()];
        Queue<int[]> queue = new LinkedList<>();
        int last = -1;
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) {
                last = i;
            }
            if (check(wordList.get(i), beginWord)) {
                queue.add(new int[]{i, 2});
            }
            for (int j = i + 1; j < wordList.size(); j++) {
                if (check(wordList.get(i), wordList.get(j))) {
                    can[i][j] = true;
                    can[j][i] = true;
                }
            }
        }
        if (last == -1) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            if (top[0] == last) {
                return top[1];
            }
            for (int j = 0; j < wordList.size(); j++) {
                if (can[top[0]][j] && !vis[j]) {
                    vis[j] = true;
                    queue.add(new int[]{j, top[1] + 1});
                }
            }
        }
        return 0;
    }

    public boolean check(String a, String b) {
        int cnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {

    }
}
