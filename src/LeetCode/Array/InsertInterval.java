package LeetCode.Array;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mayiwei on 2017/4/8.
 */
//https://leetcode.com/problems/insert-interval/#/solutions
public class InsertInterval {

    public static class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        if (intervals==null||intervals.isEmpty()) {
            if (newInterval==null) return res;
            else {
                res.add(newInterval);
                return res;
            }
        }
        for (Interval i : intervals) {
            if (newInterval == null || i.end < newInterval.start)
                res.add(i);
            else if (i.start > newInterval.end) {
                res.add(newInterval);
                res.add(i);
                newInterval = null;
            } else {
                newInterval.start = Math.min(newInterval.start, i.start);
                newInterval.end = Math.max(newInterval.end, i.end);
            }
        }
        if (newInterval != null)
            res.add(newInterval);
        return res;
    }


}
