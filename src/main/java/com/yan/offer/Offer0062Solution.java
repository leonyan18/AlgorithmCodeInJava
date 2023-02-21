package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 剑指 Offer II 062. 实现前缀树
 * https://leetcode.cn/problems/QC3q1f/
 */

public class Offer0062Solution implements Solution {
    class Trie {
        Trie[] child;
        boolean isEnd = false;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            child = new Trie[26];
            isEnd = false;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int next = word.charAt(i) - 'a';
                if (node.child[next] == null) {
                    node.child[next] = new Trie();
                }
                node = node.child[next];
            }
            node.isEnd = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Trie ans = findPrefix(word);
            return ans != null && ans.isEnd;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return findPrefix(prefix) != null;
        }

        public Trie findPrefix(String word) {
            Trie node = this;
            for (int i = 0; i < word.length(); i++) {
                int next = word.charAt(i) - 'a';
                if (node.child[next] == null) {
                    return null;
                }
                node = node.child[next];
            }
            return node;
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
