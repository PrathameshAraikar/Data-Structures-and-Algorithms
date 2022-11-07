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
        head = insertAtEnd(head, 40);
        head = insertAtEnd(head, 50);
        head = insertAtEnd(head, 60);
        iterativeTraversal(head);
    }

    public static Node insertAtBegin(Node head, int element) {
        Node temp = new Node(element);
        temp.next = head;
        return temp;
    }

    public static Node insertAtEnd(Node head, int element) {
        Node temp = new Node(element);
        if(head == null)
            return head;

        Node curr = head;
        while(curr.next != null)
            curr = curr.next;

        curr.next = temp;
        return head;
    }

    public static void iterativeTraversal(Node head) {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
    }
}