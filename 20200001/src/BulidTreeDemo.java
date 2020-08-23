

import java.util.*;

public class BulidTreeDemo {
    static class TreeNode {
        public char val;
        TreeNode left;
        TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.next();
            TreeNode root = build(line);
            inOrder(root);
            System.out.println();
            levelOrderTraversal(root);
            System.out.println(levelOrder(root));
        }
    }
    private static List<List<Character>> result = new ArrayList<>();

    public static List<List<Character>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        Helper(root,0);
        return result;
    }

    private static void Helper(TreeNode root, int level) {
        if (result.size() == level) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        Helper(root.left,level + 1);
        Helper(root.right,level + 1);
    }

    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
        }
    }

    private static void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private static int index = 0;
    private static TreeNode build(String line) {
        index = 0;
        return createTreePreOrder(line);
    }

    private static TreeNode createTreePreOrder(String line) {
        char c = line.charAt(index);
        if (c == '#') {
            return null;
        }
        //当前字符不是# ，就创建一个节点
        TreeNode node = new TreeNode(c);
        index++;
        node.left = createTreePreOrder(line);
        index++;
        node.right = createTreePreOrder(line);
        return node;
    }

    /*private static TreeNode createTreePreOrder(String line) {
        return null;
    }*/
}
