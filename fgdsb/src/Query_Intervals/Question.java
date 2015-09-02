package Query_Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;





public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//[9, 11], [0, 1], [3, 5], [9, 13], [7, 10], [5, 9], [4, 5], [4, 7], [8, 12]
		Interval i1 = new Interval(9, 11);
		Interval i2 = new Interval(0, 1);
		Interval i3 = new Interval(3, 5);
		Interval i4 = new Interval(9, 13);
		Interval i5 = new Interval(7, 10);
		Interval i6 = new Interval(5, 9);
		Interval i7 = new Interval(4, 5);
		Interval i8 = new Interval(4, 7);
		Interval i9 = new Interval(8, 12);
/*		Interval i1 = new Interval(0, 1);
		Interval i2 = new Interval(3, 5);*/
		
		List<Interval> data = new ArrayList<Interval>();
		data.add(i1);
		data.add(i2);
		data.add(i3);
		data.add(i4);
		data.add(i5);
		data.add(i6);
		data.add(i7);
		data.add(i8);
		data.add(i9);
		Intervals ins = new Intervals(data);
		ins.preprocess();
		System.out.println(ins.query(3));

	}
	
	/**
	 * Given a list of intervals and a time, write a function to determine is there any interval covers the given time.
	 * For example:
	 * Intervals: [0,2], [3,5]
	 * Time: 3
	 * Result: true
	 * If you are allowed to pre-process the intervals, how can you speed up the query performance?
	 * 
	 * Note: We will call your preprocess() method before queries, so do not call it in your constructor.
	 */
	
	
	

}



//to merge intervals
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
    	//merge interval from leetcode
		List<Interval> result = new ArrayList<Interval>();
		Comparator<Interval> comp = new Comparator<Interval>() { 
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.begin == i2.begin) { // 
					return i1.end - i2.end;
				}
				return (i1.begin - i2.begin); //
			}
		};
		Collections.sort(intervals, comp);
		Interval pre = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			if (intervals.get(i).begin <= pre.end) { //
				pre.end = Math .max(pre.end, intervals.get(i).end);// 
			} else { // 
				result.add(pre);
				pre = intervals.get(i);
			}
		}
		result.add(pre); //
		intervals.clear();
    	intervals.addAll(result);
    }

    public boolean query(int time) {
    	int idx = 0;
    	while (idx < intervals.size()) {
    		if (intervals.get(idx).begin <= time && time <= intervals.get(idx).end ) {
    			return true;
    		}
    		idx++;
    	}
    	return false;
    	
    	//binary search
/*    	for (Interval it : intervals) {
    		System.out.println("begin: " + it.begin +" ; " + "end: " + it.end);
    	}*/
    	
    	
    	/*int l = 0;
    	int r = intervals.size() - 1;
    	while (l + 1 < r) {
    		int m = l + (r - l) / 2;
    		if (time < intervals.get(m).begin) {
    			r = m;
    		} else if (time > intervals.get(m).begin){
    			l = m;
    		} else {
    			return true;
    		}
    	}
    	int idx = Integer.MIN_VALUE;
    	//find the largest begin that equal or smaller than time
    	if (intervals.get(r).begin <= time) {
    		idx = r;
    	} else if (intervals.get(l).begin <= time) {
    		idx = l;
    	} else {
    		return false;
    	}
    	if (time <= intervals.get(idx).end) {
    		return true;
    	} else {
    		return false;
    	}*/
    	
    	
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
