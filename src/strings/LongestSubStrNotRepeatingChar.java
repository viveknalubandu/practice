package strings;

import java.util.HashSet;

/**
 * Created by vnalubandu on 7/13/18.
 */
public class LongestSubStrNotRepeatingChar {

    private static int lengthOfLongestSubStr(String s){
        int result = 0;
        int k=0;
        HashSet<Character> set = new HashSet<Character>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                result = Math.max(result,set.size());
            }else {
              while (k<i){
                  if(s.charAt(k)==c){
                      k++;
                      break;
                  }else{
                      set.remove(s.charAt(k));
                      k++;
                  }
              }
            }
        }

        return result+1;
    }

    public static void main(String[] args){
        String s = "aabbcc";
        int max = lengthOfLongestSubStr(s);
        System.out.println("Lenght of longest sub str" + max);
    }
}
