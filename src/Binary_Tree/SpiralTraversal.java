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

public class SpiralTraversal {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        zigzagTraversal(root);
    }

    public static void zigzagTraversal(BinaryTreeNode root) {
        ArrayDeque<BinaryTreeNode> s1 = new ArrayDeque<>();
        ArrayDeque<BinaryTreeNode> s2 = new ArrayDeque<>();
        s2.push(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            while (!s1.isEmpty()) {
                BinaryTreeNode curr = s1.pop();
                System.out.print(curr.data + " ");
                if (curr.right != null)
                    s2.push(curr.right);
                if (curr.left != null)
                    s2.push(curr.left);
            }

            while (!s2.isEmpty()) {
                BinaryTreeNode curr = s2.pop();
                System.out.print(curr.data + " ");
                if (curr.left != null)
                    s1.push(curr.left);
                if (curr.right != null)
                    s1.push(curr.right);
            }
        }
    }
}