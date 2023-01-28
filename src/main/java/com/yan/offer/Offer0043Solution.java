package com.yan.offer;

import com.yan.base.Solution;

import javax.swing.tree.TreeNode;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;

/**
 * 剑指 Offer II 043. 往完全二叉树添加节点
 * https://leetcode.cn/problems/NaqhDT/
 */
//@Service
public class Offer0043Solution implements Solution {

    class CBTInserter {
        TreeNode root;
        int cnt = 1;

        public CBTInserter(TreeNode root) {
            this.root = root;
            TreeNode temp = root;
            cnt = 0;
            Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
            queue.add(root);
            while (queue.size() != 0) {
                TreeNode top = queue.poll();
                if (top != null) {
                    cnt++;
                }
                if (top.left != null) {
                    queue.add(top.left);
                }
                if (top.right != null) {
                    queue.add(top.right);
                }
            }
        }

        public int insert(int v) {
            cnt++;
            int pos = cnt;
            int now = 1;
            Stack<Integer> stack = new Stack<>();
            while (pos > 1) {
                stack.push(pos);
                pos = pos / 2;
            }
            TreeNode p = root;
            int next = 0;
            while (stack.size() > 1) {
                next = stack.pop();
                if (now * 2 != next) {
                    p = p.right;
                    now = now * 2 + 1;
                } else {
                    p = p.left;
                    now = now * 2;
                }
            }
            // System.out.println(cnt);
            next = stack.pop();
            if (now * 2 != next) {
                p.right = new TreeNode(v, null, null);
            } else {
                p.left = new TreeNode(v, null, null);
            }
            return p.val;
        }

        public TreeNode get_root() {
            return root;
        }
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
