package Binary_Tree;

//class BinaryTreeNode {
//    int data;
//    BinaryTreeNode left, right;
//
//    BinaryTreeNode(int k) {
//        data = k;
//    }
//}

public class LowestCommonAncestor {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        BinaryTreeNode lca = lca(root, 40, 50);
        System.out.println("Lowest Common Ancestor: " + lca.data);
    }

    public static BinaryTreeNode lca(BinaryTreeNode root, int n1, int n2) {
        if(root == null)
            return null;
        if(root.data == n1 || root.data == n2)
            return root;

        BinaryTreeNode lca1 = lca(root.left, n1, n2);
        BinaryTreeNode lca2 = lca(root.right, n1, n2);

        if(lca1 != null && lca2 != null)
            return root;
        else if(lca1 != null)
            return lca1;
        return lca2;
    }
}