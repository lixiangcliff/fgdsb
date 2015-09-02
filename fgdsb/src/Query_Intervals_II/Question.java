package Query_Intervals_II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i3 = new Interval(4, 7);
		Interval i2 = new Interval(2, 8);
		Interval i1 = new Interval(1, 6);
		
		List<Interval> data = new ArrayList<Interval>();
		data.add(i1);
		data.add(i2);
		data.add(i3);
		Intervals ins = new Intervals(data);
		ins.preprocess();
		List<Interval> res = ins.query(8);
		for (Interval it : res) {
			System.out.println("begin: " + it.begin +" ; " + "end: " + it.end);
		}

	}
	
	/**
	 * Follow up for "Query Intervals":
	 * How about return all intervals that cover the given time?
	 * Note: Please keep your results sorted by the begin time.
	 */


}

class Intervals {
    public Intervals(List<Interval> data) {
    	intervals = new ArrayList<Interval>();
    	if (data != null && data.size() != 0) {
    		for (Interval i : data) {
        		intervals.add(i);
        	}
    	}
    }

    public void preprocess() {
    	if (intervals == null || intervals.size() == 0) {
    		return;
    	}
    	Comparator<Interval> comp = new Comparator<Interval>() {
    		@Override
    		public int compare(Interval i1, Interval i2) {
    			if (i1.begin == i2.begin) {
    				return i1.end - i2.end;
    			} else {
    				return i1.begin - i2.begin;
    			}
    		}
    	};
    	Collections.sort(intervals, comp);
    }

    public List<Interval> query(int time) {
    	List<Interval> res = new ArrayList<Interval>();
    	int idx = 0;
    	while (idx < intervals.size()) {
    		if (intervals.get(idx).begin <= time && time <= intervals.get(idx).end ) {
    			res.add(intervals.get(idx));
    		}
    		idx++;
    	}
    	return res;
    }
    List<Interval> intervals;
};

class Interval {
    public int begin = 0, end = 0;
    public Interval() {}
    public Interval(int b, int e) {
        begin = b;
        end = e;
    }
}
