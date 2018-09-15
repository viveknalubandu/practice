package trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vnalubandu on 8/1/18.
 */
public class BinaryTreeRootToLeafPath {

//    public static List<String> binaryTreePaths(Tree root){
//        List<String> result = new ArrayList<>();
//        if(root!=null){
//            searchRootToLeaf(root,root.data+"",result);
//        }
//        return result;
//    }
//
//    private static void searchRootToLeaf(Tree root,String path,List<String> result){
//        if(root.left==null || root.right==null){
//            result.add(path+"->"+root.data);
//        }
//        else{
//            if(root.left!=null){
//                searchRootToLeaf(root.left,path+"->"+root.left.data,result);
//            }
//            if(root.right!=null){
//                searchRootToLeaf(root.left,path+"->"+root.right.data,result);
//            }
//        }
//    }

    /**
     *
     * @param root
     * @return
     */

    public static List<String> binaryTreePaths2(Tree root) {
        ArrayList<String> finalResult = new ArrayList<String>();

        if(root==null)
            return finalResult;

        ArrayList<String> curr = new ArrayList<String>();
        ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();

        dfs(root, results, curr);

        for(ArrayList<String> al : results){
            StringBuilder sb = new StringBuilder();
            sb.append(al.get(0));
            for(int i=1; i<al.size();i++){
                sb.append("->"+al.get(i));
            }

            finalResult.add(sb.toString());
        }

        return finalResult;
    }

    public static void dfs(Tree root, ArrayList<ArrayList<String>> list, ArrayList<String> curr){
        curr.add(String.valueOf(root.data));

        if(root.left==null && root.right==null){
            list.add(curr);
            return;
        }

        if(root.left!=null){
            ArrayList<String> temp = new ArrayList<String>(curr);
            dfs(root.left, list, temp);
        }

        if(root.right!=null){
            ArrayList<String> temp = new ArrayList<String>(curr);
            dfs(root.right, list, temp);
        }
    }

    public static void main(String[] args){
        Tree root;

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
        root = new Tree(1);
        root.left = new Tree(2);
        root.right = new Tree(3);
        root.left.left = new Tree(4);
        root.left.right = new Tree(5);
        root.right.right = new Tree(8);
        root.right.right.left = new Tree(6);
        root.right.right.right = new Tree(7);
        System.out.print("Binary Tree root to leaf paths " + binaryTreePaths2(root));
    }
}
