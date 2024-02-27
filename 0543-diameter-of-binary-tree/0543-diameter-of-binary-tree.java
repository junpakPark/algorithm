/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);

        return result;
    }

    private int calculateHeight(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = calculateHeight(root.left);
        int rightHeight = calculateHeight(root.right);

        result = Math.max(result, leftHeight + rightHeight);

        return Math.max(leftHeight, rightHeight) + 1;

    }
}