package LeetCode.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by mayiwei on 2017/5/14.
 */
//https://leetcode.com/problems/number-of-islands/#/description
public class NumberofIslands {


    public int numIslands(char[][] grid) {
        if (grid==null||grid.length==0||grid[0].length==0) return 0;
        int row=grid.length,col=grid[0].length,count=0;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (grid[i][j]=='1'){
                    DFS(grid,i,j,row,col);
                    //BFS(grid,i,j,row,col);
                    count++;
                }
            }
        }
        return count;
    }

    public void DFS(char[][] gird,int i,int j,int row,int col){
        if (i<0||j<0||i>=row||j>=col||gird[i][j]!='1') return;
        gird[i][j]='0';
        DFS(gird,i+1,j,row,col);
        DFS(gird,i-1,j,row,col);
        DFS(gird,i,j+1,row,col);
        DFS(gird,i,j-1,row,col);
    }

    public void BFS(char[][] gird,int i,int j,int row,int col){
        gird[i][j]='0';
        Deque<Integer> queue = new ArrayDeque<>();
        int code = i*col+j;//巧妙的转换
        queue.offer(code);
        while(!queue.isEmpty())
        {
            code = queue.poll();
            int y = code%col;
            int x = (code-y)/col;
            if(x>0 && gird[x-1][y]=='1')
            {
                queue.offer((x-1)*col+y);
                gird[x-1][y]='0';
            }
            if(x<row-1 && gird[x+1][y]=='1')
            {
                queue.offer((x+1)*col+y);
                gird[x+1][y]='0';
            }
            if(y>0 && gird[x][y-1]=='1')
            {
                queue.offer(x*col+y-1);
                gird[x][y-1]='0';
            }
            if(y<col-1 && gird[x][y+1]=='1')
            {
                queue.offer(x*col+y+1);
                gird[x][y+1]='0';
            }
        }
    }


}
