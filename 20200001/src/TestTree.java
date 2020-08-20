public class TestTree {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;
    }

    public int size(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + size(root.left) + size(root.right)
    }

    public int leafSize(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return leafSize(root.left) + leafSize(root.right);
    }
}
