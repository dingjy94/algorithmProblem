/**
 * Given a collection of intervals, merge all overlapping intervals. 
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 *  Interface Comparator<T>: int compare()
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> result = new LinkedList<>();
        for (Interval i : intervals) {
            if (result.isEmpty() || result.getLast().end < i.start) {
                result.add(i);
            } else if (result.getLast().end < i.end) {
                result.getLast().end = i.end;
            }
        }
        return result;
    }
    
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval interval1, Interval interval2) {
            return interval1.start < interval2.start ? -1 : interval1.start == interval2.start ? 0 : 1;
        }
    }
}
