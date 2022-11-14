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

public class LoopRemoval {
    public static void main(String[] args) {
        Node head = new Node(15);
        head.next = new Node(10);
        head.next.next = new Node(12);
        head.next.next.next = new Node(20);
        head.next.next.next.next = head.next;

        removeLoop(head);
        iterativeTraversal(head);
    }

    public static void removeLoop(Node head) {
        // Loop Detection
        Node hare = head, tortoise = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if (hare == tortoise)
                break;
        }

        if (hare != tortoise)
            return;

        // Loop Removal
        tortoise = head;
        while (hare.next != tortoise.next) {
            hare = hare.next;
            tortoise = tortoise.next;
        }

        hare.next = null;
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