package LeetCode.Array;

/**
 * Created by mayiwei on 2017/4/18.
 */
//https://leetcode.com/problems/rotate-image/#/description
public class RotateImage {


    public static void main(String[] args){
        rotate(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}});
    }

    public static void rotate(int[][] matrix) {
        rotateImage(matrix,0,matrix.length);
    }

    public static void rotateImage(int[][] matrix,int start,int n){
        int[] tmp=new int[n];
        for (int i=0;i<n;i++){
            tmp[i]=matrix[start][start+i];
        }
        for (int i=1;i<n;i++){
            matrix[start][start+n-1-i]=matrix[start+i][start];
        }
        for (int i=1;i<n;i++){
            matrix[start+i][start]=matrix[start+n-1][start+i];
        }
        for (int i=1;i<n;i++){
            matrix[start+n-1][start+i]=matrix[start+n-1-i][start+n-1];
        }
        for (int i=1;i<n;i++){
            matrix[start+n-1-i][start+n-1]=tmp[n-1-i];
        }
        if (n-2>1) rotateImage(matrix,start+1,n-2);
    }


    //先翻转矩阵，再每行倒序 666
    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
    */
    public void rotate2(int[][] matrix) {
        for(int i = 0; i<matrix.length; i++){
            for(int j = i; j<matrix[0].length; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i =0 ; i<matrix.length; i++){
            for(int j = 0; j<matrix.length/2; j++){
                int temp = 0;
                temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = temp;
            }
        }
    }

}
