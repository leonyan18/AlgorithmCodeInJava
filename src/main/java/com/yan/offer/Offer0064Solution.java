package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * 剑指 Offer II 064. 神奇的字典
 * https://leetcode.cn/problems/US1pGT/
 */
@Service
public class Offer0064Solution implements Solution {
    class MagicDictionary {
        MagicDictionary[] child;
        boolean isEnd;

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {
            child = new MagicDictionary[26];
            isEnd = false;
        }

        public void buildDict(String[] dictionary) {
            for (String s : dictionary) {
                insert(s);
            }
        }

        public boolean search(String searchWord) {
            int len = searchWord.length();
            for (int i = 0; i < len; i++) {
                String pre = searchWord.substring(0, i);
                for (int j = 0; j < 26; j++) {
                    char c = (char) ('a' + j);
                    if (c == searchWord.charAt(i)) {
                        continue;
                    }
                    String s = searchWord.substring(0, i) + c + searchWord.substring(i + 1, len);
                    // System.out.println(s);
                    if (searchWrong(s)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean searchWrong(String searchWord) {
            MagicDictionary node = this;
            int len = searchWord.length();
            for (int i = 0; i < searchWord.length(); i++) {
                int next = searchWord.charAt(i) - 'a';
                if (node.child[next] == null) {
                    return false;
                }
                node = node.child[next];
            }
            return node.isEnd;
        }

        public boolean searchPerfix(String searchWord) {
            MagicDictionary node = this;
            int len = searchWord.length();
            for (int i = 0; i < searchWord.length(); i++) {
                int next = searchWord.charAt(i) - 'a';
                if (node.child[next] == null) {
                    return false;
                }
                node = node.child[next];
            }
            return true;
        }

        public void insert(String word) {
            MagicDictionary node = this;
            for (int i = 0; i < word.length(); i++) {
                int next = word.charAt(i) - 'a';
                if (node.child[next] == null) {
                    node.child[next] = new MagicDictionary();
                }
                node = node.child[next];
            }
            node.isEnd = true;
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
