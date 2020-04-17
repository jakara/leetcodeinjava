package tree.ValidateBinarySearchTree;

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * 
 */
class Solution {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<TreeNode, Integer> maxValue = new HashMap<>();

    Map<TreeNode, Integer> minValue = new HashMap<>();

    public Integer min(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (minValue.containsKey(root)) {
            return minValue.get(root);
        }

        Integer min = min(root.val, min(min(root.left), min(root.right)));
        minValue.putIfAbsent(root, min);
        return min;

    }

    public Integer min(Integer l, Integer m) {
        if (l == null) {
            return m;
        }
        if (m == null) {
            return l;
        }
        return Math.min(l, m);
    }

    public Integer max(TreeNode root) {
        if (root == null) {
            return null;
        }

        if (maxValue.containsKey(root)) {
            return maxValue.get(root);
        }

        Integer max = max(root.val, max(max(root.left), max(root.right)));
        maxValue.putIfAbsent(root, max);
        return max;

    }

    public Integer max(Integer l, Integer m) {
        if (l == null) {
            return m;
        }
        if (m == null) {
            return l;
        }
        return Math.max(l, m);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Integer lm = max(root.left);
        Integer rm = min(root.right);
        return (lm == null || lm < root.val) && (rm == null || rm > root.val) && isValidBST(root.left)
                && isValidBST(root.right);
    }
}