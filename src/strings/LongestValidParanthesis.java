package strings;

import java.util.Stack;

/**
 * Created by vnalubandu on 6/5/18.
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()()", the longest valid parentheses substring is "()", which has length = 2.
 */
public class LongestValidParanthesis {

    public  int longestValidParanthesis(String str){

        int result = 0;
        Stack<int []> stck = new Stack<int []>();
        for(int i=0;i<str.length();i++){
            char ch= str.charAt(i);
            if(ch=='('){
                int[] var = new int[]{i,0};
                stck.push(var);
            } else {
                if(stck.empty()||stck.peek()[1]==1){
                    int[] a = {i,1};
                    stck.push(a);
                }else{
                    stck.pop();
                    int currentLen=0;
                    if(stck.empty()){
                        currentLen = i+1;
                    }else{
                        currentLen = i-stck.peek()[0];
                    }
                    result = Math.max(result, currentLen);
                }
            }
        }
        return result;
    }


    public static void main(String[] args){
        String[] str = new String[]{"((()()()","((()((()",")))(()()",")((())"};
        LongestValidParanthesis vp = new LongestValidParanthesis();
        for(String st: str){
            System.out.println("Using string " + st);
            System.out.println("Given String "+vp.longestValidParanthesis(st)  +"  valid paranthesis");
        }
    }
}
