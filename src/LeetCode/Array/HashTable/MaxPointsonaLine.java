package LeetCode.Array.HashTable;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mayiwei on 2017/5/14.
 */
//https://leetcode.com/problems/max-points-on-a-line/#/description
public class MaxPointsonaLine {
    static class Point {
        int x;
        int y;
        Point() { x = 0; y = 0; }
        Point(int a, int b) { x = a; y = b; }
    }

    public static void main(String[] args){
        maxPoints(new Point[]{new Point(0,0),new Point(94911151,94911150),new Point(94911152,94911151)});
    }

    public static int maxPoints(Point[] points) {
        if (points==null||points.length==0) return 0;
        if (points.length<=2) return points.length;
        int res=0;
        for (int i=0;i<points.length;i++){
            Map<BigDecimal,Integer> map=new HashMap<>();
            int samex=1,samep=0;
            for (int j=0;j<points.length;j++){
                if (j!=i){
                    if ((points[j].x==points[i].x)&&(points[j].y==points[i].y)) samep++;
                    if (points[j].x==points[i].x){
                        samex++;
                        continue;
                    }
                    BigDecimal k=new BigDecimal(points[j].y-points[i].y).divide(new BigDecimal(points[j].x-points[i].x),MathContext.DECIMAL128);
                    if (map.containsKey(k)) map.put(k,map.get(k)+1);
                    else map.put(k,2);
                    res=Math.max(res,map.get(k)+samep);//不用遍历map
                }
            }
            res=Math.max(res,samex);
        }
        return res;
    }

}
