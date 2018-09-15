package trees;

/**
 * Created by vnalubandu on 5/25/18.
 *
 * (a) Inorder (Left, Root, Right) : 4 2 5 1 3
 */
public class InOrderWithoutStackAndRecursion {

    public static void inOrderUsingNonStackAndRecursion(Tree root){
        Tree current = root;
        if(current==null){
            return;
        }
        while (current!=null){

            if(current.left==null){
                System.out.println("In Order Traversal Element  " + current.data );
            } else{
                Tree pre;
                pre = current.left;

                /* Finding inorder predecessor
                 */
                while (pre.right!=null && pre.right!=current){
                    pre=pre.right;
                }

                /* Make current as right child of its inorder predecessor */
                if (pre.right == null)
                {
                    pre.right = current;
                    current = current.left;
                }

                 /* Revert the changes made in if part to restore the
                    original tree i.e.,fix the right child of predecessor*/
                else
                {
                    pre.right = null;
                    System.out.print(current.data + " ");
                    current = current.right;
                }   /* End of if condition pre->right == NULL */
            }
        }

    }

    public static void main(String args[]) {

        /* creating a binary tree and entering
         the nodes */
        BinaryTree tree = new BinaryTree();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);
        tree.root.left.left.left = new Tree(7);
        tree.root.left.left.right = new Tree(8);
        LevelOrderTraversal lvl = new LevelOrderTraversal();
        lvl.printLevelOrder(tree.root);
        inOrderUsingNonStackAndRecursion(tree.root);
    }

}
