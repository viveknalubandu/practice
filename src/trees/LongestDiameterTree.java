package trees;

/**
 * Created by vnalubandu on 5/24/18.
 */
public class LongestDiameterTree {

    /*
    Find the max height from root
    Find the max depth .
    Get the max of height and diameter
     */

    public static int longestDiameter(Tree root){

        if(root==null){
            return 0;
        }

        LevelOrderTraversal lvl = new LevelOrderTraversal();

        /* Get the height from left and right node of root */
        int lheight = lvl.getHeight(root.left);
        int rheight = lvl.getHeight(root.right);

        /* Get the diameter from left and right node of root */
        int ldiameter = longestDiameter(root.left);
        int rdiameter = longestDiameter(root.right);

        return Math.max(1+lheight+rheight,Math.max(ldiameter,rdiameter));

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
        tree.root.left.left.left.left = new Tree(9);
        tree.root.left.left.right.right = new Tree(10);
        tree.root.left.left.left.left.left = new Tree(11);
        tree.root.left.left.right.right.right = new Tree(12);
        LevelOrderTraversal lvl = new LevelOrderTraversal();
        lvl.printLevelOrder(tree.root);
        int longestDiameter = longestDiameter(tree.root);

        System.out.println("Length "+longestDiameter);
    }


}
