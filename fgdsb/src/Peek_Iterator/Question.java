package Peek_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> alist = new ArrayList<Integer>();
		alist.add(1);
		alist.add(2);
		alist.add(3);
		Iterator it = alist.iterator();
		PeekIterator pit = new PeekIterator(it);
		System.out.println(pit.hasNext());
		System.out.println(pit.peek());
		System.out.println(pit.next());
		System.out.println(pit.hasNext());
		System.out.println(pit.peek());
		System.out.println(pit.next());
		System.out.println(pit.peek());
		System.out.println(pit.peek());
		System.out.println(pit.peek());
		System.out.println(pit.next());
		System.out.println(pit.hasNext());
		//System.out.println(pit.peek());
		//System.out.println(pit.next());
/*		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());
		System.out.println(it.next());
		System.out.println(it.hasNext());
		System.out.println(it.next());*/
	}
	
	/**
	 * Suppose you have a Iterator class with has_next() and get_next() methods.
	 * Please design and implement a PeekIterator class as a wrapper of Iterator and provide a peek() method.
	 * When calling peek(), the user will only get the current element without moving forward the iterator.
	 * Note: For Java solution we will use JDK's Iterator class, so the methods would be hasNext() and next().
	 */
	
}

//http://www.fgdsb.com/2015/01/25/peek-iterator/
//http://stackoverflow.com/questions/5849154/can-we-write-our-own-iterator-in-java
//will not compile. should try c++ version according to the answer on Mac
class PeekIterator {
	private Iterator it;
	private ArrayList<Integer> list; // store return value of next()
	
    public PeekIterator(Iterator it) {
    	this.it = it;
    	list = new ArrayList<Integer>(); 
    }
    
    public int peek() {
    	if (list.isEmpty()) {
        	int cur = (Integer) it.next();
        	list.add(cur);
        	return cur;
    	} else {
    		return list.get(0);
    	}
    }
    
    public boolean hasNext() {
    	return it.hasNext() || !list.isEmpty();
    }
    
    public int next() {
    	if (list.isEmpty()) {
    		return (Integer) it.next();
    	} else {
    	    int cur = list.get(0);
	    	list.remove(0);
	    	return cur;
    	}
    }
}
