package Zigzag_Iterator;

import java.util.Iterator;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Suppose you have a Iterator class with has_next() and get_next() methods.
	 * Please design and implement a ZigzagIterator class as a wrapper of two iterators.

		For example, given two iterators:
		i0 = [1,2,3,4]
		i1 = [5,6]
		ZigzagIterator it(i0, i1);
		
		while(it.has_next()) {
		    print(it.get_next());
		}
		The output of the above pseudocode would be [1,5,2,6,3,4].
		
		Note: For Java solution we will use JDK's Iterator class, so the methods would be hasNext() and next().
	 */

}

class ZigzagIterator {
	private Iterator i0; 
	private Iterator i1;
	private int count;
    public ZigzagIterator(Iterator i0, Iterator i1) {
    	this.i0 = i0;
    	this.i1 = i1;
    	count = 0;
    }
    
    public boolean has_next() {
    	return i0.hasNext() || i1.hasNext();
    }
    
    public int get_next() {
    	if (i0.hasNext() && i1.hasNext()) {
    		if (count % 2 == 0) {
    			count++;
    			return (Integer) i0.next();
    		} else {
    			count++;
    			return (Integer) i1.next();
    		}
    	}
    	if (i0.hasNext()) {
    		return (Integer) i0.next();
    	}
    	if (i1.hasNext()) {
    		return (Integer) i1.next();
    	}
    	return (Integer) null;
    }
}
