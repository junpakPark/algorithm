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
    public int rangeSumBST(TreeNode root, int low, int high) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        
        int result = 0;
        
        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            
            if(node.val > low && node.left != null) {
                stack.push(node.left);
            }
            if(node.val < high && node.right != null) {
                stack.push(node.right);
            }
            if(low <= node.val && node.val <= high) {
                result += node.val;
            }
        }
        return result;
    }
}