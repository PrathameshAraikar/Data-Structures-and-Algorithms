package Binary_Tree;

//class BinaryTreeNode {
//    int data;
//    BinaryTreeNode left, right;
//
//    BinaryTreeNode(int k) {
//        data = k;
//    }
//}

public class Diameter {

    static int res = 0;
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        System.out.println("Height of BinaryTree: " + heightOfBinaryTree(root));
        System.out.println("Diameter of BinaryTree: " + res);
    }

    public static int heightOfBinaryTree(BinaryTreeNode root) {
        if(root == null)
            return 0;

        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        res = Math.max(res, (1 + leftHeight + rightHeight));

        return 1 + Math.max(leftHeight, rightHeight);
    }
}