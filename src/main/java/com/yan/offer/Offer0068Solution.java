package com.yan.offer;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 068. 查找插入位置
 * https://leetcode.cn/problems/N6YdxV/
 */
@Service
public class Offer0068Solution implements Solution {
    public int searchInsert(int[] nums, int target) {
        return binSearch(nums, 0, nums.length - 1, target);
    }

    public int binSearch(int nums[], int l, int r, int target) {
        while (l <= r) {
            int mid = l + ((r - l) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
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
