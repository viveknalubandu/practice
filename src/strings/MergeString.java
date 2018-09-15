package strings;

/**
 * Created by vnalubandu on 7/27/18.
 */
public class MergeString {


    public String mergeTwoString(String s1,String s2){
        if(s1.length()==0){
            return s2;
        }else if(s2.length()==0){
            return s1;
        } else if(s1==null && s2==null){
            return null;
        }

        StringBuilder sb = new StringBuilder();
        char[] chs1 = s1.toCharArray();
        char[] chs2 = s2.toCharArray();
        int j=0;
        int k=0;

        if(s1.length()==s2.length()){
            for(int i=0;i<s1.length()+s2.length();i++){
             if(i%2==0 && j<s1.length()){
                 sb.append(chs1[j]);
                 j++;
             }else if( k<s2.length()){
                 sb.append(chs2[k]);
                 k++;
             }
         }
        } else if(s1.length()<s2.length()){
            for(int i=0;i<s2.length();i++){
                if(i%2==0 && j<s1.length()){
                    sb.append(chs1[j]);
                    j++;
                }else if(k<s1.length()-1){
                    sb.append(chs2[k]);
                    k++;
                }
            }
            sb.append(s2.substring(k));
        } else {
            for(int i=0;i<s1.length();i++){
                if(i%2==0 && j<s2.length()){
                    sb.append(chs2[j]);
                    j++;
                }else if( k<s2.length()-1){
                    sb.append(chs1[k]);
                    k++;
                }
            }
            sb.append(s1.substring(k));
        }

        return sb.toString();
    }

    public static void main(String[] args){
        String s1 ="M";
        String s2 = "THE";
        MergeString ms = new MergeString();
        String result = ms.mergeTwoString(s1,s2);
        System.out.println("Final String after merging two strings   " + result);
    }
}
