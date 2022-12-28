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

public class Insertion {
    public static void main(String[] args) {
        Node head = null, head1 = null, head2 = null, head3 = null;
        head = insertAtHeadNaive(head, 10);
        head = insertAtHeadNaive(head, 20);
        head = insertAtHeadNaive(head, 30);
        forLoopTraversal(head);

        head1 = insertAtHeadEfficient(head1, 40);
        head1 = insertAtHeadEfficient(head1, 50);
        head1 = insertAtHeadEfficient(head1, 60);
        forLoopTraversal(head1);

        head2 = insertAtEndNaive(head2, 70);
        head2 = insertAtEndNaive(head2, 80);
        head2 = insertAtEndNaive(head2, 90);
        forLoopTraversal(head2);

        head3 = insertAtEndEfficient(head3, 100);
        head3 = insertAtEndEfficient(head3, 110);
        head3 = insertAtEndEfficient(head3, 120);
        forLoopTraversal(head3);
    }

    public static Node insertAtHeadNaive(Node head, int element) {
        Node temp = new Node(element);
        if (head == null) {
            temp.next = temp;
            return temp;
        }

        Node curr = head;
        while (curr.next != head)
            curr = curr.next;

        temp.next = head;
        curr.next = temp;
        return temp;
    }

    public static Node insertAtHeadEfficient(Node head, int element) {
        Node temp = new Node(element);
        if (head == null) {
            temp.next = temp;
            return temp;
        }

        temp.next = head.next;
        head.next = temp;

        // Swap the data of temp node and head node
        int t = temp.data;
        temp.data = head.data;
        head.data = t;

        return head;
    }

    public static Node insertAtEndNaive(Node head, int element) {
        Node temp = new Node(element);
        if (head == null) {
            temp.next = temp;
            return temp;
        }

        Node curr = head;
        while (curr.next != head)
            curr = curr.next;

        temp.next = head;
        curr.next = temp;

        return head;
    }

    public static Node insertAtEndEfficient(Node head, int element) {
        Node temp = new Node(element);
        if (head == null) {
            temp.next = temp;
            return temp;
        }

        temp.next = head.next;
        head.next = temp;

        // Swap the data of head node and temp node
        int t = temp.data;
        temp.data = head.data;
        head.data = t;

        return temp;
    }

    public static void forLoopTraversal(Node head) {
        System.out.print("-> " + head.data + " -> ");
        for (Node curr = head.next; curr != head; curr = curr.next)
            System.out.print(curr.data + " -> ");
        System.out.println();
    }
}