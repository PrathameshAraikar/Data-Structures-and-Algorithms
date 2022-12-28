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

public class Reverse {
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
        head = reverse(head);
        iterativeTraversal(head);
    }

    public static Node reverse(Node head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;

        Node curr = head, previous = null;
        while(curr != null) {
            previous = curr.prev;
            curr.prev = curr.next;
            curr.next = previous;
            curr = curr.prev;
        }

        return previous.prev;
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