public class Interview3 {
    public static void main(String[] args) {

    }

    public static boolean findTarget(TreeNode root, int target) {
        return root == null ? false : findTarget(root.left, target) || root.val == target || findTarget(root.right, target);
    }

    public static boolean findTarget2(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        boolean leftExists = findTarget(root.left, target);
        if (leftExists) {
            return true;
        }

        if (root.val == target) {
            return true;
        }

        boolean rightExists = findTarget(root.right, target);

        return rightExists;
    }
}


class TreeNode {
    int val;
    TreeNode left, right;
    public TreeNode(){}

    public TreeNode(int val) {
        this.val = val;
    }
}