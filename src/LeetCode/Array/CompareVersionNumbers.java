package LeetCode.Array;

/**
 * Created by mayiwei on 2017/5/6.
 */
//https://leetcode.com/problems/compare-version-numbers/#/description
public class CompareVersionNumbers {

    public static void main(String[] args){
        compareVersion2("01","1");
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int max=Math.max(v1.length,v2.length);
        for (int i=0;i<max;i++){
            int num1 = i<v1.length?Integer.parseInt(v1[i]):0;
            int num2 = i<v2.length?Integer.parseInt(v2[i]):0;
            if (num1<num2) {
                return -1;
            }else if(num1>num2){
                return 1;
            }
        }
        return 0;
    }

    //char比对
    public static int compareVersion2(String version1, String version2) {
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int max=Math.max(v1.length,v2.length);
        for (int i=0;i<max;i++){
            int l1=i<v1.length?v1[i].length():0;
            int l2=i<v2.length?v2[i].length():0;
            int min=Math.min(l1,l2);
            int zeroind1=0,zeroind2=0;
            while (zeroind1<l1&&v1[i].charAt(zeroind1)=='0') zeroind1++;
            while (zeroind2<l2&&v2[i].charAt(zeroind2)=='0') zeroind2++;
            if (l1-zeroind1>l2-zeroind2){
                return 1;
            }else if (l1-zeroind1<l2-zeroind2){
                return -1;
            }
            for (int j=0;j<min&&j+zeroind1<min&&j+zeroind2<min;j++){
                if (v1[i].charAt(j+zeroind1)>v2[i].charAt(j+zeroind2)){
                    return 1;
                }else if (v1[i].charAt(j+zeroind1)<v2[i].charAt(j+zeroind2)){
                    return -1;
                }
            }
        }
        return 0;
    }

}
