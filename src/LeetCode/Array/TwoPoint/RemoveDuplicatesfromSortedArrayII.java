package LeetCode.Array.TwoPoint;

/**
 * Created by mayiwei on 2017/4/21.
 */
public class RemoveDuplicatesfromSortedArrayII {

    public static void main(String[] args){
        removeDuplicates(new int[]{1,1,1,2,2,3});
    }


    public static int removeDuplicates(int[] nums) {
        if (nums==null||nums.length==0) return 0;
        int res=1,count=1,index=1;
        while (index<nums.length){
            if (nums[index]!=nums[index-1]){
                count=1;
                nums[res++]=nums[index];
            }else {
                if (count++<2) nums[res++]=nums[index];
            }
            index++;
        }
        return res;
    }


    //巧妙的方法，只需要与k之前的比较就可以
    //Remove Duplicates from Sorted Array(no duplicates) :

    public int removeDuplicatesII(int[] nums) {
        int i = 0;
        for(int n : nums)
            if(i < 1 || n > nums[i - 1])
                nums[i++] = n;
        return i;
    }

    //Remove Duplicates from Sorted Array II (allow duplicates up to 2):

    public int removeDuplicatesII2(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i - 2])
                nums[i++] = n;
        return i;
    }

}
