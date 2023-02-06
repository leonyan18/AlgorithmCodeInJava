package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 067. 最大的异或
 * https://leetcode.cn/problems/ms70jA/
 */
@Service
public class Offer0067Solution implements Solution {
    class Solution {
        public int findMaximumXOR(int[] nums) {
            Trie root = new Trie();
            int maxv = -1;
            for (int i = 0; i < nums.length; i++) {
                root.insert(nums[i]);
                maxv = Math.max(root.searchMax(nums[i]) ^ nums[i], maxv);
            }
            return maxv;
        }
    }

    class Trie {
        Trie[] child;
        int val;

        public Trie() {
            child = new Trie[2];
            val = 0;
        }

        public void insert(int val) {
            Trie node = this;
            for (int i = 30; i >= 0; i--) {
                int next = (val >> i) & 1;
                if (node.child[next] == null) {
                    node.child[next] = new Trie();
                }
                node = node.child[next];
            }
            node.val = val;
        }

        public int searchMax(int val) {
            Trie node = this;
            for (int i = 30; i >= 0; i--) {
                int next = (val >> i) & 1;
                if (node.child[(next + 1) % 2] != null) {
                    next = (next + 1) % 2;
                }
                node = node.child[next];
            }
            return node.val;
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
