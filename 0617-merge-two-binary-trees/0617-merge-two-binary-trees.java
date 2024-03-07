class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
            
        int val = getValue(root1) + getValue(root2);
        TreeNode left = mergeTrees(root1 == null ? null : root1.left, 
                                   root2 == null ? null : root2.left);
        TreeNode right = mergeTrees(root1 == null ? null : root1.right, 
                                    root2 == null ? null : root2.right);

        return new TreeNode(val, left, right);
    }

    private int getValue(TreeNode treeNode) {
        return treeNode == null ? 0 : treeNode.val;
    }
}