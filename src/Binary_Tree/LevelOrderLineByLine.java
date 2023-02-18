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

public class LevelOrderLineByLine {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);
        root.right.right.right = new BinaryTreeNode(80);

        levelOrderUsingNull(root);
        System.out.println();
        System.out.println();
        levelOrderUsingTwoLoops(root);
    }

    public static void levelOrderUsingNull(BinaryTreeNode root) {
        if (root == null)
            return;

        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(null);

        while (q.size() > 1) {
            BinaryTreeNode curr = q.poll();
            if (curr == null) {
                System.out.println();
                q.offer(null);
                continue;
            }
            System.out.print(curr.data + " ");
            if (curr.left != null)
                q.offer(curr.left);
            if (curr.right != null)
                q.offer(curr.right);
        }
    }

    public static void levelOrderUsingTwoLoops(BinaryTreeNode root) {
        if (root == null)
            return;

        ArrayDeque<BinaryTreeNode> q = new ArrayDeque<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int count = q.size();
            for (int i = 0; i < count; i++) {
                BinaryTreeNode curr = q.poll();
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
            }
            System.out.println();
        }
    }
}