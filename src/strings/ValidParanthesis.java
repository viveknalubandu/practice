package strings;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by vnalubandu on 6/4/18.
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParanthesis {

    public boolean isValidParanthesis(String str){
        HashMap mp = new HashMap<Character,Character>();
        mp.put("(",")");
        mp.put("[","]");
        mp.put("{","}");
        char[] chs = str.toCharArray();
        Stack<Character> stc = new Stack<Character>();
        for(char ch:chs){
            if(mp.keySet().contains(ch)){
                stc.push(ch);
            } else if(mp.values().contains(ch)){
                if(!stc.isEmpty() && mp.get(stc.peek()).equals(ch)){
                    stc.pop();
                } else {
                    return false;
                }
            }
        }
        return stc.isEmpty();
    }

    public static void main(String[] args){
        String str = "()[]{}";
        ValidParanthesis vp = new ValidParanthesis();
        System.out.println("Given String  " + vp.isValidParanthesis(str) +" valid paranthesis");
    }
}
