package trees;

/**
 * Created by vnalubandu on 5/24/18.
 */
public class LevelOrderTraversal {

    public void printLevelOrder(Tree root){
        int h = getHeight(root);
        System.out.println("Height of tree is  " + h);
        for(int i=1;i<=h;i++){
            printElementGivenLevel(root,i);
        }
    }

    public int getHeight(Tree root){
        if (root==null){
            return 0;
        }
        else{
           int lheight = getHeight(root.left);
           int rheight = getHeight(root.right);
           int max = Math.max(lheight+1,rheight+1);
           return max;
        }
    }

    public void printElementGivenLevel(Tree root,int level){
        if(root==null){
            return;
        }
        if(level==1){
            System.out.println(root.data);
        } else if(level>1){
            printElementGivenLevel(root.left,level-1);
            printElementGivenLevel(root.right,level-1);
        }

    }

    public static void main(String[] args){

        BinaryTree tree = new BinaryTree();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(5);
        tree.root.left.left = new Tree(3);
        tree.root.left.right = new Tree(4);
        tree.root.left.left.left = new Tree(7);
        tree.root.left.right.right = new Tree(8);
        LevelOrderTraversal lvl = new LevelOrderTraversal();
        lvl.printLevelOrder(tree.root);
    }
}
