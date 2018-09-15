package strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by vnalubandu on 7/22/18.
 */
public class MergeInterval {

    public class Interval{
        int start;
        int end;
        public Interval(int start,int end){
            this.start=start;
            this.end=end;
        }
    }

    /**
     * Given [1,3],[2,6],[8,10],[15,18],
     return [1,6],[8,10],[15,18].
     * @param intervals
     * @return
     */

    public List<Interval> mergeIntervals(List<Interval> intervals){
        List<Interval> result = new ArrayList<>();

        if(intervals==null||intervals.size()==0){
            return result;
        }

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start!=o2.start){
                    return o1.start-o2.start;
                }
                else {
                    return o1.end-o2.end;
                }
            }
        });

        /**
         * Given [1,3],[2,6],[8,10],[15,18],
         return [1,6],[8,10],[15,18].
         */

        Interval pre = intervals.get(0);
        for(int i=0;i<intervals.size();i++){
            Interval curr = intervals.get(i);
            if(curr.start>pre.end){
                result.add(pre);
                pre=curr;
            }else {
                Interval merged = new Interval(pre.start,Math.max(pre.end,curr.end));
                pre = merged;
            }
        }

        result.add(pre);
        return result;
    }
}
