class Solution {
    public boolean isBalanced(TreeNode root) {
        return calculateHeight(root) != -1;
    }

    private int calculateHeight(final TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}