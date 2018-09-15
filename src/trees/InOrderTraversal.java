package trees;

/**
 * Created by vnalubandu on 5/24/18.
 */

import java.util.ArrayList;
import java.util.Stack;

/**
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 */
public class InOrderTraversal {

    public static void printInOrderTraversal(Tree root){
        if(root==null){
            return;
        }
        printInOrderTraversal(root.left);
        System.out.println("In Order Traversal Order is  "+root.data);
        printInOrderTraversal(root.right);
    }

    public ArrayList<Integer> inorderTraversal(Tree root) {
        ArrayList<Integer> lst = new ArrayList<Integer>();

        if (root == null)
            return lst;

        Stack<Tree> stack = new Stack<Tree>();
        //define a pointer to track nodes
        Tree p = root;

        while (!stack.empty() || p != null) {

            // if it is not null, push to stack
            //and go down the tree to left
            if (p != null) {
                stack.push(p);   // we are doing this because when we pop elements out left and root will be printed
                p = p.left;

                // if no left child
                // pop stack, process the node
                // then let p point to the right
            } else {
                Tree t = stack.pop();
                lst.add(t.data);
                p = t.right;
            }
        }

        return lst;
    }
}
