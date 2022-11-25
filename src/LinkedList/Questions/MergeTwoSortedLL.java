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

public class MergeTwoSortedLL {
    public static void main(String[] args) {
        Node headA = new Node(10);
        headA.next = new Node(20);
        headA.next.next = new Node(30);
        headA.next.next.next = new Node(40);
        headA.next.next.next.next = new Node(50);
        iterativeTraversal(headA);

        Node headB = new Node(12);
        headB.next = new Node(24);
        headB.next.next = new Node(36);
        headB.next.next.next = new Node(60);
        iterativeTraversal(headB);

        Node head = merge(headA, headB);
        iterativeTraversal(head);
    }

    public static Node merge(Node headA, Node headB) {
        if(headA == null)
            return headB;

        if(headB == null)
            return headA;

        Node tail = null, head = null;
        if(headA.data < headB.data) {
            head = tail = headA;
            headA = headA.next;
        } else {
            head = tail = headB;
            headB = headB.next;
        }

        while(headA != null && headB != null) {
            if(headA.data < headB.data) {
                tail.next = headA;
                tail = headA;
                headA = headA.next;
            } else {
                tail.next = headB;
                tail = headB;
                headB = headB.next;
            }
        }

        if(headA == null)
            tail.next = headB;
        else
            tail.next = headA;

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