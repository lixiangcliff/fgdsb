package Second_Largest_Number;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Find the second largest number in a given array.
	 * Return 0 if the given array has no second largest number.
	 */
	
    public int second_largest(int[] arr) {
    	if (arr == null || arr.length <= 1) {
    		return 0;
    	}
    	int max = arr[0];
    	int sec = Integer.MIN_VALUE;
    	for (int i = 1; i < arr.length; i++) {
    	    if (arr[i] == max) {
    	        continue;
    	    } else if (arr[i] > max) {
    			sec = max;
    			max = arr[i];
    		} else if (arr[i] > sec) {
    			sec = arr[i];
    		}
    	}
    	return sec == Integer.MIN_VALUE ? 0 : sec;
    }
}
