package trees;

/**
 * Created by vnalubandu on 5/24/18.
 *
 * Postorder (Left, Right, Root) : 4 5 2 3 1
 */
public class PostOrderTraversal {

    public static void printPostOrderTraversalElements(Tree root){

       if(root==null){
           return ;
       }

       printPostOrderTraversalElements(root.left);

       printPostOrderTraversalElements(root.right);

       System.out.println("Post Order Traversal Order "+root.data);
    }

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);
        LevelOrderTraversal lvl = new LevelOrderTraversal();
        lvl.printLevelOrder(tree.root);
        printPostOrderTraversalElements(tree.root);
    }
}
