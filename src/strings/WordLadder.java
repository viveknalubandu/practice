package strings;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * Created by vnalubandu on 7/22/18.
 */
public class WordLadder {

    public class WordNode{

        String word;
        int numSteps;

        public WordNode(String word,int numSteps){
            this.word = word;
            this.numSteps=numSteps;
        }
    }

    /**
     * Given two words (start and end), and a dictionary,
     * find the length of shortest transformation sequence
     * from start to end, such that only one letter can be changed
     * at a time and each intermediate word must exist in the dictionary.
     */

    public int shortestWordLadder(String startWord,String endWord,Set<String> dics){
        LinkedList<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(startWord,1));
        dics.add(endWord);


        while (!queue.isEmpty()){
            WordNode top = queue.remove();
            String word = top.word;

            if(word.equals(endWord)){
                return top.numSteps;
            }

            char[] arr = word.toCharArray();
            for(int i=0; i<arr.length; i++){
                for(char c='a'; c<='z'; c++){
                    char temp = arr[i];
                    if(arr[i]!=c){
                        arr[i]=c;
                    }

                    String newWord = new String(arr);
                    if(dics.contains(newWord)){
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        dics.remove(newWord);
                    }

                    arr[i]=temp;
                }
            }
        }

        return 1;
    }


    public static void main(String[] args){
        String startWord = "hot";
        String endWord = "rog";
        Set<String> dict = new HashSet<>();
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        WordLadder wl = new WordLadder();
        int shLength = wl.shortestWordLadder(startWord,endWord,dict);
        System.out.println("Shortest Transformation  " + shLength);
    }
}
