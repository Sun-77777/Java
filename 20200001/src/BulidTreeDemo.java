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
    }

    private static int index = 0;
    private static TreeNode build(String line) {
        index = 0;
        return createTreePreOrder(line);
    }

    private static TreeNode createTreePreOrder(String line) {
        return null;
    }

    /*private static TreeNode createTreePreOrder(String line) {
        return null;
    }*/
}
