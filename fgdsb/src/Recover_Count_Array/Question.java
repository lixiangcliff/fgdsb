package Recover_Count_Array;

import java.util.ArrayList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] arr = {3, 0, 1, 0};
		int[] orig = q.recover(arr);
		for (int i : orig) {
    		System.out.print(i + ",");
    	}
	}
	
	/**
	 * Given a random permutation of [1,n] as the original array, we can easily construct a count array using the following rule:
	 * counts[i] = number of element which is smaller than original[i] from original[i+1] to original[n-1].

		For example:
		Original array is original = [4, 1, 3, 2]
		For original[0], there are 3 elements smaller than it from the right, so counts[0] should be 3.
		For original[1], there is no element smaller than it from the right, so counts[1] should be 0.
		For original[2], there is only 1 element smaller than it from the right, so counts[2] should be 1.
		For original[3], there is no elements smaller than it from the right, so counts[3] should be 0.
		Thus the count array is: [3, 0, 1, 0]
		
		Now given the count array, please write a function to recover the original array.
	 */
	
	
    public int[] recover(int[] arr) {
    	if (arr == null || arr.length == 0) {
    		return null;
    	}
    	int[] orig = new int[arr.length];
    	ArrayList<Integer> alist = new ArrayList<Integer>();
    	for (int i = 1; i <= arr.length; i++) {
    		alist.add(i);
    	}
    	for (int i = 0; i < arr.length; i++) {
    		int pos = arr[i];
    		orig[i] = alist.get(pos);
        	alist.remove(pos);
    	}
    	return orig;
    }

}
