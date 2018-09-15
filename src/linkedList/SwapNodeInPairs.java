package linkedList;

/**
 * Created by vnalubandu on 6/13/18.
 */
public class SwapNodeInPairs {


    public static Node swapNodeInPairs(Node head){
        if(head==null || head.next==null)
            return head;

        //a fake head
        Node h = new Node(0);
        h.next = head;

        Node p1 = head;
        Node p2 = head.next;

        Node pre = h;
        while(p1!=null && p2!=null) {
            pre.next = p2;

            Node t = p2.next;
            p2.next = p1;
            pre = p1;
            p1.next = t;

            p1 = p1.next;

            if (t != null)
                p2 = t.next;
        }
        return h.next;
    }

    public static void main(String[] args){
        Node headNode =  new Node(1);
//        headNode.next = new Node(2);
        headNode.next= new Node(2);
        headNode.next.next = new Node(3);
        headNode.next.next.next = new Node(4);
        Node finNode = swapNodeInPairs(headNode);
        System.out.print(finNode.toString());
    }
}
