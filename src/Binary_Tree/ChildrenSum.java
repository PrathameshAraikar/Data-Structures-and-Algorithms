package Binary_Tree;

//class BinaryTreeNode {
//    int data;
//    BinaryTreeNode left, right;
//
//    BinaryTreeNode(int k) {
//        data = k;
//    }
//}

public class ChildrenSum {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(50);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
//        root.left.left = new BinaryTreeNode(40);
//        root.left.right = new BinaryTreeNode(50);
//        root.right.left = new BinaryTreeNode(60);
//        root.right.right = new BinaryTreeNode(70);

        System.out.println("Children Sum Property: " + isChildrenSumPropertyTrue(root));
    }

    public static boolean isChildrenSumPropertyTrue(BinaryTreeNode root) {
        if (root == null)
            return true;

        if (root.left == null && root.right == null)
            return true;

        int sum = 0;
        if (root.left != null)
            sum += root.left.data;

        if (root.right != null)
            sum += root.right.data;

        return root.data == sum && isChildrenSumPropertyTrue(root.left) && isChildrenSumPropertyTrue(root.right);
    }
}