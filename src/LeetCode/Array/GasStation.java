package LeetCode.Array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/8.
 */
//https://leetcode.com/problems/gas-station/#/description
public class GasStation {

    public static void main(String[] args){
        canCompleteCircuit2(new int[]{1,2,3,3},new int[]{2,1,5,1});
    }

    //n
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int sum=0,total=0,j=-1;
        for (int i=0;i<gas.length;i++){
            sum+=gas[i]-cost[i];
            total+=gas[i]-cost[i];
            if (sum<0){
                j=i;
                sum=0;//之前的油量不够到达当前加油站,清零
            }
        }
        if (total<0) return -1;//所有加油站的油量都不够整个路程的消耗
        else return j+1;
    }

    //n2 TLE
    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        int cur,gasSum;
        for (int i=0;i<gas.length;i++){
            cur=i;
            gasSum=gas[cur];
            while (gasSum>=cost[cur]){
                gasSum-=cost[cur];
                cur=(cur+1)%gas.length;
                if (cur==i) return i;
                gasSum+=gas[cur];
            }
        }
        return -1;
    }
}
