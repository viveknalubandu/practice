package trees;

/**
 * Created by vnalubandu on 5/25/18.
 */

import java.util.Stack;

/**
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 */
public class InorderUsingStack {
    /**
     * 1) Create an empty stack S.
     2) Initialize current node as root
     3) Push the current node to S and set current = current->left until current is NULL
     4) If current is NULL and stack is not empty then
     a) Pop the top item from stack.
     b) Print the popped item, set current = popped_item->right
     c) Go to step 3.
     5) If current is NULL and stack is empty then we are done.
     */

    public static void inOrderTraversalUsingStack(Tree root){
        Tree current = root;
        if(current==null){
            return;
        }
        Stack<Tree> stck = new Stack<Tree>();
        while (current!=null){
            stck.push(current);
            current = current.left;
        }

        while (stck.size()>0){
            current = stck.pop();
            System.out.println("In Order Traversal Element "+ current.data);
            if(current.right!=null){
                current = current.right;
                while (current!=null){
                    stck.push(current);
                    current = current.left;
                }
            }
        }

    }

    /*
                            1
                     2          3
                            4       5
                                 8      7


     */

    public static void main(String args[]) {

        /* creating a binary tree and entering
         the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(2);
        tree.root.left.right = new Tree(9);
        tree.root.right.left = new Tree(4);
        tree.root.right.right = new Tree(5);
        tree.root.right.right.right = new Tree(7);
        tree.root.right.right.left = new Tree(8);
        LevelOrderTraversal lvl = new LevelOrderTraversal();
        lvl.printLevelOrder(tree.root);
        inOrderTraversalUsingStack(tree.root);
        lvl.printLevelOrder(tree.root);

    }
}
