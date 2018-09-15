package strings;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by vnalubandu on 6/3/18.
 */
public class KthLargestElement {

    public int findKthLargest1(int[] nums,int k){
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public int findKthLargest2(int[] nums,int k){
        if(k<0 || nums==null){
            return 0;
        }
        return findKthLargestElement(nums,nums.length-k+1,0,nums.length-1);
    }

    private int findKthLargestElement(int[] nums,int k,int start,int end){
        int pivot=nums[end];

        int left = start;
        int right = end;

        while (true){
            while (nums[left]<pivot && right>left){
                left++;
            }

            while (nums[right]>=pivot && right>left){
                right--;
            }

            if(left==right){
                break;
            }

            int temp = nums[left];
            nums[left]=nums[right];
            nums[right]=temp;
        }

        int temp1 = nums[left];
        nums[left]=nums[end];
        nums[end]=temp1;

        if(k==left+1){
            return pivot;
        } else if(k<left+1){
            return findKthLargestElement(nums,k,start,left-1);
        } else{
            return findKthLargestElement(nums,k,left+1,end);
        }
    }
    public static void main(String[] args){
        int[] nums = new int[]{1,4,7,3,2};
        KthLargestElement kls = new KthLargestElement();
        System.out.println("Kth largest Element    " + kls.findKthLargest2(nums,2));
    }
}
