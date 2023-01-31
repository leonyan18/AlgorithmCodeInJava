package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;

/**
 * 剑指 Offer II 054. 所有大于等于节点的值之和
 * https://leetcode.cn/problems/w6cpku/
 */
//@Service
public class Offer0054Solution implements Solution {
    public TreeNode convertBST(TreeNode root) {
        int all = sum(root);
        // System.out.println
        getval(all, root);
        return root;
    }

    public int sum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = root.val;
        ans += sum(root.left);
        ans += sum(root.right);
        return ans;
    }

    public int getval(int cnt, TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = root.val;
        int left = getval(cnt, root.left);
        int right = getval(cnt - left - root.val, root.right);
        root.val = cnt - left;
        ans += right + left;
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
