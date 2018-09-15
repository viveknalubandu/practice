package strings;

/**
 * Created by vnalubandu on 7/24/18.
 */
public class CountRemoveDuplicates {

    /**
     * Sorted Array  {1,1,1,2,2,3,3,3,4}
     * @param nums
     * @return
     */
    public int countAfterRemoveDuplicates(int[] nums){
        if(nums.length==0){
            return 0;
        }
        if(nums.length<2){
            return 1;
        }
        int n= nums.length;
        int count=0;
        for(int k=1;k<n;k++){
            if(nums[count]!=nums[k]){
                count++;
                nums[count]=nums[k];
            }
        }
        return count+1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,1,1,2,2,3,3,3,4};
        int[] nums1 = new int[]{1,1,2,2,3,3,4,8,9};
        int[] nums2 = new int[]{1,1,2};
        CountRemoveDuplicates crm = new CountRemoveDuplicates();
        int count = crm.countAfterRemoveDuplicates(nums2);
        System.out.print("Unique num  " + count);
    }
}
