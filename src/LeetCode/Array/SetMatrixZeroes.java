package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/17.
 */
//https://leetcode.com/problems/set-matrix-zeroes/#/solutions
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        boolean allRow=false,allCow=false;
        int row=matrix.length,cow=matrix[0].length;
        for (int i=0;i<row;i++){
            for (int j=0;j<cow;j++){
                if (matrix[i][j]==0){
                    if (i==0) allRow=true;
                    if (j==0) allCow=true;
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for (int i=1;i<row;i++){
            for (int j=1;j<cow;j++){
                if (matrix[i][0]==0||matrix[0][j]==0) matrix[i][j]=0;
            }
        }
        if (allRow)
            for (int i=0;i<cow;i++) matrix[0][i]=0;
        if (allCow)
            for (int i=0;i<row;i++) matrix[i][0]=0;
    }

}
