package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * 剑指 Offer II 065. 最短的单词编码
 * https://leetcode.cn/problems/iSwD2y/
 */
@Service
public class Offer0065Solution implements Solution {
    class Solution {
        public int minimumLengthEncoding(String[] words) {
            Trie root = new Trie();
            ;
            int cnt = 0;
            Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
            for (int i = 0; i < words.length; i++) {
                if (!root.searchPrefix(words[i])) {
                    root.insert(words[i]);
                    cnt += words[i].length() + 1;
                }
            }
            return cnt;
        }

    }

    class Trie {
        Trie[] child;
        boolean isEnd;

        public Trie() {
            child = new Trie[26];
            isEnd = false;
        }

        public void insert(String word) {
            Trie node = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                int next = word.charAt(i) - 'a';
                if (node.child[next] == null) {
                    node.child[next] = new Trie();
                }
                node = node.child[next];
            }
            node.isEnd = true;
        }

        public boolean searchPrefix(String word) {
            Trie node = this;
            for (int i = word.length() - 1; i >= 0; i--) {
                int next = word.charAt(i) - 'a';
                if (node.child[next] == null) {
                    return false;
                }
                node = node.child[next];
            }
            return true;
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
