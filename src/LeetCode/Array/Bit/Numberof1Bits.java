package LeetCode.Array.Bit;

/**
 * Created by mayiwei on 2017/5/21.
 */
//https://leetcode.com/problems/number-of-1-bits/#/description
public class Numberof1Bits {



    public static int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; i++){
            count += (n >> i & 1) == 1 ? 1: 0;
        }
        return count;
    }

    public static int hammingWeight2(int n) {
        int ones = 0;
        while(n!=0) {
            ones = ones + (n & 1);
            n = n>>>1;
        }
        return ones;
    }


}
