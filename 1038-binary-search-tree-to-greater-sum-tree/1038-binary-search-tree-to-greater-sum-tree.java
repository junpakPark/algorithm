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
    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }

        List<TreeNode> nodes = new ArrayList<>();
        reverseInOrderTraversal(root, nodes);

        int cumulativeSum = 0;
        for (TreeNode node : nodes) {
            cumulativeSum += node.val;
            node.val = cumulativeSum;
        }

        return root;
    }

    private void reverseInOrderTraversal(TreeNode node, List<TreeNode> nodes) {
        if (node.right != null) {
            reverseInOrderTraversal(node.right, nodes);
        }

        nodes.add(node);

        if (node.left != null) {
            reverseInOrderTraversal(node.left, nodes);
        }
    }
}