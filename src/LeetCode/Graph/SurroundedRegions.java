package LeetCode.Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by mayiwei on 2017/4/3.
 */
//https://leetcode.com/problems/surrounded-regions/#/description
public class SurroundedRegions {
    //BFS
    public static void solve(char[][] board) {
        int ylen=board.length;
        if (ylen<3) return;
        int xlen=board[0].length;
        if (xlen<3) return;
        boolean[][] MarkBoard = new boolean[ylen][xlen];
        Queue<Point> toBeMark=new LinkedList<>();
        for (int i=0;i<ylen;i++){
            toBeMark.add(new Point(0, i));
            toBeMark.add(new Point(xlen-1, i));
        }
        for (int i=0;i<xlen;i++){
            toBeMark.add(new Point(i,0));
            toBeMark.add(new Point(i,ylen-1));
        }
        while (!toBeMark.isEmpty()){
            Point cur = toBeMark.poll();
            MarkBoard(MarkBoard,board,cur,toBeMark,xlen,ylen);
        }
        for (int i=0;i<xlen;i++){
            for (int j=0;j<ylen;j++){
                if (board[j][i]=='O'){
                    if (!MarkBoard[j][i]) board[j][i]='X';
                }
            }
        }
    }


    public static void BFSaddQueue(Queue<Point> q,char[][] board,Point p,int xlen,int ylen){
        if (p.x-1>=0&&p.y>=0&&p.x-1<xlen&&p.y<ylen) {
            if (board[p.y][p.x-1]=='O') q.offer(new Point(p.x-1,p.y));
        }
        if (p.x+1>=0&&p.y>=0&&p.x+1<xlen&&p.y<ylen) {
            if (board[p.y][p.x+1]=='O') q.offer(new Point(p.x+1,p.y));
        }
        if (p.x>=0&&p.y-1>=0&&p.x<xlen&&p.y-1<ylen) {
            if (board[p.y-1][p.x]=='O') q.offer(new Point(p.x,p.y-1));
        }
        if (p.x>=0&&p.y+1>=0&&p.x<xlen&&p.y+1<ylen) {
            if (board[p.y+1][p.x]=='O') q.offer(new Point(p.x,p.y+1));
        }
    }

    public static void MarkBoard(boolean[][] isMark,char[][] board,Point p,Queue<Point> q,int xlen,int ylen){
        if (isMark[p.y][p.x]) return;
        if (board[p.y][p.x]=='O'){
            isMark[p.y][p.x]=true;
            BFSaddQueue(q,board,p,xlen,ylen);
        }
    }


    public static class Point{
        public int x;
        public int y;
        public Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    //DFS
    public void solve2(char[][] board) {
        if (board.length == 0 || board[0].length == 0)
            return;
        if (board.length < 2 || board[0].length < 2)
            return;
        int m = board.length, n = board[0].length;
        //只要是和边界上的O连起来的就都不能变为X
        //所以先把他们变成*
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O')
                boundaryDFS(board, i, 0);
            if (board[i][n-1] == 'O')
                boundaryDFS(board, i, n-1);
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O')
                boundaryDFS(board, 0, j);
            if (board[m-1][j] == 'O')
                boundaryDFS(board, m-1, j);
        }
        //把O变成X,*变成O
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '*')
                    board[i][j] = 'O';
            }
        }
    }
    //DFS把与边界相连的 'O' to '*';
    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j <0 || j > board[0].length - 1)
            return;
        if (board[i][j] == 'O')
            board[i][j] = '*';
        if (i > 1 && board[i-1][j] == 'O')
            boundaryDFS(board, i-1, j);
        if (i < board.length - 2 && board[i+1][j] == 'O')
            boundaryDFS(board, i+1, j);
        if (j > 1 && board[i][j-1] == 'O')
            boundaryDFS(board, i, j-1);
        if (j < board[i].length - 2 && board[i][j+1] == 'O' )
            boundaryDFS(board, i, j+1);
    }
}
