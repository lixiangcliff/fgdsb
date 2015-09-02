package Maximum_Sum_of_Non_consecutive_Elements;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given an array of whose elements are positive numbers. Find the maximum sum of a subsequence with all the constraint that 
	 * no two numbers in the sequence should be adjacent in the array.
	 * 
	 * For example:
	 * 
	 * [3, 2, 7, 10] should return 3 + 10 = 13.
	 * [3, 2, 5, 10, 7] should return 3 + 5 +7 = 15.
	 * [1, 5, 4, 3, 2] should return 5 + 3 + 8.
	 */
	
	//same as leetcode: house robbery
    public int max_values(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	int len = nums.length;
    	if (len == 1) {
    		return nums[0];
    	}
    	if (len == 2) {
    		return Math.max(nums[0], nums[1]);
    	}
    	int[] res = new int[len];
    	res[0] = nums[0];
    	res[1] = Math.max(nums[0], nums[1]);
    	for (int i = 2; i < len; i++) {
    		res[i] = Math.max(res[i - 1], res[i - 2] + nums[i]);
    	}
    	return res[len - 1];
    }
	

}
