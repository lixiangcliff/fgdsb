package Meeting_Rooms;

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
	 * Given an array of pairs where each pair contains the start and end time of a meeting (as in int), 
	 * please write a function to determine if a single person can attend all the meetings.
	 * For example:
	 * Input: [[1,4], [4, 5], [3,4], [2,3]]
	 * Output: false
	 * Note: We use Interval class to represent a meeting.
	 */
	
    public boolean attend_all(Interval[] meetings) {
    	if (meetings == null || meetings.length == 0) {
    		return false;
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
    	Arrays.sort(meetings, comp);
    	int preEnd = meetings[0].end;
    	for (int i = 1; i < meetings.length; i++) {
    		if (meetings[i].begin < preEnd) {
    			return false;
    		}
    		preEnd = meetings[i].end;
    	}
    	return true;
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
