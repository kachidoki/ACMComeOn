package LeetCode.Graph;

import java.util.*;

/**
 * Created by mayiwei on 2017/4/2.
 */
//https://leetcode.com/problems/course-schedule-ii/#/description
public class CourseScheduleII {
    //主要是多了数据的保存

    //BFS
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites==null) return new int[]{};
        int len = prerequisites.length;
        int count=0;//完成的数量
        if (numCourses<=0) return new int[]{};
        int[] order = new int[numCourses];//记录
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
            order[count++]=cur;
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
        if (nowSize!=numCourses) return new int[]{};
        return order;
    }



    //DFS
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        if (prerequisites==null) return new int[]{};
        if (numCourses<=0) return new int[]{};
        int[] order = new int[numCourses];
        int[] count={0};
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
            if (!DFS(preLearn,canLearn,i,order,count)) return new int[]{};
        }

        return order;
    }

    public static boolean DFS(Map<Integer,List<Integer>> preLearn,int[] canLearn,int i,int[] order,int[] nowCount){
        if (canLearn[i]==-1) return false;
        if (canLearn[i]==1) return true;
        canLearn[i]=-1;//先赋值防止循环
        if (preLearn.containsKey(i)){
            for (int j:preLearn.get(i)){
                if (!DFS(preLearn,canLearn,j,order,nowCount)){
                    return false;
                }
            }
        }
        canLearn[i]=1;
        order[nowCount[0]++]=i;
        return true;
    }

}
