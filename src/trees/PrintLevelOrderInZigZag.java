package trees;

/**
 * Created by vnalubandu on 5/29/18.
                4
            5        2
        3     1   3    6

 */

import java.util.LinkedList;
import java.util.Queue;

/** Output: 4 5 2 6 3 1 3**/

public class PrintLevelOrderInZigZag {

    public void getElementAtGivenLevel(Tree root, int level){
        Queue<Tree> queue = new LinkedList();
        if(root==null){
            return;
        }
        if(level==1){
            queue.add(root);
        } else if(level>1){
            if(level%2==0){
                getElementAtGivenLevel(root.right,level-1);
                getElementAtGivenLevel(root.left,level-1);
            } else {
                getElementAtGivenLevel(root.left,level-1);
                getElementAtGivenLevel(root.right,level-1);
            }
        }
    }

    public void printLevelInZigZag(Tree root){

        LevelOrderTraversal lvl = new LevelOrderTraversal();
        int height = lvl.getHeight(root);
        Queue<Tree> qu1 = new LinkedList();
//        Queue<Tree> qu2 = new LinkedList();
        qu1.add(root);
        Tree tempNode = null;
        int i=1;
        while (!qu1.isEmpty()){

            tempNode = qu1.poll();
            System.out.println("Reading Element of Tree is" + tempNode.data);
            if(i%2==0){

                /*Enqueue right child */
                if (tempNode.right != null) {
                    qu1.add(tempNode.right);
                }
                /*Enqueue left child */
                if (tempNode.left != null) {
                    qu1.add(tempNode.left);
                }

            } else {

                /*Enqueue left child */
                if (tempNode.left != null) {
                    qu1.add(tempNode.left);
                }

                /*Enqueue right child */
                if (tempNode.right != null) {
                    qu1.add(tempNode.right);
                }
                i++;
            }
        }

    }

    public void printElementsInZigZag(Tree root,int height){
        for (int i=1;i<=height;i++){
            getElementAtGivenLevel(root,i);
        }
    }

    public static void main(String[] args){

        /**
         *                      1
         *                  2       3
         *              4      5  6   7
         *          9            8
         *
         */
        BinaryTree tree = new BinaryTree();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);
        tree.root.right.left = new Tree(6);
        tree.root.right.right = new Tree(7);
        tree.root.right.left.left = new Tree(8);
        tree.root.left.left.left = new Tree(9);
        LevelOrderTraversal lvl = new LevelOrderTraversal();
        lvl.printLevelOrder(tree.root);
        PrintLevelOrderInZigZag prlevelZigZag = new PrintLevelOrderInZigZag();
        int height = lvl.getHeight(tree.root);
        prlevelZigZag.printElementsInZigZag(tree.root,height);
        prlevelZigZag.printLevelInZigZag(tree.root);
    }


}
