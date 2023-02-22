package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer II 108. 单词演变
 * https://leetcode.cn/problems/om3reC/
 */
@Service
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

    /**
     * 变长数组 节省资源和时间
     */
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        List<Integer>[] can = new List[wordList.size() + 1];
        boolean[] vis = new boolean[wordList.size()];
        Queue<int[]> queue = new LinkedList<>();
        int last = -1;
        can[0] = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) {
                last = i;
            }
            if (check(wordList.get(i), beginWord)) {
                vis[i] = true;
                queue.add(new int[]{i, 2});
            }
            for (int j = i + 1; j < wordList.size(); j++) {
                if (i == 0) {
                    can[j] = new ArrayList<>();
//                    System.out.println(j+" "+can[j].hashCode());
                }
                if (check(wordList.get(i), wordList.get(j))) {
                    can[i].add(j);
                    can[j].add(i);
                }
//                System.out.println(j+" "+can[j].hashCode());
            }
        }
//        System.out.println(can[4].hashCode());
        if (last == -1) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            if (top[0] == last) {
                return top[1];
            }
            for (int j = 0; j < can[top[0]].size(); j++) {
                int next = can[top[0]].get(j);
                if (!vis[next]) {
                    vis[next] = true;
                    queue.add(new int[]{next, top[1] + 1});
                }
            }
        }
        return 0;
    }

    /**
     * 双向bfs 有误
     */
    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
        List<Integer>[] can = new List[wordList.size() + 1];
        int[] vis = new int[wordList.size()];
        int[] visEnd = new int[wordList.size()];
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> queueEnd = new LinkedList<>();
        int last = -1;
        can[0] = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            if (wordList.get(i).equals(endWord)) {
                last = i;
                visEnd[last] = 1;
                queueEnd.add(new int[]{last, 1});
            }
            if (wordList.get(i).equals(beginWord)) {
                vis[i] = 1;
            }
            if (check(wordList.get(i), beginWord)) {
                vis[i] = 2;
                queue.add(new int[]{i, 2});
            }
            for (int j = i + 1; j < wordList.size(); j++) {
                if (i == 0) {
                    can[j] = new ArrayList<>();
                }
                if (check(wordList.get(i), wordList.get(j))) {
                    can[i].add(j);
                    can[j].add(i);
                }
            }
        }
        if (last == -1) {
            return 0;
        }
        while (!queue.isEmpty() && !queueEnd.isEmpty()) {
            add(queue, vis, can);
            int[] top = queueEnd.peek();
            if (vis[top[0]] != 0 && visEnd[top[0]] != 0) {
                System.out.println(wordList.get(top[0]) + " " + top[0] + " " + vis[top[0]] + " " + visEnd[top[0]] + " ");
                return vis[top[0]] + visEnd[top[0]] - 1;
            }
            add(queueEnd, visEnd, can);
        }
        return 0;
    }

    public void add(Queue<int[]> queue, int[] vis, List<Integer>[] can) {
        int[] top = queue.poll();
        for (int j = 0; j < can[top[0]].size(); j++) {
            int next = can[top[0]].get(j);
            if (vis[next] == 0) {
                vis[next] = top[1] + 1;
                queue.add(new int[]{next, top[1] + 1});
            }
        }
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
        List<String> wordList = new ArrayList<String>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("cog");
        wordList.add("lot");
        wordList.add("log");
        System.out.println(ladderLength3("hit", "cog", wordList));
    }
}
