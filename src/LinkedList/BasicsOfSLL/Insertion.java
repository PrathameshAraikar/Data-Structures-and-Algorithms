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

public class Insertion {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head, 10);
        head = insertAtBegin(head, 20);
        head = insertAtBegin(head, 30);
        iterativeTraversal(head);
        System.out.println();

        head = insertAtEnd(head, 40);
        head = insertAtEnd(head, 50);
        head = insertAtEnd(head, 60);
        iterativeTraversal(head);
        System.out.println();

        head = insertAtPosition(head, 3, 70);
        head = insertAtPosition(head, 1, 80);
        head = insertAtPosition(head, 9, 90);
        iterativeTraversal(head);
    }

    public static Node insertAtBegin(Node head, int element) {
        Node temp = new Node(element);
        temp.next = head;
        return temp;
    }

    public static Node insertAtEnd(Node head, int element) {
        Node temp = new Node(element);
        if (head == null)
            return head;

        Node curr = head;
        while (curr.next != null)
            curr = curr.next;

        curr.next = temp;
        return head;
    }

    public static Node insertAtPosition(Node head, int pos, int element) {
        Node temp = new Node(element);
        if (pos == 1) {
            temp.next = head;
            return temp;
        }

        Node curr = head;
        for (int i = 1; i <= pos - 2 && curr != null; i++)
            curr = curr.next;

        if (curr == null)
            return head;

        temp.next = curr.next;  // connect the temp.next -> remaining Linked list
        curr.next = temp;   // connect the curr.next to temp
        return head;    // therefore curr.next -> temp (temp.next) -> remaining Linked list
    }

    public static void iterativeTraversal(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.print("null");
    }
}