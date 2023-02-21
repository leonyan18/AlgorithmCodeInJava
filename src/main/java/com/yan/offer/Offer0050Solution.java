package com.yan.offer;

import com.yan.base.Solution;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer II 050. 向下的路径节点之和
 * https://leetcode.cn/problems/6eUYwP/
 */

public class Offer0050Solution implements Solution {
    public int pathSum(TreeNode root, int targetSum) {
        return pathSum1(root, targetSum);
    }

    public int pathSum1(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        int ret = rootSum(root, targetSum);
        ret += pathSum1(root.left, targetSum);
        ret += pathSum1(root.right, targetSum);
        return ret;
    }

    public int rootSum(TreeNode root, long targetSum) {
        int ret = 0;

        if (root == null) {
            return 0;
        }
        int val = root.val;
        if (val == targetSum) {
            ret++;
        }

        ret += rootSum(root.left, targetSum - val);
        ret += rootSum(root.right, targetSum - val);
        return ret;
    }

    public int pathSum2(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        return dfs(root, targetSum + 0L, 0L, map);
    }

    public int dfs(TreeNode root, Long targetSum, Long pre, Map<Long, Integer> map) {
        if (root == null) {
            return 0;
        }
        Long now = pre + root.val;
        // map.put(now,map.getOrDefault(now,0)+1);
        int cnt = map.getOrDefault(now - targetSum, 0);
        map.put(now, map.getOrDefault(now, 0) + 1);
        cnt += dfs(root.left, targetSum, now, map);
        cnt += dfs(root.right, targetSum, now, map);
        map.put(now, map.getOrDefault(now, 0) - 1);
        return cnt;
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
