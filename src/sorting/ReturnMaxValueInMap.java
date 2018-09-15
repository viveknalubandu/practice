package sorting;

import java.util.*;
import java.util.Iterator;

/**
 * Created by vnalubandu on 7/18/18.
 */
public class ReturnMaxValueInMap {

    public int maxValue =Integer.MIN_VALUE;
    public static Character maxKey;

    public int getMaxKeyValueInMap(HashMap<Character,Object> mp){
        if(mp.size()==0 || mp==null){
            return maxValue;
        } else  {
            Iterator<Map.Entry<Character,Object>> it = mp.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry<Character,Object> pair = it.next();
                if(pair.getValue() instanceof Integer){
                    int mpValue = ((Integer) pair.getValue()).intValue();
                    if(maxValue <mpValue){
                        maxValue =mpValue;
                        maxKey = pair.getKey();
                    }
                } else if(pair.getValue() instanceof Map || pair.getValue() instanceof HashMap){
                    HashMap<Character,Object> map = (HashMap<Character, Object>)pair.getValue();
                    getMaxKeyValueInMap(map);
                }
            }

            return maxValue;
        }

    }

    public static void main(String[] args){

        HashMap<Character,Object> mp = new HashMap<>();
        mp.put('A',-1);
        mp.put('B',7);
        mp.put('D',10);
        HashMap<Character,Object> sub = new HashMap<>();
        sub.put('F', -12);
        sub.put('A', 100);
        HashMap<Character,Object> sub1 = new HashMap<>();
        sub1.put('E', 1000);
        sub.put('E', sub1);
        mp.put('E', sub);
        ReturnMaxValueInMap rmp = new ReturnMaxValueInMap();
        int maxValue = rmp.getMaxKeyValueInMap(mp);
        System.out.println("Key Value Pair For Max Value is " + maxKey.toString() +":" +maxValue );
    }
}
