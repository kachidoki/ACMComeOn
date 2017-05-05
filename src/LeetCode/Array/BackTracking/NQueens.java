package LeetCode.Array.BackTracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/25.
 */
//https://leetcode.com/problems/n-queens/#/description
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res=new ArrayList<>();
        char[][] board=new char[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        DFS(board,0,res);
        return res;
    }

    public void DFS(char[][] board,int colIndex,List<List<String>> res){
        if (colIndex==board.length){
            res.add(construct(board));
            return;
        }
        for (int i=0;i<board.length;i++){
            if (checkIsOk(board,i,colIndex)){
                board[i][colIndex]='Q';
                DFS(board,colIndex+1,res);
                board[i][colIndex]='.';
            }
        }
    }

    public boolean checkIsOk(char[][] board,int y,int x){
        for (int i=0;i<board.length;i++){
            for (int j=0;j<x;j++){
                if(board[i][j]=='Q'&&(y+j==x+i||x+y==i+j||y==i)) return false;
            }
        }
        return true;
    }

    public List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }

}
