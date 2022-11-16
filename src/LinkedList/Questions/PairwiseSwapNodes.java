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

public class PairwiseSwapNodes {
    public static void main(String[] args) {
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4);

        iterativeTraversal(head);
        head = pairwiseSwap(head);
        iterativeTraversal(head);
    }

    public static Node pairwiseSwap(Node head) {
        Node curr = head.next.next, prev = head;

        // Explicitly swapping first pair
        head = head.next;
        head.next = prev;

        // Swapping rest pairs
        while (curr != null && curr.next != null) {
            Node next = curr.next.next;
            prev.next = curr.next;
            curr.next.next = curr;
            prev = curr;
            curr = next;
        }

        prev.next = curr;
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