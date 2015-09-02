package Two_Difference;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Given an sorted array and find two numbers in the array having difference equal to given number.
	 * Your function should return indices of the two numbers. 
	 * If there are multiple pairs, just return any of them. Return [-1,-1] if no result can be found. 
	 * You may assume that the input array has no duplicates.
	 */
	
	//two pointer, sliding window
	//http://www.fgdsb.com/2015/01/06/two-difference/
    public int[] two_dif(int[] A, int target) {
    	int[] res = {-1, -1};
    	if (A == null || A.length == 0 || target == 0) {
    		return res;
    	}
    	target = Math.abs(target);
    	int len = A.length;
    	int p1 = 0;
    	int p2 = 1;
    	while (p1 < len && p2 < len) {
    		if (A[p2] - A[p1] == target) {
    			res[0] = p1;
    			res[1] = p2;
    			return res;
    		} else if (A[p2] - A[p1] > target) {
    			p1++;
    		} else {
    			p2++;
    		}
    		if (p1 == p2) {
    			p2++;
    		}
    	}
    	return res;
    }
}
