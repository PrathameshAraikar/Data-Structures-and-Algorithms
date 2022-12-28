package LinkedList.BasicsOfSLL;

//class Node {
//    int data;
//    Node next;
//
//    Node(int d) {
//        data = d;
//        next = null;
//    }
//}

public class Search {
    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        System.out.println("Iterative Seaech: " + iterativeSearch(head, 60));
        System.out.println("Recursive Seaech: " + recursiveSearch(head, 60));
    }

    public static int iterativeSearch(Node head, int key) {
        Node curr = head;
        if (head == null)
            return -1;

        int pos = 1;
        while (curr != null) {
            if (curr.data == key)
                return pos;

            curr = curr.next;
            pos++;
        }

        return -1;
    }

    public static int recursiveSearch(Node head, int key) {
        if (head == null)
            return -1;
        if (head.data == key)
            return 1;

        int res = recursiveSearch(head.next, key);
        if (res == -1)
            return -1;

        return res + 1;
    }
}