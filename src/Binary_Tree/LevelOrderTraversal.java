package Binary_Tree;

import java.util.*;
//class BinaryTreeNode {
//    int data;
//    BinaryTreeNode left, right;
//
//    BinaryTreeNode(int k) {
//        data = k;
//    }
//}

public class LevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        printLevelOrder(root);
    }

    public static void printLevelOrder(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            BinaryTreeNode curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null)
                q.offer(curr.left);
            if (curr.right != null)
                q.offer(curr.right);
        }
    }
}