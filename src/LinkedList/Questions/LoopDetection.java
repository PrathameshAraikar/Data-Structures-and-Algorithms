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

public class LoopDetection {
    public static void main(String[] args) {
        Node head = new Node(15);
        head.next = new Node(10);
        head.next.next = new Node(12);
        head.next.next.next = new Node(20);
        head.next.next.next.next = head.next;

        if (loopDetected(head))
            System.out.print("Loop found");
        else
            System.out.print("No Loop");
    }

    public static boolean loopDetected(Node head) {
        Node hare = head, tortoise = head;
        while (hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;

            if (hare == tortoise)
                return true;
        }

        return false;
    }
}