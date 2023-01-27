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

public class MaxWidth {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        System.out.println("Maximum Width of Binary Tree: " + maxWidthOfBinaryTree(root));
    }

    public static int maxWidthOfBinaryTree(BinaryTreeNode root) {
        if (root == null)
            return 0;

        ArrayDeque<BinaryTreeNode> q = new ArrayDeque<>();
        q.offer(root);

        int res = 0;
        while (!q.isEmpty()) {
            int count = q.size();
            res = Math.max(count, res);
            for (int i = 0; i < count; i++) {
                BinaryTreeNode curr = q.poll();
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
        }
        return res;
    }
}