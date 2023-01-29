package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 049. 从根节点到叶节点的路径数字之和
 * https://leetcode.cn/problems/3Etpl5/
 */
//@Service
public class Offer0049Solution implements Solution {
    int ans = 0;

    public int sumNumbers(TreeNode root) {
        ans = 0;
        sum(root, 0);
        return ans;
    }

    public void sum(TreeNode root, int pre) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans += pre * 10 + root.val;
        }
        sum(root.left, pre * 10 + root.val);
        sum(root.right, pre * 10 + root.val);
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
