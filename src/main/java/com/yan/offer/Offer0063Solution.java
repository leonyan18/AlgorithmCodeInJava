package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * 剑指 Offer II 063. 替换单词
 * https://leetcode.cn/problems/UhWRSj/
 */
@Service
public class Offer0063Solution implements Solution {
    class Solution {
        Solution[] child;
        boolean isEnd = false;

        public Solution() {
            child = new Solution[26];
            isEnd = false;
        }

        public String replaceWords(List<String> dictionary, String sentence) {
            for (String s : dictionary) {
                insert(s);
            }
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                String replace = findPrefix(words[i]);
                // System.out.println(replace);
                if (replace != null) {
                    words[i] = replace;
                }
            }
            String ans = "";
            for (int i = 0; i < words.length; i++) {
                if (i == 0) {
                    ans += words[i];
                } else {
                    ans += " " + words[i];
                }
            }
            return ans;
        }

        public void insert(String word) {
            Solution node = this;
            for (int i = 0; i < word.length(); i++) {
                int next = word.charAt(i) - 'a';
                if (node.child[next] == null) {
                    node.child[next] = new Solution();
                }
                node = node.child[next];
            }
            node.isEnd = true;
        }

        public String findPrefix(String word) {
            Solution node = this;
            String ans = "";
            for (int i = 0; i < word.length(); i++) {
                ans += word.charAt(i);
                int next = word.charAt(i) - 'a';
                if (node.child[next] == null) {
                    return null;
                }
                if (node.child[next].isEnd) {
                    return ans;
                }
                node = node.child[next];
            }
            return null;
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
