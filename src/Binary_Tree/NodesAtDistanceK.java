package Binary_Tree;

//class BinaryTreeNode {
//    int data;
//    BinaryTreeNode left, right;
//
//    BinaryTreeNode(int k) {
//        data = k;
//    }
//}

public class NodesAtDistanceK {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        System.out.print("Nodes at Distance 0: ");
        nodesAtKDistance(root, 0);
        System.out.println();

        System.out.print("Nodes at Distance 1: ");
        nodesAtKDistance(root, 1);
        System.out.println();

        System.out.print("Nodes at Distance 2: ");
        nodesAtKDistance(root, 2);
        System.out.println();

    }

    public static void nodesAtKDistance(BinaryTreeNode root, int k) {
        if (root == null)
            return;

        if (k == 0)
            System.out.print(root.data + " ");

        nodesAtKDistance(root.left, k - 1);
        nodesAtKDistance(root.right, k - 1);
    }
}