package LinkedList.BasicsOfSLL;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class Traversal {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);

        iterativeTraversal(head);
        System.out.println();
        recursiveTraversal(head);
        System.out.print("null");
    }

    public static void iterativeTraversal(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("null");
    }

    public static void recursiveTraversal(Node head) {
        if (head == null)
            return;

        System.out.print(head.data + " -> ");
        recursiveTraversal(head.next);
    }
}