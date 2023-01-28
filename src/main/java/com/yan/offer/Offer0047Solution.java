package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer II 047. 二叉树剪枝
 * https://leetcode.cn/problems/pOCWxh/
 */
//@Service
public class Offer0047Solution implements Solution {

    public TreeNode pruneTree(TreeNode root) {
        if (count(root) == 0) {
            return null;
        }
        return root;
    }

    public int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int vall = count(root.left);
        if (vall == 0) {
            root.left = null;
        }
        int valr = count(root.right);
        if (valr == 0) {
            root.right = null;
        }
        return vall + valr + root.val;
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
