import java.util.LinkedList;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/8.
 */
//http://www.lintcode.com/zh-cn/problem/gas-station/
public class GasStation {

    public static void main(String[] args){
        canCompleteCircuit2(new int[]{1,2,3,3},new int[]{2,1,5,1});
    }

    //Greedy
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas==null||cost==null) return -1;
        int len = gas.length;
        if (cost.length!=len) return -1;
        int maxGas=Integer.MIN_VALUE;
        List<Integer> maxi=new LinkedList<>();
        for (int i=0;i<len;i++){
            if (maxGas<gas[i]-cost[i]) {
                maxi.clear();
                maxi.add(i);
                maxGas=gas[i]-cost[i];
            }else if (maxGas==gas[i]-cost[i]){
                maxi.add(i);
            }
        }

        for (int i:maxi){
            int curGas=gas[i]-cost[i];
            if (curGas<0) return -1;
            int cur=(i+1)%len;
            while (cur!=i){
                curGas+=gas[cur];
                curGas-=cost[cur];
                if (curGas<0) return -1;
                cur=cur!=len-1?cur+1:0;
            }
            return i;
        }
        return -1;
    }

    public static int canCompleteCircuit2(int[] gas, int[] cost) {
        if (gas==null||cost==null) return -1;
        int len = gas.length;
        if (cost.length!=len) return -1;
        int cur,curGas,res=-1;
        boolean fasOut=false;
        for (int i=0;i<len;i++){
            curGas=gas[i]-cost[i];
            if (curGas<0) continue;
            cur=(i+1)%len;
            while (cur!=i){
                fasOut=false;
                curGas+=gas[cur];
                curGas-=cost[cur];
                if (curGas<0) {
                    fasOut=true;
                    break;
                }
                cur=(cur+1)%len;
            }
            if (!fasOut) {
                res=i;
                break;
            }
        }
        return res;
    }
}
