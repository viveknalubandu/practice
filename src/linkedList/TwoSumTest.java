package linkedList;

/**
 * Created by vnalubandu on 8/12/18.
 */
public class TwoSumTest {

    public Integer twoSum(Integer x,Integer y){
        return x+y;
    }

    public static void main(String[] args){

        Integer x = -58570;
        Integer y = -61171;
        TwoSumTest tw = new TwoSumTest();
        Integer result = tw.twoSum(x,y);
        System.out.print("Result " + result);
    }
}
