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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            TreeNode newRoot = new TreeNode(val);
            newRoot.left = root;
            return newRoot;
        }

        insert(root, val, 1, depth);
        return root;
    }

    private void insert(TreeNode node, int val, int currentDepth, int depth) {
        if (node == null) {
            return;
        }

        if (currentDepth == depth - 1) {
            TreeNode tempLeft = node.left;
            TreeNode tempRight = node.right;

            node.left = new TreeNode(val);
            node.right = new TreeNode(val);

            node.left.left = tempLeft;
            node.right.right = tempRight;
            return;
        }

        insert(node.left, val, currentDepth + 1, depth);
        insert(node.right, val, currentDepth + 1, depth);
    }
}