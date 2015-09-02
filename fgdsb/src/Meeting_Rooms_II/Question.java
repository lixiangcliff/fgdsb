package Meeting_Rooms_II;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


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
		
		Interval[] meetings = {i1, i2, i3, i4, i5, i6, i7, i8, i9};
		Question q = new Question();
		System.out.println(q.min_rooms(meetings));
	}
	
	/**
	 * Given an array of pairs where each pair contains the start and end time of a meeting (as in int), 
	 * please write a function to determine the minimum number of meeting rooms needed to hold all the meetings.
	 * 
	 * For example:
	 * Input: [[1,4], [2,3], [3,4], [4,5]]
	 * 
	 * Output: 2
	 * Note: We use Interval class to represent a meeting.
	 */
	
	//http://www.fgdsb.com/2015/01/30/meeting-rooms/
    public int min_rooms(Interval[] meetings) {
    	if (meetings == null || meetings.length <= 1) {
    		return 0;
    	}
    	Comparator<Point> comp = new Comparator<Point>() {
    		@Override
    		public int compare(Point p1, Point p2) {
    			if (p1.value == p2.value) {
    				if (p1.isBegin && !p2.isBegin) { //if at one position, there are both "begin" and "end" point
    					return 1;					// always put "end" point before;
    				}
    				if (!p1.isBegin && p2.isBegin) {
    					return -1;
    				}
    				
    			}
    			return p1.value - p2.value;
    		}
    	};
    	int count = 0;
    	int max = 0;
    	ArrayList<Point> points = new ArrayList<Point>();
    	for (Interval i : meetings) {
    		Point p1 = new Point(i.begin, true);
    		Point p2 = new Point(i.end, false);
    		points.add(p1);
    		points.add(p2);
    	}
    	Collections.sort(points, comp);
    	for (Point p : points) {
    		count = p.isBegin ? count + 1 : count - 1;
    		max = Math.max(max, count);
    	}
    	return max;
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

class Point {
	public int value;
	public boolean isBegin; 
    public Point(int val, boolean isB) {
        value = val;
        isBegin = isB;
    }
}
