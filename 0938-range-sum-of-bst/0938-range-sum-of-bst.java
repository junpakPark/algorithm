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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int result = 0;
        
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            
            if(node.val > low && node.left != null) {
                queue.add(node.left);
            }
            if(node.val < high && node.right != null) {
                queue.add(node.right);
            }
            if(low <= node.val && node.val <= high) {
                result += node.val;
            }
        }
        return result;
    }
}