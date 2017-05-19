package LeetCode.Array.DP;

/**
 * Created by mayiwei on 2017/5/7.
 */
//
public class JumpGame {

    public static void main(String[] args){
        canJump(new int[]{2,1,0});
    }

    //dp
    public static boolean canJump(int[] nums) {
        int canReach=0;//标注现在能到达的最远距离
        for (int i=0;i<nums.length;i++){
            if (i>canReach) return false;
            canReach=Math.max(nums[i]+i,canReach);
        }
        return true;
    }

    public static boolean canJump2(int[] nums) {
        if (nums==null||nums.length<2) return true;
        for (int i=nums.length-2;i>=0;i--){
            if (nums[i]==0){
                int needJump=1;
                while (needJump>nums[i]){
                    needJump++;
                    i--;
                    if (i<0) return false;
                }
            }
        }
        return true;
    }

}
