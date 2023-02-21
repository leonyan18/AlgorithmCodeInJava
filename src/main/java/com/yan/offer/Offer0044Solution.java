package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 044. 二叉树每层的最大值
 * https://leetcode.cn/problems/hPov7L/
 */

public class Offer0044Solution implements Solution {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int cnt = 0;
        int level = 1;
        int nextlevel = 0;
        int maxv = Integer.MIN_VALUE;
        while (queue.size() != 0) {
            TreeNode top = queue.poll();
            maxv = Math.max(top.val, maxv);
            cnt++;
            if (top.left != null) {
                nextlevel++;
                queue.add(top.left);
            }
            if (top.right != null) {
                nextlevel++;
                queue.add(top.right);
            }
            if (cnt == level) {
                list.add(maxv);
                maxv = Integer.MIN_VALUE;
                level = nextlevel;
                nextlevel = 0;
                cnt = 0;
            }
        }
        return list;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
    }
}
