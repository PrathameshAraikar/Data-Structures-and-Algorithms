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

public class IntersectionOfTwoLL {
    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);

        Node intersectingPoint = new Node(5);
        head1.next.next.next.next = intersectingPoint;
        intersectingPoint.next = new Node(6);
        intersectingPoint.next.next = new Node(7);

        Node head2 = new Node(8);
        head2.next = new Node(9);
        head2.next.next = intersectingPoint;

        iterativeTraversal(head1);
        iterativeTraversal(head2);
        System.out.print(intersectionPoint(head1, head2));
    }

    public static int intersectionPoint(Node head1, Node head2) {
        int count1 = 0, count2 = 0;
        for (Node curr = head1; curr != null; curr = curr.next)
            count1++;

        for (Node curr = head2; curr != null; curr = curr.next)
            count2++;

        if (count1 < count2)
            return intersectionPoint(head2, head1);

        int difference = count1 - count2;

        Node curr1 = head1;
        while (difference-- > 0)
            curr1 = curr1.next;

        Node curr2 = head2;
        while (curr1.next != null && curr2.next != null) {
            if (curr1 == curr2)
                return curr1.data;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return -1;
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