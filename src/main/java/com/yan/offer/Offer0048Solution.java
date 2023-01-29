package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer II 048. 序列化与反序列化二叉树
 * https://leetcode.cn/problems/h54YBf/
 */
//@Service
public class Offer0048Solution implements Solution {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }
        String ans = root.val + "," + serialize(root.left) + "," + serialize(root.right);
        // System.out.println(ans);
        return ans;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strings = data.split(",");
        List<String> datas = new LinkedList<>(Arrays.asList(strings));
        return doDeserialize(datas);
    }

    public TreeNode doDeserialize(List<String> datas) {
        if (datas.size() == 0) {
            return null;
        }
        if (datas.get(0).equals("null")) {
            datas.remove(0);
            return null;
        }
        int val = Integer.valueOf(datas.get(0));
        TreeNode root = new TreeNode(val);
        datas.remove(0);
        root.left = doDeserialize(datas);
        root.right = doDeserialize(datas);
        // System.out.println(val);
        return root;
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
