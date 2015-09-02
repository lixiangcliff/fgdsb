package Maximum_Non_overlapping_Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given a list of intervals of time, find maximum number of non-overlapping intervals.
	 * For example:
	 * Given [0,2], [1,4], [3,5], the result would be 2.
	 */
	
	
	//http://www.glassdoor.com/Interview/given-an-array-of-intervals-return-max-number-of-non-overlapping-intervals-QTN_636638.htm
    public int max_intervals(Interval[] intervals) {
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
    	Arrays.sort(intervals, comp);
    	return 0;
    	
    }
	

}

class Interval {
    public int begin = 0, end = 0;
    public Interval() {}
    public Interval(int b, int e) {
        begin = b;
        end = e;
    }
}
