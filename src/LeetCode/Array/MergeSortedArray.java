package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/10.
 */

public class MergeSortedArray {


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1==null||nums2==null) return;
        int[] res = new int[n+m];
        int ind1=0,ind2=0,ind=0;
        while (ind1<m&&ind2<n){
            if (nums1[ind1]<nums2[ind2]){
                res[ind++]=nums1[ind1++];
            }else {
                res[ind++]=nums2[ind2++];
            }
        }
        while (ind1<m){
            res[ind++]=nums1[ind1++];
        }
        while (ind2<n){
            res[ind++]=nums2[ind2++];
        }
        for (int i=0;i<m+n;i++){
            nums1[i]=res[i];
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
       int ind1=m-1,ind2=n-1,k=m+n-1;
       while (ind1>-1&&ind2>-1)
           nums1[k--]=(nums1[ind1]>nums2[ind2])?nums1[ind1--]:nums2[ind2--];
       while (ind2>-1)
           nums1[k--]=nums2[ind2--];

    }
}
