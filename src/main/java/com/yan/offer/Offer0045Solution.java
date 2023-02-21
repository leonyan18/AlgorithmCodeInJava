package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer II 045. 二叉树最底层最左边的值
 * https://leetcode.cn/problems/LwUNpT/
 */

public class Offer0045Solution implements Solution {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        int cnt = 0;
        int level = 1;
        int nextlevel = 0;
        int ans = 0;
        while (queue.size() != 0) {
            TreeNode top = queue.poll();
            if (cnt == 0) {
                ans = top.val;
            }
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
                level = nextlevel;
                nextlevel = 0;
                cnt = 0;
            }
        }
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
