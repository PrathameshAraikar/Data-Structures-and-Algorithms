package Binary_Tree;

//class BinaryTreeNode {
//    int data;
//    BinaryTreeNode left, right;
//
//    BinaryTreeNode(int k) {
//        data = k;
//    }
//}

import java.util.*;

public class BalancedBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        System.out.println("Is Tree Balanced: " + (isBalanced(root) > 0 ? "Balanced" : "Not Balanced"));
    }

    public static int isBalanced(BinaryTreeNode root) {
        if (root == null)
            return 0;

        int leftHeight = isBalanced(root.left);
        if (leftHeight == -1)
            return -1;

        int rightHeight = isBalanced(root.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return Math.max(leftHeight, rightHeight) + 1;
    }
}