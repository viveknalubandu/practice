package trees;

/**
 * Created by vnalubandu on 5/24/18.
 */
public class BinaryTree {
    Tree root;

    BinaryTree(int value){
        root = new Tree(value);
    }

    BinaryTree(){
        root=null;
    }

    public static void main(String[] args){

        BinaryTree bt = new BinaryTree();
        // Create root
        bt.root = new Tree(1);
        // create left node element
        bt.root.left = new Tree(2);
        bt.root.right = new Tree(3);
    }
}
