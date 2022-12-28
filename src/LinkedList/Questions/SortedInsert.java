package LinkedList.Questions;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class SortedInsert {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        iterativeTraversal(head);
        head = sortedInsert(head, 45);
        iterativeTraversal(head);
        head = sortedInsert(head, 5);
        iterativeTraversal(head);
        head = sortedInsert(head, 60);
        iterativeTraversal(head);
    }

    public static Node sortedInsert(Node head, int element) {
        Node temp = new Node(element);
        if (head == null || head.data > element) {
            temp.next = head;
            return temp;
        }

        Node curr = head;
        while (curr.next != null && curr.next.data < element)
            curr = curr.next;

        temp.next = curr.next;
        curr.next = temp;

        return head;
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