package LinkedList.BasicsOfDLL;

//class Node {
//    int data;
//    Node prev, next;
//
//    Node(int d) {
//        data = d;
//        prev = null;
//        next = null;
//    }
//}

public class Deletion {
    public static void main(String[] args) {
        Node head = new Node(10);
        Node temp1 = new Node(20);
        Node temp2 = new Node(30);
        Node temp3 = new Node(40);
        Node temp4 = new Node(50);

        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
        temp2.next = temp3;
        temp3.prev = temp2;
        temp3.next = temp4;
        temp4.prev = temp3;
        temp4.next = null;

        iterativeTraversal(head);
        head = deleteHead(head);
        iterativeTraversal(head);
        head = deleteLast(head);
        iterativeTraversal(head);
    }

    public static Node deleteHead(Node head) {
        if(head == null || head.next == null)
            return null;

        head = head.next;
        head.prev = null;
        return head;
    }

    public static Node deleteLast(Node head) {
        if(head == null || head.next == null)
            return null;

        Node curr = head;
        while(curr.next != null)
            curr = curr.next;

        curr.prev.next = null;
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