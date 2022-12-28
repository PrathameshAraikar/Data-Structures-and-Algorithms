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

public class Reverse {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        iterativeTraversal(head);
        Node itrHead = head;
        //Node recur1 = head;
        //Node recur2 = head;

        itrHead = iterativeReverse(itrHead);
        iterativeTraversal(itrHead);

        //recur1 = recursiveReverse1(recur1);
        //iterativeTraversal(recur1);

        //recur2 = recursiveReverse2(recur2, null);
        //iterativeTraversal(recur2);
    }

    public static Node iterativeReverse(Node head) {
        Node curr = head, prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static Node recursiveReverse1(Node head) {
        if (head == null || head.next == null)
            return head;

        Node restHead = recursiveReverse1(head.next);
        Node restTail = head.next;
        restTail.next = head;
        head.next = null;

        return restHead;
    }

    public static Node recursiveReverse2(Node curr, Node prev) {
        if (curr == null)
            return prev;

        Node next = curr.next;
        curr.next = prev;
        return recursiveReverse2(next, curr);
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