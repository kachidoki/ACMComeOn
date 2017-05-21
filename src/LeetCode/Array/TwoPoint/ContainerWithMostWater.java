package LeetCode.Array.TwoPoint;

/**
 * Created by mayiwei on 2017/5/11.
 */
//https://leetcode.com/problems/container-with-most-water/#/description
public class ContainerWithMostWater {

    //当左端线段L小于右端线段R时，我们把L右移，
    //这时舍弃的是L与右端其他线段（R-1, R-2, ...）组成的木桶，这些木桶是没必要判断的，
    //因为这些木桶的容积肯定都没有L和R组成的木桶容积大
    public int maxArea(int[] height) {
        if (height==null||height.length<2) return 0;
        int max=0,left=0,right=height.length-1,tmp;
        while (left<right){
            tmp=(right-left)*Math.min(height[left],height[right]);
            if (tmp>max) max=tmp;
            if (height[left]<height[right]) left++;
            else right--;
        }
        return max;
    }

}
