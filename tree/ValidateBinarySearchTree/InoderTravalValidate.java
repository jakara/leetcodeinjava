package tree.ValidateBinarySearchTree;

import java.util.Stack;

import tree.ValidateBinarySearchTree.Solution.TreeNode;
/**
 * 中序遍历的结果应该是递增的
 * 这个实现是基于stask的非递归中序遍历
 */
public class InoderTravalValidate {
    class Solution {
        public boolean isValidBST(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            double inorder = -Double.MAX_VALUE;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                // If next element in inorder traversal
                // is smaller than the previous one
                // that's not BST.
                if (root.val <= inorder)
                    return false;
                inorder = root.val;
                root = root.right;
            }
            return true;
        }
    }
}