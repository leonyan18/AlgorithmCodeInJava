package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 055. 二叉搜索树迭代器
 * https://leetcode.cn/problems/kTOapQ/
 */
//@Service
public class Offer0055Solution implements Solution {
    class BSTIterator {
        TreeNode head;
        TreeNode now;
        TreeNode end;

        public BSTIterator(TreeNode root) {
            head = new TreeNode(Integer.MIN_VALUE);
            head.left = null;
            head.right = root;
            end = findEnd(root);
            now = head;
        }

        public int next() {
            TreeNode node = findNext(head, now.val);
            now = node;
            return now.val;
        }

        public boolean hasNext() {
            if (now.val != end.val) {
                return true;
            }
            return false;
        }

        public TreeNode findNext(TreeNode root, int target) {
            if (root == null) {
                return null;
            }
            System.out.println(root.val);
            TreeNode node = null;
            if (root.val > target) {
                node = findNext(root.left, target);
            } else {
                node = findNext(root.right, target);
            }
            if (node == null || node.val <= target) {
                return root;
            }
            return node;
        }

        public TreeNode findEnd(TreeNode root) {
            TreeNode node = null;
            if (root.right != null) {
                return findEnd(root.right);
            }
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
