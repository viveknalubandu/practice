package linkedList;

import java.util.List;

/**
 * Created by vnalubandu on 5/12/18.
 */
public class LinkedListOperations {

    /**
     * Insert node in linkedList
     * @param headNode
     * @param nodeToInsert
     * @param position
     * @return
     */
   public static ListNode insertNode(ListNode headNode,ListNode nodeToInsert,int position){
       if(headNode==null){
           return nodeToInsert;
       }

       if(position > 5 || position < 1){
           System.out.println("");
           return nodeToInsert;
       }

       if(position ==1){
           nodeToInsert.setNext(headNode);
           return nodeToInsert;
       } else {
           // inserting node in the middle or end
           ListNode previousNode = headNode;
           int count = 1;
           while(count < position-1){
               previousNode = previousNode.getNext();
               count++;
           }
           ListNode currentNode= previousNode.getNext();
           nodeToInsert.setNext(currentNode);
           previousNode.setNext(nodeToInsert);
       }
       return headNode;
   }

    public static ListNode deleteNode(ListNode headNode,int position){

        if(position > Integer.MAX_VALUE || position < 1){
            System.out.println("");
            return headNode;
        }
        ListNode currentNodeToReturn=null;
        if(position ==1){
            ListNode currentNode = headNode.getNext();
            // if first node to be deleted
            return currentNode;
        } else {
            ListNode previousNode = headNode;
            int count =1;
            while(count < position){
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            previousNode.setNext(currentNodeToReturn.getNext());
            return currentNode;
        }
    }

   public static int linkedListLength(ListNode headNode){
       int count=0;
       ListNode currentNode = headNode;
       if(currentNode==null){
           return 0;
       }
       if(currentNode!=null && currentNode.getNext()==null){
           return 1;
       } else {
           while(currentNode!=null){
               count++;
               currentNode = currentNode.getNext();
           }
       }
       return count;
   }

   public static void getLinkedListElements(ListNode headNode){
       if(headNode==null){
           System.out.print("No elements in the Linked list");
       }
       while (headNode!=null){
           System.out.print("Element " + headNode.getData()  + "   ");
           headNode = headNode.getNext();
       }
   }

   public static void main(String[] args){
       ListNode headNode =  new ListNode(1);
       headNode.setNext(new ListNode(2));
       headNode.getNext().setNext(new ListNode(3));
       headNode.getNext().getNext().setNext(new ListNode(4));
       headNode.getNext().getNext().getNext().setNext(new ListNode(5));

       getLinkedListElements(headNode);
//       int size = linkedListLength(headNode);
//       ListNode newHeadNode=null;
//       for (int i =1;i<4;i++){
//           newHeadNode = deleteNode(headNode,i);
//       }
//       getLinkedListElements(headNode);
       ListNode newNodeToInsert =  new ListNode(7);
       ListNode newNodeAfterInsert = insertNode(headNode,newNodeToInsert,3);
       getLinkedListElements(newNodeAfterInsert);
       int size = linkedListLength(newNodeAfterInsert);
       System.out.print("Size of Elements " + size);
       int i=1;
       ListNode newNodeAfterDelete = newNodeAfterInsert;
       while (i<=size){
           newNodeAfterDelete = deleteNode(newNodeAfterDelete,1);
           i++;
       }
       System.out.print("Elements in Linked List " + newNodeAfterDelete);
   }



}
