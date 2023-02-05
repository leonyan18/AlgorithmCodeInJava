package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * 剑指 Offer II 065. 最短的单词编码
 * https://leetcode.cn/problems/z1R5dt/
 */
@Service
public class Offer0066Solution implements Solution {
    class MapSum {
        MapSum[] child;
        int val;
        boolean isEnd;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            child = new MapSum[26];
            val = 0;
            isEnd = false;
        }

        public void insert(String key, int val) {
            MapSum node = this;
            for (int i = 0; i < key.length(); i++) {
                int next = key.charAt(i) - 'a';
                if (node.child[next] == null) {
                    node.child[next] = new MapSum();
                }
                node = node.child[next];
            }
            node.isEnd = true;
            node.val = val;
        }

        public int sum(String prefix) {
            MapSum node = this;
            for (int i = 0; i < prefix.length(); i++) {
                int next = prefix.charAt(i) - 'a';
                if (node.child[next] == null) {
                    return 0;
                }
                node = node.child[next];
            }
            return count(node);
        }

        public int count(MapSum node) {
            int ans = 0;
            if (node.isEnd == true) {
                ans += node.val;
            }
            for (int i = 0; i < 26; i++) {
                if (node.child[i] != null) {
                    ans += count(node.child[i]);
                }
            }
            return ans;
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
