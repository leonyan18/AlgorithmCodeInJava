package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer II 046. 二叉树的右侧视图
 * https://leetcode.cn/problems/WNC0Lk/
 */

public class Offer0046Solution implements Solution {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int cnt = 0;
        int level = 1;
        int nextlevel = 0;
        while (queue.size() != 0) {
            TreeNode top = queue.poll();
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
                list.add(top.val);
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
