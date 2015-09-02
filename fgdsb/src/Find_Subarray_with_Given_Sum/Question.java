package Find_Subarray_with_Given_Sum;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 3, 5, 23, 2};
		int t = 7;
		Question q = new Question();
		System.out.println(q.subarray_sum(arr, t));
	}
	
	/**
	 * Given a sequence of positive integers A and an integer T, 
	 * return whether there is a continuous sequence of A that sums up to exactly T.

		Examples:
		
		[23, 5, 4, 7, 2, 11], 20 => true because 7 + 2 + 11 = 20 
		[1, 3, 5, 23, 2], 8 => true because 3 + 5 = 8 
		[1, 3, 5, 23, 2], 7 => false because no sequence in this array adds up to 7
	 */
	
    public boolean subarray_sum(int[] array, int t) {
       if (array == null ) {
    	   return false;
       }
       if (array.length == 0) {
    	   return t == 0;
       }
       int sum = 0;
       int l = 0;
       int r = 0;
       while (r < array.length) {
    	   if (sum == t) {
    		   return true;
    	   }
    	   while (sum < t && r < array.length) {
    		   sum += array[r];
    		   r++;
    	   }
    	   while (sum > t && l < r) {
    		   sum -= array[l];
    		   l++;
    	   }
       }
       return sum == t;
    }

}
