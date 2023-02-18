package Binary_Tree;

//class BinaryTreeNode {
//    int data;
//    BinaryTreeNode left, right;
//
//    BinaryTreeNode(int k) {
//        data = k;
//    }
//}

public class Size {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        System.out.println("Total Number of Nodes: " + totalCountOfNodes(root));
    }

    public static int totalCountOfNodes(BinaryTreeNode root) {
        if (root == null)
            return 0;

        return 1 + totalCountOfNodes(root.left) + totalCountOfNodes(root.right);
    }
}