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

public class LeftView {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        printLeftView(root);
    }

    public static void printLeftView(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                BinaryTreeNode curr = q.poll();
                if (i == 0)
                    System.out.print(curr.data + " ");
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
        }
    }
}