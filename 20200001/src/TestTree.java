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
        return 1 + size(root.left) + size(root.right);
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

    public int kLevelSize(TreeNode root,int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return kLevelSize(root.left,k-1) + kLevelSize(root.right,k-1);
    }

    public TreeNode find(TreeNode root,char toFind) {
        if (root == null) {
            return null;
        }
        if (root.val == toFind) {
            return root;
        }
        TreeNode result = find(root.left,toFind);
        if (result != null) {
            return result;
        }
        return find(root.right,toFind);
    }

}
