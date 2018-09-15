package strings;

import java.util.IntSummaryStatistics;

/**
 * Created by vnalubandu on 6/6/18.
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length of 2 under the problem constraint.
 */
public class MinSizeSubArraySum {

    /**
     * Notes: Array can contain duplicate elements. Iterate from left and right
     */
    /**
     *
     * @param nums
     * @param s
     * @return
     */
    public int getMinSizeOfSubArraySum(int[] nums,int s){
        if(nums.length==0 || nums.length<2){
            return 0;
        }

        int j = 0;
        int sum=0;
        int i=0;
        int minLength= Integer.MAX_VALUE;
        while (j<nums.length-1){
            if(sum<s){
                sum += nums[j];
                j++;
            }else{
                minLength = Math.min(minLength, j-i);
                if(i==j-1)
                    return 1;

                sum -=nums[i];
                i++;
            }
        }

        return minLength==Integer.MAX_VALUE? 0: minLength;
    }

    public static void main(String[] args){
        int[] nums = {2,3,1,2,4,3};
        MinSizeSubArraySum minSize = new MinSizeSubArraySum();
        // test cases failing for 8,7
        System.out.println("Min size of Array Sum is " + minSize.getMinSizeOfSubArraySum(nums,4));
    }
}
