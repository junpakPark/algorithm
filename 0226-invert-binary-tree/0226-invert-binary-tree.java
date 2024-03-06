class Solution {
    public TreeNode invertTree(TreeNode root) {
        dfs(root);

        return root;
    }

    private void dfs(final TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        dfs(root.left);
        dfs(root.right);
    }
}