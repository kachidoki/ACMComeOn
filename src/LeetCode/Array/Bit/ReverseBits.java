package LeetCode.Array.Bit;

/**
 * Created by mayiwei on 2017/5/21.
 */
//https://leetcode.com/problems/reverse-bits/#/description
public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n >>>= 1;
            if (i < 31) result <<= 1;
        }
        return result;
    }

}
