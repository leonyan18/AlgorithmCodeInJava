package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 剑指 Offer II 052. 展平二叉搜索树
 * https://leetcode.cn/problems/NYBBNL/
 */

public class Offer0052Solution implements Solution {
    public TreeNode increasingBST(TreeNode root) {
        Queue<TreeNode> nodes = new ArrayDeque<TreeNode>();
        doBST(root, nodes);
        root = nodes.poll();
        TreeNode pre = root;
        while (nodes.size() > 0) {
            TreeNode top = nodes.poll();
            pre.left = null;
            pre.right = top;
            pre = top;
        }
        pre.left = null;
        pre.right = null;
        return root;
    }

    public void doBST(TreeNode root, Queue<TreeNode> nodes) {
        if (root == null) {
            return;
        }
        doBST(root.left, nodes);
        nodes.add(root);
        doBST(root.right, nodes);
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
