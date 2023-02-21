package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 056. 二叉搜索树中两个节点之和
 * https://leetcode.cn/problems/opLdQZ/
 */

public class Offer0056Solution implements Solution {
    Map<Integer, Integer> map;

    public boolean findTarget(TreeNode root, int k) {
        map = new HashMap<>();
        return doFindTarget(root, k);
    }

    public boolean doFindTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (map.containsKey(k - root.val)) {
            return true;
        }
        map.put(root.val, 1);
        return doFindTarget(root.left, k) || doFindTarget(root.right, k);
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
