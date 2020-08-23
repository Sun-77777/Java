import sun.reflect.generics.tree.Tree;

import java.util.Scanner;

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
