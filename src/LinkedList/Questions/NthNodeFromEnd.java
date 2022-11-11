package LinkedList.Questions;

//class Node {
//    int data;
//    Node next;
//
//    Node(int d) {
//        data = d;
//        next = null;
//    }
//}

public class NthNodeFromEnd {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        iterativeTraversal(head);
        nthNodeFromEnd(head, 2);
    }

    public static void nthNodeFromEnd(Node head, int n) {
        if (head == null || head.next == null)
            return;

        Node first = head, second = head;
        for (int i = 1; i <= n; i++) {
            if(first == null)
                return;
            
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        System.out.println(second.data);
    }

    public static void iterativeTraversal(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println();
    }
}