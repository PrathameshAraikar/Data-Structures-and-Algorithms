package LinkedList.BasicsOfDLL;

class Node {
    int data;
    Node prev, next;

    Node(int d) {
        data = d;
        prev = null;
        next = null;
    }
}

public class Insertion {
    public static void main(String[] args) {
        Node head = null;
        head = insertAtBegin(head, 10);
        head = insertAtBegin(head, 20);
        head = insertAtBegin(head, 30);
        iterativeTraversal(head);

        head = insertAtEnd(head, 40);
        head = insertAtEnd(head, 50);
        head = insertAtEnd(head, 60);
        iterativeTraversal(head);
    }

    public static Node insertAtBegin(Node head, int data) {
        Node temp = new Node(data);
        temp.next = head;
        if (head != null)
            head.prev = temp;
        return temp;
    }

    public static Node insertAtEnd(Node head, int data) {
        Node temp = new Node(data);
        if(head == null)
            return temp;

        Node curr = head;
        while(curr.next != null)
            curr = curr.next;

        curr.next = temp;
        temp.prev = curr;
        return head;
    }

    public static void iterativeTraversal(Node head) {
        Node curr = head;
        System.out.print("null <-> ");
        while (curr != null) {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        }
        System.out.print("null");
        System.out.println();
    }
}