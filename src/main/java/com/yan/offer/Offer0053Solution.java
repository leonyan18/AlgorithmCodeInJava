package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 剑指 Offer II 053. 二叉搜索树中的中序后继
 * https://leetcode.cn/problems/P5rCT8/
 */

public class Offer0053Solution implements Solution {
    TreeNode ans = null;
    int flag = 0;

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null || ans != null) {
            return null;
        }
        // System.out.println(root.val);
        inorderSuccessor(root.left, p);
        if (root.val == p.val) {
            flag = 1;
        } else {
            if (flag == 1) {
                flag++;
                ans = root;
            }
        }
        inorderSuccessor(root.right, p);
        return ans;
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
