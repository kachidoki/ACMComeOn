package LeetCode.Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/18.
 */
//https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {

    public static void main(String[] args){
        spiralOrder(new int[][]{{6,9,7}});
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if (matrix==null||matrix.length==0) return res;
        Wrapper(matrix,0,0,matrix.length,matrix[0].length,res);
        return res;
    }

    public static void Wrapper(int[][] matrix,int startr,int startc,int row,int col,List<Integer> list){
        for (int i=0;i<col;i++){
            list.add(matrix[startr][startc+i]);
        }
        for (int i=1;i<row;i++){
            list.add(matrix[startr+i][startc+col-1]);
        }
        for (int i=1;row!=1&&i<col;i++){
            list.add(matrix[startr+row-1][startc+col-1-i]);
        }
        for (int i=1;col!=1&&i<row-1;i++){
            list.add(matrix[startr+row-1-i][startc]);
        }
        if (row-2>0&&col-2>0) Wrapper(matrix,startr+1,startc+1,row-2,col-2,list);
    }


}
