package LeetCode.Array;

/**
 * Created by mayiwei on 2017/5/7.
 */
//https://leetcode.com/problems/jump-game-ii/#/solutions
public class JumpGameII {

    public int jump(int[] nums) {
        int maxReach=nums[0],edge=0,minstep=0;
        for (int i=0;i<nums.length;i++){
            if (i>edge){
                minstep+=1;
                edge=maxReach;
                if (edge>nums.length-1) return minstep;
            }
            maxReach=Math.max(maxReach,nums[i]+i);
            if (maxReach<i) return -1;
        }
        return minstep;
    }

}
