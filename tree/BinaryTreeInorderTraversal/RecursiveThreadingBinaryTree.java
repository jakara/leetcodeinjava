package tree.BinaryTreeInorderTraversal;

public class RecursiveThreadingBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        boolean leftIsThread;
        boolean rightIsThread;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode pre;

    public void inThreading(TreeNode curr) {
        if (curr == null) {
            return;
        }

        inThreading(curr.left);

        if (curr.left == null) {
            curr.left = pre;
            curr.leftIsThread = true;
        }
        if (pre != null && pre.right == null) {
            pre.right = curr;
            pre.rightIsThread = true;
        }
        pre = curr;

        inThreading(curr.right);
    }

}