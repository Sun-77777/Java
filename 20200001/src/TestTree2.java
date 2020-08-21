public class TestTree2 {
    static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean isSameTree(TreeNode p,TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left,q.left) && isSameTree(q.left,q.right);
    }
    //判断一棵树是不是另外一棵树的子树，
    // 本质上是就是判断一棵树和另外一棵树中的某个子树是否相等
    // 遍历 + 递归拆分问题
    // 判断s是否包含t => s 和 t 是否相等 || s.left 是否包含t || s.right是否包含t
    public boolean isSubTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        boolean ret = false;
        if (s.val == t.val) {
            ret = isSameTree(s,t);
        }
        /*if (!ret) {
            ret = isSubTree(s.left,t);
        }
        if (!ret) {
            isSubTree(s.right,t);
        }
        return ret;*/
        return ret || isSubTree(s.left,t) || isSubTree(s.right,t);
    }
}
