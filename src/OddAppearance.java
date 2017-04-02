/**
 * Created by mayiwei on 2017/4/1.
 */
//给定一个整型数组arr，其中有两个数出现了奇数次，其他的数都出现了偶数次，找到这两个数。要求时间复杂度为O(N)，额外空间复杂度为O(1)。

//给定一个整形数组arr及它的大小n，请返回一个数组，其中两个元素为两个出现了奇数次的元素,请将他们按从小到大排列。
public class OddAppearance {



    public int[] findOdds(int[] arr, int n) {
        int oc1=0;
        for (int i=0;i<n;i++){
            oc1^=arr[i];
        }
        //此时oc1为a^b
        //找一个oc1中第一个为1的位置
        int position=0;
        while ((oc1>>position&1)!=1){
            position++;
        }
        int oc2=0;
        for (int i=0;i<n;i++){
            if ((arr[i]>>position&1)==1) oc2^=arr[i];
        }
        int a = Math.min(oc2,oc1^oc2);
        int b = Math.max(oc2,oc1^oc2);
        return new int[]{a,b};
    }

}
