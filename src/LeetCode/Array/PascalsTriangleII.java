package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayiwei on 2017/5/11.
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res=new ArrayList<>();
        for (int i=0;i<rowIndex+1;i++){
            res.add(1);
            for (int j=i-1;j>0;j--){
                res.set(j,res.get(j-1)+res.get(j));
            }
        }
        return res;
    }

}
