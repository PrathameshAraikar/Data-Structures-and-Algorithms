package Binary_Tree;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left, right;

    BinaryTreeNode(int k) {
        data = k;
    }
}

public class DepthTraversal {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        System.out.print("INORDER: ");
        inorder(root);
        System.out.println();

        System.out.print("PREORDER: ");
        preorder(root);
        System.out.println();

        System.out.print("POSTORDER: ");
        postorder(root);
        System.out.println();
    }

    public static void inorder(BinaryTreeNode root) {
        if(root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void preorder(BinaryTreeNode root) {
        if(root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(BinaryTreeNode root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }
}