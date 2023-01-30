package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 051. 节点之和最大的路径
 * https://leetcode.cn/problems/jC7MId/
 */
//@Service
public class Offer0051Solution implements Solution {
    int maxv = -1001;

    public int maxPathSum(TreeNode root) {
        maxSum(root);
        return maxv;
    }

    public int maxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxSum(root.left);
        int right = maxSum(root.right);
        maxv = Math.max(maxv, left + right + root.val);
        if (left <= 0 && right <= 0) {
            return root.val > 0 ? root.val : 0;
        }
        left += root.val;
        right += root.val;
        if (left > right) {
            return left > 0 ? left : 0;
        } else {
            return right > 0 ? right : 0;
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
