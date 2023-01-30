package Binary_Tree;

//class BinaryTreeNode {
//    int data;
//    BinaryTreeNode left, right;
//
//    BinaryTreeNode(int k) {
//        data = k;
//    }
//}

public class CountNodesInCompleteBT {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        System.out.println("Size of Complete Binary Tree: " + sizeOfCompleteBT(root));
    }

    public static double sizeOfCompleteBT(BinaryTreeNode root) {
        int lh = 0, rh = 0;
        if(root == null)
            return 0;

        BinaryTreeNode curr = root;
        while(curr != null) {
            curr = curr.left;
            lh++;
        }

        curr = root;
        while(curr != null) {
            curr = curr.right;
            rh++;
        }

        if(lh == rh)
            return Math.pow(2, lh) - 1;
        return 1 + sizeOfCompleteBT(root.left) + sizeOfCompleteBT(root.right);
    }
}