package strings;

/**
 * Created by vnalubandu on 6/24/18.
 *
 * Given an unsorted integer array, find the first missing positive integer.
 * For example, given [1,2,0] return 3 and [3,4,-1,1] return 2.Your algorithm should run in O(n) time and uses constant space
 */
public class MissingPostiveNumber {

    public int missingNumber(int[] nums){
        int len = nums.length;
        for(int i=0;i<len;i++ ){
            while (nums[i]!=i){
                if(nums[i]<0 || nums[i]>len){
                    break;
                }

                if(nums[i]==nums[nums[i]]){
                    break;
                }

                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        } // Bucket sort completed

        for(int i=0; i<len;i++){
            if(nums[i]!=i){
                return i;
            }
        }

        return len;
    }
}
