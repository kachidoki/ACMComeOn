import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by mayiwei on 2017/4/2.
 */
//定义一个二维数组：
//int maze[5][5] = {
//        0, 1, 0, 0, 0,
//        0, 1, 0, 1, 0,
//        0, 0, 0, 0, 0,
//        0, 1, 1, 1, 0,
//        0, 0, 0, 1, 0,
//        };
//        它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。
public class BFS {


    public static void main(String[] args){
        int maze[][] = { { 0, 1, 0, 0, 0 },
                         { 0, 1, 0, 1, 0 },
                         { 0, 0, 0, 0, 0 },
                         { 0, 1, 1, 1, 0 },
                         { 0, 0, 0, 1, 0 } };
        find(maze);
    }

    public static void find(int[][] maze){
        Queue<Node> togo=new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        Node cur = new Node(0,0);
        Node end = new Node(4,4);
        addQueue(togo,cur,visited,maze);
        while (!togo.isEmpty()){
            cur=togo.poll();
            visited[cur.x][cur.y]=true;
            if (cur==end) break;
            addQueue(togo,cur,visited,maze);
        }
        Stack<Node> path= new Stack<>();
        while (cur!=null){
            path.push(cur);
            cur=cur.pre;
        }
        while (!path.empty()){
            cur=path.pop();
            System.out.println("("+cur.x+","+cur.y+")");
        }

    }

    public static void addQueue(Queue<Node> q,Node p,boolean[][] visited,int[][] maze){
        if (p.x-1>=0){
            if (visited[p.x-1][p.y]==false&&maze[p.x-1][p.y]!=1) q.offer(new Node(p.x-1,p.y,p));
        }
        if (p.y-1>=0){
            if (visited[p.x][p.y-1]==false&&maze[p.x][p.y-1]!=1) q.offer(new Node(p.x,p.y-1,p));
        }
        if (p.x+1<5){
            if (visited[p.x+1][p.y]==false&&maze[p.x+1][p.y]!=1) q.offer(new Node(p.x+1,p.y,p));
        }
        if (p.y+1<5){
            if (visited[p.x][p.y+1]==false&&maze[p.x][p.y+1]!=1) q.offer(new Node(p.x,p.y+1,p));
        }
    }


    public static class Node{
        public int x;
        public int y;
        public Node pre;
        public Node(int x,int y){
            this.x=x;
            this.y=y;
        }
        public Node(int x,int y,Node pre){
            this.x=x;
            this.y=y;
            this.pre=pre;
        }
    }

}
