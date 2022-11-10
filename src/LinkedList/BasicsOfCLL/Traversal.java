package LinkedList.BasicsOfCLL;

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
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = head;

        forLoopTraversal(head);
        dowhileLoopTraversal(head);
    }

    public static void forLoopTraversal(Node head) {
        System.out.print("-> " + head.data + " -> ");
        for (Node curr = head.next; curr != head; curr = curr.next)
            System.out.print(curr.data + " -> ");
        System.out.println();
    }

    public static void dowhileLoopTraversal(Node head) {
        Node curr = head;
        System.out.print("-> ");
        do {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }
}