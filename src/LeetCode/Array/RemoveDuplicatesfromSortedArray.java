package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/21.
 */
public class RemoveDuplicatesfromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int j=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=nums[j]) nums[++j]=nums[i];
        }
        return ++j;
    }


}
