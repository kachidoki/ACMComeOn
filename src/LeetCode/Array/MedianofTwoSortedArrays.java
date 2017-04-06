package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/6.
 */
//https://leetcode.com/problems/median-of-two-sorted-arrays/#/solutions
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        //保证1数组比2要小
        if (n > m)
            return findMedianSortedArrays(nums2, nums1);
        // 2分查找
        int k = (n + m - 1) / 2;
        int l = 0, r = Math.min(k, n); // r是n不是n-1
        while (l < r) {
            int midA = (l + r) / 2;
            int midB = k - midA;
            if (nums1[midA] < nums2[midB])
                l = midA + 1;
            else
                r = midA;
        }
        // 找到了中位数只可能是以下情况
        // A[l-1], A[l], B[k-l], B[k-l+1]

        // 如果（n + m）是奇数，则中值是A [l-1]和B [k-1]之间的较大值。
        // 然后考虑一些特殊情况
        int a = Math.max(l > 0 ? nums1[l - 1] : Integer.MIN_VALUE, k - l >= 0 ? nums2[k - l] : Integer.MIN_VALUE);
        if (((n + m) & 1) == 1)
            return (double) a;

        // 如果（n + m）是偶数，则可以通过计算中值
        // median = (max(A[l-1], B[k-l]) + min(A[l], B[k-l+1]) / 2.0
        // 然后考虑一些特殊情况
        int b = Math.min(l < n ? nums1[l] : Integer.MAX_VALUE, k - l + 1 < m ? nums2[k - l + 1] : Integer.MAX_VALUE);
        return (a + b) / 2.0;
    }
}
