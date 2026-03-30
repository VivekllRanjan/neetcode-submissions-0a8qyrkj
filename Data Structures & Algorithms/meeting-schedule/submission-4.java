/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0) return true;
        intervals.sort((a, b) -> a.start - b.start);
        int prevend = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++) {
            if(prevend > intervals.get(i).start) return false;
            prevend = intervals.get(i).end;
        }
        return true;
    }
}
