package strings;

/**
 * Created by vnalubandu on 5/12/18.
 */
public class ReverseWords {

    public static String reverseWords(String words){
        String[] wordArray = words.split(" ");
        StringBuilder sb = new StringBuilder();
                for(int i=wordArray.length-1;i>=0 ; --i){
                    if(!wordArray.equals("")){
                        sb.append(wordArray[i]).append(" ");
                    }
                }
        return sb.length()==0 ? "" : sb.substring(0,sb.length()-1);
    }

    public static void main(String[] args){

        String words1 = "the sky is blue";
        String words2 = "the sky   as move # as move #";
        String result1 = reverseWords(words1);
        String result2 = reverseWords(words2);

        System.out.println(result1);
        System.out.println(result2);

    }

}
