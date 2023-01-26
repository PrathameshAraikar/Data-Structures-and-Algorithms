package Binary_Tree;

//class BinaryTreeNode {
//    int data;
//    BinaryTreeNode left, right;
//
//    BinaryTreeNode(int k) {
//        data = k;
//    }
//}

public class Maximum {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        System.out.println("Maximum: " + getMax(root));
    }

    public static int getMax(BinaryTreeNode root) {
        if (root == null)
            return 0;

        return Math.max(root.data, Math.max(getMax(root.left), getMax(root.right)));
    }
}