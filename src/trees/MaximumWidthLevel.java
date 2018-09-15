package trees;

/**
 * Created by vnalubandu on 5/26/18.
 */
public class MaximumWidthLevel {

    public static int getMaxWidth(Tree root){
        int maxWidth=0;
        LevelOrderTraversal lvl = new LevelOrderTraversal();
        int height = lvl.getHeight(root);
        for(int i=1;i<=height;i++){
            int width = getWidth(root,i);
            System.out.println("Width at current level "+ i +"is "+ width);
            if(maxWidth<width){
                maxWidth = width;
            }
        }
        return maxWidth;
    }

    public static int getWidth(Tree root,int level){

        if(root==null){
            return 0;
        }

        if(level==1){
            return 1;
        }
        else if(level>1){
            return getWidth(root.left,level-1)+getWidth(root.right,level-1);
        }
        return 0;
    }

    /* Driver program to test above functions */
    public static void main(String args[]) {
        BinaryTree tree = new BinaryTree();

        /*
        Constructed binary tree is:
              1
            /  \
           2    3
         /  \    \
        4   5     8
                 /  \
                6   7

        For the above tree,
        width of level 1 is 1,
        width of level 2 is 2,
        width of level 3 is 3
        width of level 4 is 2.

         */
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);
        tree.root.right.right = new Tree(8);
        tree.root.right.right.left = new Tree(6);
        tree.root.right.right.right = new Tree(7);

        System.out.println("Maximum width is " + getMaxWidth(tree.root));
    }


}