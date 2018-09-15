package linkedList;

import java.util.LinkedList;

/**
 * Created by vnalubandu on 5/13/18.
 */
public class ReorderLinkedList {
    /**
     * Given a singly linked list L: L0→L1→ ... →Ln-1→Ln,
     reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→...

     For example, given {1,2,3,4}, reorder it to {1,4,2,3}. You must do this in-place without altering the nodes' values.
     */

    /**
     * Steps:
     * Break the linked list into two list
     * Reverse the second list
     * Merge both  Linked lists
     */

    public static void reorderList(ListNode headNode){
        // Break the linkedList into two

        if(headNode!=null && headNode.getNext()!=null){
            ListNode slow = headNode;
            ListNode fast = headNode;
            // use fast and slow pointer to break the link into two parts
            while(fast!=null && fast.getNext()!=null && fast.getNext().getNext()!=null){
                System.out.println("pre "+ slow.getData() + "  " + fast.getData());
                slow = slow.getNext();
                fast = fast.getNext().getNext();
                System.out.println("pre "+ slow.getData() + "  " + fast.getData());
            }
            ListNode secondHeadNode = slow.getNext();
            slow.setNext(null);
            // now should have list with head and fast
            secondHeadNode = reverseLinkedList(secondHeadNode);

            ListNode p1 = headNode;
            ListNode p2 = secondHeadNode;

            //merge two lists here
            while(p2!=null){
                ListNode temp1 = p1.getNext();
                ListNode temp2 = p2.getNext();

                p1.setNext(p2);
                p2.setNext(temp1);

                p1 = temp1;
                p2 = temp2;
                LinkedList<Integer> q1 = new LinkedList<Integer>();
                q1.offer(2);
            }

        }
    }

    public static ListNode reverseLinkedList(ListNode headNode){
        if(headNode==null || headNode.getNext()==null){
            return headNode;
        }
        ListNode previousNode = headNode;
        ListNode currentNode = headNode.getNext();

        while(currentNode!=null){
            ListNode temp = currentNode.getNext();
            currentNode.setNext(previousNode);
            previousNode = currentNode;
            currentNode = temp;
        }

        headNode.setNext(null);
        return previousNode;
    }
}
