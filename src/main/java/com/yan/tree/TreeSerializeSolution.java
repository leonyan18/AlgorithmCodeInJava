package com.yan.tree;

import com.yan.base.Solution;
import org.springframework.stereotype.Service;

import javax.swing.tree.TreeNode;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


/**
 * BM39 序列化二叉树
 * https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84
 */
//@Service
public class TreeSerializeSolution implements Solution {
    String Serialize(TreeNode root) {
        String ans = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int check = root == null ? 0 : 1;
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            check += temp == null ? 0 : -1;
            if (temp == null) {
                ans += "#,";
                queue.add(null);
                queue.add(null);
            } else {
                ans += temp.val + ",";
                queue.add(temp.left);
                check += temp.left == null ? 0 : 1;
                queue.add(temp.right);
                check += temp.right == null ? 0 : 1;
            }
            if (check == 0) {
                break;
            }
        }
        int i;
        for (i = ans.length() - 1; i >= 0; i--) {
            if (ans.charAt(i) != '#' && ans.charAt(i) != ',') {
                break;
            }
        }
        ans = ans.substring(0, i + 1);
        return ans;
    }

    TreeNode Deserialize(String str) {
        if ("".equals(str)) {
            return null;
        }
        String[] strings = str.split(",");
        ArrayList<TreeNode> nodes = new ArrayList<>(strings.length);
        for (int i = 0; i < strings.length; i++) {
            String c = strings[i];
            if (c.equals("#")) {
                nodes.add(null);
            } else {
                TreeNode node = new TreeNode(Integer.parseInt(c));
                nodes.add(node);
            }
        }
        int pos = 0;
        TreeNode root = nodes.get(pos);
        while (pos < strings.length) {
            TreeNode temp = nodes.get(pos);
            if (temp != null) {
                if (pos * 2 + 1 < strings.length)
                    temp.left = nodes.get(pos * 2 + 1);
                if (pos * 2 + 2 < strings.length)
                    temp.right = nodes.get(pos * 2 + 2);
            }
            pos++;
        }
        return root;
    }

    @Override
    public void solve(InputStream in, OutputStream outputStream) {
        System.out.println(Serialize(Deserialize("")));
    }

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
