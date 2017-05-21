package LeetCode.Array.TwoPoint;

/**
 * Created by mayiwei on 2017/5/14.
 */
//https://leetcode.com/problems/remove-element/#/description
public class RemoveElement {

    public static void main(String[] args){
        removeElement2(new int[]{3,1,2,4,3},3);
    }

    //two pointer 重置
    public int removeElement(int[] nums, int val) {
        if (nums==null||nums.length==0) return 0;
        int count=0,n=nums.length,index=0;
        while (count<n&&index<n){
            if (nums[index]!=val) nums[count++]=nums[index++];
            else index++;
        }
        return count;
    }

    //不要求按顺序
    public static int removeElement2(int[] A, int elem) {
        int len = A.length;
        for (int i = 0 ; i< len; ++i){
            while (A[i]==elem && i< len) {
                A[i]=A[--len];
            }
        }
        return len;
    }

}
