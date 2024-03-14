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
    
    private int prev = Integer.MIN_VALUE + 100000;
    private int minDiff = Integer.MAX_VALUE;
    
    public int minDiffInBST(TreeNode root) {
        if(root.left != null) {
            minDiffInBST(root.left);
        }
        
        minDiff = Math.min(minDiff, root.val - prev);
        prev = root.val;
        
        if(root.right != null) {
            minDiffInBST(root.right);
        }
        
        return minDiff;
    }
}