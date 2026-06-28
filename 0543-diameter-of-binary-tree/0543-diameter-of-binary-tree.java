class Solution {
    int dia = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return dia;
    }

    private int height(TreeNode root) {
        if (root == null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        dia = Math.max(dia, left + right);

        return Math.max(left, right) + 1;
    }
}