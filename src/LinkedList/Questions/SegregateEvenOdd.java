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

public class SegregateEvenOdd {
    public static void main(String[] args) {
        Node head = new Node(17);
        head.next = new Node(15);
        head.next.next = new Node(8);
        head.next.next.next = new Node(12);
        head.next.next.next.next = new Node(10);
        head.next.next.next.next.next = new Node(5);
        head.next.next.next.next.next.next = new Node(4);
        iterativeTraversal(head);
//        head = segregateEvenOddByValue(head);
        head = segregateEvenOddByIndex(head);
        iterativeTraversal(head);
    }

    public static Node segregateEvenOddByValue(Node head) {
        Node oddStart = null, oddEnd = null, evenStart = null, evenEnd = null, curr = head;
        while (curr != null) {
            if (curr.data % 2 != 0) {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = curr;
                } else {
                    oddEnd.next = curr;
                    oddEnd = oddEnd.next;
                }
            } else {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = curr;
                } else {
                    evenEnd.next = curr;
                    evenEnd = evenEnd.next;
                }
            }

            curr = curr.next;
        }

        if (evenStart == null || oddStart == null)
            return head;

        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }

    public static Node segregateEvenOddByIndex(Node head) {

        Node oddEnd = head, evenStart = head.next, evenEnd = head.next;
        while (evenEnd != null && evenEnd.next != null) {
            oddEnd.next = oddEnd.next.next;
            evenEnd.next = evenEnd.next.next;
            oddEnd = oddEnd.next;
            evenEnd = evenEnd.next;
        }

        oddEnd.next = evenStart;
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