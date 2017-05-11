package LeetCode.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayiwei on 2017/5/11.
 */
//https://leetcode.com/problems/pascals-triangle/#/description
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res=new ArrayList<>();
        if (numRows<=0) return res;
        for (int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();
            for (int j=0;j<i+1;j++){
                if (j==0||j==i) row.add(1);
                else row.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
            }
            res.add(row);
        }
        return res;
    }

}
