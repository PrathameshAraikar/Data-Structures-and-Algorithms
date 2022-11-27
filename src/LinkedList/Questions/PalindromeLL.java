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

public class PalindromeLL {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(1);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);

        iterativeTraversal(head);
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(Node head) {
        if (head == null)
            return true;

        Node hare = head, tortoise = head, curr = head;
        while (hare.next != null && hare.next.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }

        Node rev = reverse(tortoise.next);
        while (rev != null) {
            if (rev.data != curr.data)
                return false;

            rev = rev.next;
            curr = curr.next;
        }
        return true;
    }

    public static Node reverse(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev = null, curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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
