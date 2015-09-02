package Find_Three_Increasing_Numbers;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] nums = {4,7,5,1,3,8,9,6,2};
		System.out.println(q.three_increasing_nums(nums)[0]);
		System.out.println(q.three_increasing_nums(nums)[1]);
		System.out.println(q.three_increasing_nums(nums)[2]);

	}
	
	/**
	 * Given an array find 3 elements such that a[i] < a[j] < a[k] and i < j < k in O(N) time.
	 * Your function should return indices of the three numbers. 
	 * There might be multiple increasing subsequences, you only need to return any of them. Return [-1,-1,-1] if no result can be found.
	 */
	
	//http://www.fgdsb.com/2015/01/03/find-three-increasing-subsequence/
    public int[] three_increasing_nums(int[] nums) {
    	int[] res = {-1, -1, -1};
    	if (nums == null || nums.length < 3) {
    		return res;
    	}
    	int len = nums.length;
    	int[] leftMinIdx = new int[len];
    	int[] rightMaxIdx = new int[len];
    	leftMinIdx[0] = 0;
    	for (int i = 1; i < len; i++) {
    		if (nums[i] < nums[leftMinIdx[i - 1]]) {
    			leftMinIdx[i] = i;
    		} else {
    			leftMinIdx[i] = leftMinIdx[i - 1];
    		}
    	}
/*    	for (int num : leftMinIdx) {
    		System.out.print(num + ",");
    	}*/
    	rightMaxIdx[len - 1] = len - 1;
    	for (int i = len - 2; i >= 0; i--) {
    		if (nums[i] > nums[rightMaxIdx[i + 1]]) {
    			rightMaxIdx[i] = i;
    		} else {
    			rightMaxIdx[i] = rightMaxIdx[i + 1];
    		}
    	}
/*    	for (int num : rightMaxIdx) {
    		System.out.print(num + ",");
    	}*/
    	for (int i = 0; i < len; i++) {
    		if (nums[leftMinIdx[i]] < nums[i] && nums[i] < nums[rightMaxIdx[i]]) {
    			res[0] = leftMinIdx[i];
    			res[1] = i;
    			res[2] = rightMaxIdx[i];
    			return res;
    		}
    	}
    	return res;
    }

}
