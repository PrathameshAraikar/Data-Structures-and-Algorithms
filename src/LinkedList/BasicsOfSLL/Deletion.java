package LinkedList.BasicsOfSLL;

//class Node {
//    int data;
//    Node next;
//
//    Node(int d) {
//        data = d;
//        next = null;
//    }
//}

public class Deletion {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        iterativeTraversal(head);
        head = deleteHead(head);
        iterativeTraversal(head);
        head = deleteTail(head);
        iterativeTraversal(head);
    }

    public static Node deleteHead(Node head) {
        if (head == null || head.next == null)
            return null;

        return head.next;
    }

    public static Node deleteTail(Node head) {
        if (head == null || head.next == null)
            return null;

        Node curr = head;
        while (curr.next.next != null)
            curr = curr.next;

        curr.next = null;
        return head;
    }

    public static void iterativeTraversal(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }

        System.out.println();
    }
}