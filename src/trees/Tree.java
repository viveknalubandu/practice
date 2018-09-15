package trees;

import java.util.Objects;

/**
 * Created by vnalubandu on 5/24/18.
 */
public class Tree {
    int data;
    Tree left,right;

    public Tree(){

    }
    public Tree(int value){
        this.data=value;
        left=null;
        right=null;
    }
}
