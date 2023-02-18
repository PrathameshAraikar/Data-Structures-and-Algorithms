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

public class SerializeDeserialize {

    static final int EMPTY = -1;
    static int index = 0;

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(20);
        root.right = new BinaryTreeNode(30);
        root.left.left = new BinaryTreeNode(40);
        root.left.right = new BinaryTreeNode(50);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(70);

        ArrayList<Integer> serializedBT = new ArrayList<>();
        serializedBT = serializeBT(root, serializedBT);
        System.out.println("Serialized Binary Tree: " + serializedBT);
        BinaryTreeNode deserializedRoot = deserializeBT(serializedBT);
        System.out.print("Deserialized Binary Tree: ");
        preorder(deserializedRoot);
    }

    public static ArrayList<Integer> serializeBT(BinaryTreeNode root, ArrayList<Integer> arrList) {
        if (root == null) {
            arrList.add(EMPTY);
            return arrList;
        }
        arrList.add(root.data);
        serializeBT(root.left, arrList);
        serializeBT(root.right, arrList);

        return arrList;
    }

    public static BinaryTreeNode deserializeBT(ArrayList<Integer> arrList) {
        if (index == arrList.size())
            return null;

        int data = arrList.get(index);
        index++;
        if (data == -1)
            return null;
        BinaryTreeNode root = new BinaryTreeNode(data);
        root.left = deserializeBT(arrList);
        root.right = deserializeBT(arrList);

        return root;
    }

    public static void preorder(BinaryTreeNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
}