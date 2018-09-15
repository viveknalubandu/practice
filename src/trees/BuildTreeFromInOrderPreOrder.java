package trees;

/**
 * Created by vnalubandu on 5/25/18.
 *
 * Inorder sequence: D B E A F C
 * Pre-order sequence: A B D E C F
 */
public class BuildTreeFromInOrderPreOrder {

    static class Node
    {
        char data;
        Node left, right;

        Node(char item)
        {
            data = item;
            left = right = null;
        }
    }

    static int preIndex=0;

    public static Node buildTree(char[] preorderList, char[] inorderList,int start,int end){

        if(start>end){
            return null;
        }

        Node root = new Node(preorderList[preIndex++]);
        int rootIndex = searchNode(inorderList,0,end,root.data);

        root.left = buildTree(preorderList,inorderList,start,rootIndex-1);
        root.right = buildTree(preorderList,inorderList,rootIndex+1,end);
        return root;
    }

    private static int searchNode(char treeList[],int start,int end,char value){
        for(int i=start;i<=end;i++){
            if(treeList[i]==value){
                return i;
            }
        }
        return -1;
    }

    public static void printInOrderTraversal(Node root){
        if(root==null){
            return;
        }
        printInOrderTraversal(root.left);
        System.out.print(root.data + " ");
        printInOrderTraversal(root.right);
    }

    // driver program to test above functions
    public static void main(String args[])
    {
        char in[] = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        char pre[] = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        int len = in.length;
        BuildTreeFromInOrderPreOrder bT = new BuildTreeFromInOrderPreOrder();
        Node root = bT.buildTree(pre, in, 0, len - 1);
        // building the tree by printing inorder traversal
        printInOrderTraversal(root);
    }
}
