package LinkedList.BasicsOfCLL;

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
        head.next.next.next.next.next = head;

        forLoopTraversal(head);

        head = deleteAtHeadNaive(head);
        forLoopTraversal(head);

        head = deleteAtHeadEfficient(head);
        forLoopTraversal(head);

        head = deleteKthNode(head, 2);
        forLoopTraversal(head);

    }

    public static Node deleteAtHeadNaive(Node head) {
        if (head == null || head.next == head)
            return null;

        Node curr = head;
        while (curr.next != head)
            curr = curr.next;

        curr.next = head.next;
        return curr.next;
    }

    public static Node deleteAtHeadEfficient(Node head) {
        if (head == null || head.next == head)
            return null;

        head.data = head.next.data;
        head.next = head.next.next;

        return head;
    }

    public static Node deleteKthNode(Node head, int k) {
        if (head == null)
            return null;

        if (k == 1)
            return deleteAtHeadEfficient(head);

        Node curr = head;
        for (int i = 1; i <= k - 2; i++)
            curr = curr.next;

        curr.next = curr.next.next;
        return head;
    }

    public static void forLoopTraversal(Node head) {
        System.out.print("-> " + head.data + " -> ");
        for (Node curr = head.next; curr != head; curr = curr.next)
            System.out.print(curr.data + " -> ");
        System.out.println();
    }
}