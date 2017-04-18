package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/18.
 */
//https://leetcode.com/problems/search-a-2d-matrix/#/description
public class Searcha2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0) return false;
        int row=matrix.length,col=matrix[0].length;
        int nowrow=0,nowcol=col-1;
        while (nowcol>=0&&nowrow<row){
            if (matrix[nowrow][nowcol]<target){
                nowrow++;
            }else if (matrix[nowrow][nowcol]>target){
                nowcol--;
            }else {
                return true;
            }
        }
        return false;
    }

}
