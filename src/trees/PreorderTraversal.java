package trees;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by vnalubandu on 5/24/18.
 *
 * Preorder (Root, Left, Right) : 1 2 4 5 3
 */
public class PreorderTraversal {

    public static void printPreOrderTraversal(Tree root){

        if(root==null){
            return ;
        }

        System.out.println("Pre Order Traversal Order "+root.data);

        printPreOrderTraversal(root.left);

        printPreOrderTraversal(root.right);
    }

    public static void preOrderTraversal(Tree root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root==null){
            return;
        }

        Stack<Tree> stck = new Stack<>();
        stck.push(root);
        while (!stck.isEmpty()){
            Tree rootNode = stck.pop();
            result.add(rootNode.data);

            if(rootNode.right!=null){
                stck.push(rootNode.right);
            }

            if(rootNode.left!=null){
                stck.push(rootNode.left);
            }
        }

        System.out.println("Pre Order Traversal Order "+result.toString());
    }

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);
        preOrderTraversal(tree.root);
        LevelOrderTraversal lvl = new LevelOrderTraversal();
        lvl.printLevelOrder(tree.root);
        printPreOrderTraversal(tree.root);
    }
}
