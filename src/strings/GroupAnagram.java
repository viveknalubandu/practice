package strings;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by vnalubandu on 6/10/18.
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
 ["ate","eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 */
public class GroupAnagram {

    public List<List<String>> groupListOfAnagrams(String[] strs){

        List<List<String>> result = new ArrayList<List<String>>();
        HashMap<String,ArrayList<String>> mp = new HashMap<String,ArrayList<String>>();
        for(String str:strs){
            char[] ca = str.toCharArray();
            Arrays.sort(ca);
            String keyChar = String.valueOf(ca);
            if(mp.containsKey(keyChar)){
                mp.get(keyChar).add(str);
            } else {
                ArrayList<String> al = new ArrayList<String>();
                al.add(str);
                mp.put(keyChar, al);
            }
        }

        return new ArrayList<>(mp.values());
    }

    public static void main(String[] str){
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagram gA = new GroupAnagram();
        List<List<String>> lss = gA.groupListOfAnagrams(strs);
        for(List ls: lss){
            System.out.println(" List of Anagrams  " + ls.toString());
        }
    }
}
