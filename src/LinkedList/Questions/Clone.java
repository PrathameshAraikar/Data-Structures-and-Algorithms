package LinkedList.Questions;

import java.util.*;

class CloneNode {
    int data;
    CloneNode next, random;

    CloneNode(int d) {
        data = d;
        next = null;
        random = null;
    }
}

public class Clone {
    public static void main(String[] args) {
        CloneNode head = new CloneNode(10);
        head.next = new CloneNode(5);
        head.next.next = new CloneNode(20);
        head.next.next.next = new CloneNode(15);
        head.next.next.next.next = new CloneNode(20);

        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next.next.next;

        System.out.println("Original list : ");
        cloneListTraversal(head);

        System.out.print("\nCloned list : \n");
        //CloneNode clonedListUsingHashing = cloneLinkedListHashingMethod(head);
        CloneNode clonedListEfficient = cloneLinkedListEfficient(head);
        //cloneListTraversal(clonedListUsingHashing);
        cloneListTraversal(clonedListEfficient);
    }

    public static CloneNode cloneLinkedListHashingMethod(CloneNode head) {
        Map<CloneNode, CloneNode> hMap = new HashMap<>();

        // Traverse and create a clone node in HashMap
        for (CloneNode curr = head; curr != null; curr = curr.next)
            hMap.put(curr, new CloneNode(curr.data));

        // Copying the random and the next pointers
        for (CloneNode curr = head; curr != null; curr = curr.next) {
            CloneNode clone = hMap.get(curr);
            clone.next = hMap.get(curr.next);
            clone.random = hMap.get(curr.random);
            clone = clone.next;
        }

        CloneNode cloneHead = hMap.get(head);
        return cloneHead;
    }

    public static CloneNode cloneLinkedListEfficient(CloneNode head) {
        // Make clones
        for (CloneNode curr = head; curr != null; ) {
            CloneNode next = curr.next;
            curr.next = new CloneNode(curr.data);
            curr.next.next = next;  // Changing the clone node's next to curr.next
            curr = next;    // Move to curr to next node
        }

        // Clone the random pointers
        for (CloneNode curr = head; curr != null; curr = curr.next.next) {
            curr.next.random = (curr.random == null) ? null : curr.random.next;
        }

        // Seperate Clone List from Original List
        CloneNode cloneHead = head.next, cloneCurr = head.next;
        for (CloneNode curr = head; curr != null; curr = curr.next) {
            curr.next = curr.next.next;
            cloneCurr.next = (cloneCurr.next == null) ? null : cloneCurr.next.next;
            cloneCurr = cloneCurr.next;
        }

        return cloneHead;
    }

    public static void cloneListTraversal(CloneNode start) {
        CloneNode ptr = start;
        while (ptr != null) {
            System.out.println("Data = " + ptr.data + ", Random  = " + ptr.random.data);
            ptr = ptr.next;
        }
    }
}