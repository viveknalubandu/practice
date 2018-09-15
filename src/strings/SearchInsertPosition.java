package strings;

/**
 * Created by vnalubandu on 6/6/18.
 * Given a sorted array and a target value,
 * return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 */
public class SearchInsertPosition {

    public int findIndexOfElement(int[] nums, int target){
        if(nums==null)
            return -1;
        if(target>nums[nums.length-1]){
            return nums.length;
        }

        int i=0;
        int j=nums.length;

        while(i<j){
            int m=(i+j)/2;
            if(target>nums[m]){
                i=m+1;
            }else{
                j=m;
            }
        }

        return j;
    }

    public static void main(String[] args){

        int[] nums={1,3,5,9,11};
        SearchInsertPosition si = new SearchInsertPosition();
        System.out.println("Find Element or Insert  " + si.findIndexOfElement(nums,12) );
    }
}
