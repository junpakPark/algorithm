class Solution {
    private int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        findUnivaluePath(root);

        return result;
    }

    private int findUnivaluePath(final TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftValue = findUnivaluePath(root.left);
        int rightValue = findUnivaluePath(root.right);
        
        if (root.left != null && root.left.val == root.val) {
            leftValue++;
        } else {
            leftValue = 0;
        }

        if (root.right != null && root.right.val == root.val) {
            rightValue++;
        } else {
            rightValue = 0;
        }

        result = Math.max(result, leftValue + rightValue);

        return Math.max(leftValue, rightValue);
    }

}