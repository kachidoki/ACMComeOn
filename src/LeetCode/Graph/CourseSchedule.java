package LeetCode.Graph;

import java.util.*;

/**
 * Created by mayiwei on 2017/4/2.
 */
//https://leetcode.com/problems/course-schedule/#/description
public class CourseSchedule {

    public static void main(String[] args){
        canFinish2(2,new int[][]{{0,1},{1,0}});
    }

    //BFS
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites==null) return true;
        int len = prerequisites.length;
        if (numCourses<=0||len==0) return true;
        int[] needCourse = new int[numCourses];//把需要选这门课之前的准备计数
        for (int i=0;i<len;i++){
            needCourse[prerequisites[i][0]]++;
        }
        Queue<Integer> toSee = new LinkedList<>();
        int nowSize=0;
        for (int i=0;i<numCourses;i++){
            if (needCourse[i]==0) {
                toSee.offer(i);
                nowSize++;
            }
        }
        while (!toSee.isEmpty()){
            int cur = toSee.poll();
            for (int i=0;i<len;i++){
                if (cur==prerequisites[i][1]) {
                    needCourse[prerequisites[i][0]]--;
                    if (needCourse[prerequisites[i][0]]==0){
                        nowSize++;
                        toSee.offer(prerequisites[i][0]);
                    }
                }
            }
        }
        return nowSize==numCourses;
    }


    //DFS
    public static boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (prerequisites==null) return true;
        if (numCourses<=0||prerequisites.length==0) return true;

        int len = prerequisites.length;
        Map<Integer,List<Integer>> preLearn = new HashMap<>();//创建一个需要pre学习的表
        int[] canLearn = new int[numCourses];
        for (int i=0;i<len;i++){
            if (preLearn.containsKey(prerequisites[i][0])){
                preLearn.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }else {
                List<Integer> needLearn = new LinkedList<>();
                needLearn.add(prerequisites[i][1]);
                preLearn.put(prerequisites[i][0],needLearn);
            }
        }
        for (int i=0;i<numCourses;i++){
            if (!DFS(preLearn,canLearn,i)) return false;
        }

        return true;
    }


    public static boolean DFS(Map<Integer,List<Integer>> preLearn,int[] canLearn,int i){
        if (canLearn[i]==-1) return false;
        if (canLearn[i]==1) return true;
        canLearn[i]=-1;//先赋值防止循环
        if (preLearn.containsKey(i)){
            for (int j:preLearn.get(i)){
                if (!DFS(preLearn,canLearn,j)){
                    return false;
                }
            }
        }
        canLearn[i]=1;
        return true;
    }
}
