package Binary_Tree;

//class BinaryTreeNode {
//    int data;
//    BinaryTreeNode left, right;
//
//    BinaryTreeNode(int k) {
//        data = k;
//    }
//}
public class BinaryTreeToDLL {
    static BinaryTreeNode prev = null;

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        BinaryTreeNode head = createDLLFromBT(root);
        printlist(head);
    }

    public static BinaryTreeNode createDLLFromBT(BinaryTreeNode root) {
        if (root == null)
            return root;

        BinaryTreeNode head = createDLLFromBT(root.left);
        if (prev == null)
            head = root;
        else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        createDLLFromBT(root.right);
        return head;
    }

    public static void printlist(BinaryTreeNode head) {
        BinaryTreeNode curr = head;
        System.out.print("null <-> ");
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.right;
        }
        System.out.print("null");
    }
}