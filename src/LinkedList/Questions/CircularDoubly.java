package LinkedList.Questions;

class CircularDoublyNode {
    int data;
    CircularDoublyNode prev, next;

    CircularDoublyNode(int d) {
        data = d;
        prev = null;
        next = null;
    }
}

public class CircularDoubly {
    public static void main(String[] args) {
        CircularDoublyNode head = new CircularDoublyNode(10);
        CircularDoublyNode temp1 = new CircularDoublyNode(20);
        CircularDoublyNode temp2 = new CircularDoublyNode(30);
        CircularDoublyNode temp3 = new CircularDoublyNode(40);
        CircularDoublyNode temp4 = new CircularDoublyNode(50);

        head.next = temp1;
        temp1.prev = head;
        temp1.next = temp2;
        temp2.prev = temp1;
        temp2.next = temp3;
        temp3.prev = temp2;
        temp3.next = temp4;
        temp4.prev = temp3;
        temp4.next = head;
        head.prev = temp4;

        traversal(head);
        head = insertAtHead(head, 60);
        traversal(head);
        head = insertAtTail(head, 70);
        traversal(head);

        CircularDoublyNode head1 = null, head2 = null;
        head1 = insertAtHead(head1, 10);
        head1 = insertAtHead(head1, 20);
        head1 = insertAtHead(head1, 30);
        traversal(head1);

        head2 = insertAtTail(head2, 40);
        head2 = insertAtTail(head2, 50);
        head2 = insertAtTail(head2, 60);
        traversal(head2);


    }

    public static CircularDoublyNode insertAtHead(CircularDoublyNode head, int element) {
        CircularDoublyNode temp = new CircularDoublyNode(element);
        if (head == null) {
            temp.next = temp;
            temp.prev = temp;
            return temp;
        }

        temp.next = head;
        head.prev.next = temp;
        temp.prev = head.prev;
        head.prev = temp;

        return temp;
    }

    public static CircularDoublyNode insertAtTail(CircularDoublyNode head, int element) {
        CircularDoublyNode temp = new CircularDoublyNode(element);
        if (head == null) {
            temp.next = temp;
            temp.prev = temp;
            return temp;
        }

        temp.next = head;
        head.prev.next = temp;
        temp.prev = head.prev;
        head.prev = temp;

        return head;
    }

    public static void traversal(CircularDoublyNode head) {
        CircularDoublyNode curr = head;
        System.out.print("<-> ");
        do {
            System.out.print(curr.data + " <-> ");
            curr = curr.next;
        } while (curr != head);
        System.out.println();
    }
}