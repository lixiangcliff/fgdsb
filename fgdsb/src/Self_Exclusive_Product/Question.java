package Self_Exclusive_Product;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given an array A, write a function to calculate an array B, where
	 * B[i] = A[0] * A[1] * ... * A[i - 1] * A[i + 1] * ... * A[n-1]
	 * 
	 * Examples:
	 * A[] = [2, 3, 4, 5]
	 * B[] = [60, 40, 30, 24]
	 * 
	 * Note: DO NOT use division in your solution.
	 */
	
	//http://www.fgdsb.com/2015/01/13/get-prod-array-without-div/
    public int[] product(int[] a) {
    	if (a == null || a.length == 0) {
    		return null;
    	}
    	int len = a.length;
    	int[] b = new int[len];
    	int left = a[0];
    	for (int i = 1; i < len; i++) {
    		b[i] = left;
    		left *= a[i];
    	}
    	int right = a[len - 1];
    	b[0] = 1;
    	for (int i = len - 2; i >= 0; i--) {
    		b[i] *= right;
    		right *= a[i];
    	}
    	return b;
    }
}
