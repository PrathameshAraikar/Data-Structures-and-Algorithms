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

public class ConstructBTFromInAndPre {

    static int preorderIndex = 0;
    static Map<Integer, Integer> hMap = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inorder = new int[n];
        int[] preorder = new int[n];

        System.out.print("Inorder: ");
        for (int i = 0; i < n; i++)
            inorder[i] = sc.nextInt();

        System.out.print("Preorder: ");
        for (int i = 0; i < n; i++)
            preorder[i] = sc.nextInt();

        createHashmap(inorder);
        BinaryTreeNode root = createBinaryTree(inorder, preorder, 0, n - 1);

        System.out.print("INORDER: ");
        inorder(root);
        System.out.println();

        System.out.print("PREORDER: ");
        preorder(root);
        System.out.println();

        sc.close();
    }

    public static BinaryTreeNode createBinaryTree(int[] inorder, int[] preorder, int inorderStart, int inorderEnd) {
        if (inorderStart > inorderEnd)
            return null;

        BinaryTreeNode root = new BinaryTreeNode(preorder[preorderIndex++]);
        root.left = createBinaryTree(inorder, preorder, inorderStart, hMap.get(root.data) - 1);
        root.right = createBinaryTree(inorder, preorder, hMap.get(root.data) + 1, inorderEnd);

        return root;
    }

    public static void createHashmap(int[] inorder) {
        for (int i = 0; i < inorder.length; i++)
            hMap.put(inorder[i], i);
    }

    public static void inorder(BinaryTreeNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void preorder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
}