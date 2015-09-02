package Intersection_of_Two_Sorted_Arrays;

import java.util.ArrayList;
import java.util.List;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Find the intersection of two sorted arrays.
	 * For example: the intersection of [1,2,3,4] and [1,3,5,7] is [1,3].
	 */
	
	//http://www.fgdsb.com/2015/01/03/finding-intersection-of-two-sorted-arrays/
    public List<Integer> intersection(int[] a, int[] b) {
    	List<Integer> res = new ArrayList<Integer>();
    	if (a == null || b == null) {
    		return res;
    	}
    	int i1 = 0;
    	int i2 = 0;
    	int len1 = a.length;
    	int len2 = b.length;
    	while (i1 < len1 && i2 < len2) {
    		if (a[i1] > b[i2]) {
    			i2++;
    		} else if (a[i1] < b[i2]) {
    			i1++;
    		} else {
    			if (res.isEmpty() || res.get(res.size() - 1) != a[i1]) { // 去重
    				res.add(a[i1]);
    			}
    			i1++;
    			i2++;
    		}
    	}
    	return res;
    }

}
