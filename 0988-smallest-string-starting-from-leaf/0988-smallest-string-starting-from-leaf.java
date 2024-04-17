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
    private String smallest = null;

    public String smallestFromLeaf(TreeNode root) {
        dfs(root, new StringBuilder());
        return smallest;
    }

    private void dfs(TreeNode node, StringBuilder path) {
        if (node == null) {
            return;
        }

        path.append((char) ('a' + node.val));

        if (node.left == null && node.right == null) {
            path.reverse();
            String currentPath = path.toString();
            path.reverse();

            if (smallest == null || currentPath.compareTo(smallest) < 0) {
                smallest = currentPath;
            }
        }

        dfs(node.left, path);
        dfs(node.right, path);
        
        path.deleteCharAt(path.length() - 1);
    }
}