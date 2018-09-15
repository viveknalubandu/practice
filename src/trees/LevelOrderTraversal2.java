package trees;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by vnalubandu on 6/13/18.
 */
public class LevelOrderTraversal2 {

    public ArrayList<ArrayList<Integer>> levelOrderTraversal(Tree root){

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> nodeValues = new ArrayList<Integer>();

        if(root==null){
            return result;
        }

        LinkedList<Tree> current = new LinkedList<Tree>();
        LinkedList<Tree> next = new LinkedList<Tree>();
        current.add(root);
        while (!current.isEmpty()){
            Tree node = current.remove();

            if(node.left!=null){
                next.add(node.left);
            }
            if(node.right!=null){
                next.add(node.right);
            }

            nodeValues.add(node.data);
            if(current.isEmpty()){
                current = next;
                next = new LinkedList<Tree>();
                result.add(nodeValues);
                nodeValues = new ArrayList<>();
            }
        }

        return result;
    }

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(5);
        tree.root.left.left = new Tree(3);
        tree.root.left.right = new Tree(4);
        tree.root.left.right.right = new Tree(8);
        tree.root.left.right.right.right = new Tree(7);
        LevelOrderTraversal2 lvl = new LevelOrderTraversal2();
        ArrayList<ArrayList<Integer>> result = lvl.levelOrderTraversal(tree.root);
        int i=0;
        while(i<result.size()){
            int size = result.get(i).size();
            ArrayList<Integer> innerList = result.get(i);
            for(int index=0;index<size;index++){
                System.out.println("Element in the array list    "+ innerList.get(index));
            }
            i++;
        }
    }
}
