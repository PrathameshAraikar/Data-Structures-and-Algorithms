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

class Distance {
    int val;

    Distance(int d) {
        val = d;
    }
}


public class BurnBTFromLeaf {
    static int res = 0;

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.left.left.left = new BinaryTreeNode(60);
        root.left.left.left.left = new BinaryTreeNode(70);

        Scanner sc = new Scanner(System.in);
        Distance dist = new Distance(-1);
        int leaf = sc.nextInt();
        timeToBurnBT(root, leaf, dist);
        System.out.println("Time to Burn BT: " + res);
    }

    public static int timeToBurnBT(BinaryTreeNode root, int leaf, Distance dist) {
        if (root == null)
            return 0;
        if (root.data == leaf) {
            dist.val = 0;
            return 1;
        }

        Distance ldist = new Distance(-1), rdist = new Distance(-1);
        int leftHeight = timeToBurnBT(root.left, leaf, ldist);
        int rightHeight = timeToBurnBT(root.right, leaf, rdist);

        if (ldist.val != -1) {
            dist.val = ldist.val + 1;
            res = Math.max(res, (dist.val + rightHeight));
        } else if (rdist.val != -1) {
            dist.val = rdist.val + 1;
            res = Math.max(res, (dist.val + leftHeight));
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}