package LeetCode.Array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/8.
 */
//https://leetcode.com/problems/merge-intervals/#/description
public class MergeIntervals {


    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static void main(String[] args){
        List<Interval> list = new LinkedList<>();
        list.add(new Interval(1,3));
        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list.add(new Interval(15,18));
        System.out.println(merge(list).toString());
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals==null||intervals.isEmpty()) return new LinkedList<>();
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for (Interval x:intervals){
            if (x.start<min) min=x.start;
            if (x.end>max) max=x.end;
        }
        boolean[] buket=new boolean[(max-min+1)*3];
        for (Interval x:intervals){
            if (x.start==x.end){
                buket[(x.start-min)*3+1]=true;
                continue;
            }
            buket[(x.start-min)*3+2]=true;
            for (int i=x.start+1;i<=x.end;i++){
                if (!buket[(i-min)*3]) buket[(i-min)*3]=true;
            }
        }
        List<Interval> res = new LinkedList<>();
        Interval tmpIn;
        int tmp=Integer.MAX_VALUE;
        boolean isopen=false;
        for (int i=min;i<=max;i++){
            if (!isopen&&buket[(i-min)*3+2]) {
                tmp=i;
                isopen=true;
                continue;
            }
            if (!isopen&&buket[(i-min)*3+1]){
                tmpIn = new Interval(i,i);
                res.add(tmpIn);
                continue;
            }
            if (isopen&&buket[(i-min)*3]&&(((i+1-min)*3<buket.length)?(!buket[(i+1-min)*3]):true)){
                tmpIn = new Interval(tmp,i);
                res.add(tmpIn);
                isopen=false;
                if (buket[(i-min)*3+2]) isopen=true;
            }
        }
        return res;
    }

    public static List<Interval> merge2(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start,o2.start);
            }
        });

        List<Interval> result = new LinkedList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public static List<Interval> merge3(List<Interval> intervals) {
        // sort start&end
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        // loop through
        List<Interval> res = new LinkedList<>();
        for (int i = 0, j = 0; i < n; i++) { // j is start of interval.
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                res.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
        }
        return res;
    }
}
