import java.util.ArrayList;
import java.util.List;


class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
}
class Solution2 {

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalHelper(result,root);
        return result;
    }
    public static void preorderTraversalHelper(List<Integer> result,TreeNode root) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversalHelper(result,root.left);
        preorderTraversalHelper(result,root.right);

    }

}