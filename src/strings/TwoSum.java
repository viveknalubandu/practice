package strings;

import trees.InOrderTraversal;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vnalubandu on 6/4/18.
 */
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        if(nums==null || nums.length<2)
            return new int[]{0,0};
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]), i};
            }else{
                map.put(target-nums[i], i);
            }
        }
        return new int[]{-1,-1};
    }

    public int[] twoSumOfSortedArray(int[] nums,int target){
                    // 1,2,3,4,5,6,7,8
        if (nums == null || nums.length == 0)
            return null;

        int start = 0;
        int end = nums.length-1;
        while (start<end){
            int sum = nums[start]+nums[end];
            if(sum<target){
                ++start;
            }else if(sum>target){
                end--;
            } else {
                return new int[]{start,end};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args){
        int[] nums1 = new int[]{2, 7, 15, 12};
        int k = 9;
        TwoSum ts= new TwoSum();
        int[] indexes = ts.twoSum(nums1,k);
        for (int i:indexes)
            System.out.println("Numbers : "+nums1[indexes[i]]);

        int[] nums2 = new int[]{2, 7, 11, 15};
        int[] indexes1 = ts.twoSumOfSortedArray(nums2,k);
        for (int i:indexes)
            System.out.println("Numbers : "+nums2[indexes1[i]]);

    }
}
