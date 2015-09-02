package Maximum_Sum_Rectangle;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = {{1,   2,  -1,  -4, -20},
				{-8,  -3,   4,   2,   1},
				 {3,   8,  10,   1,   3},
				{-4,  -1,   1,   7,  -6}};
		Question q = new Question();
		System.out.print(q.max_sum_rect(mat));
	}
	
	/**
	 * Given a 2D array, find the maximum sum subarray in it.
	 * For example, given a mat:

		 1,   2,  -1,  -4, -20
		-8,  -3,   4,   2,   1
		 3,   8,  10,   1,   3
		-4,  -1,   1,   7,  -6
		
		The result is 29.
	 */
	
    //DP
	//http://www.fgdsb.com/2015/02/16/maximum-sum-rectangle-in-mat/
    public int max_sum_rect(int[][] mat) {
    	if (mat == null || mat.length == 0 || mat[0].length == 0) {
    		return 0;
    	}
    	int row = mat.length;
    	int col = mat[0].length;
    	int max = 0; // not Integer.MIN_VALUE, because you can make the edge of rectangle to be zero if all element is negative
    	for (int up = 0; up < row; up++) {
    		for (int down = up; down < row; down++) {
    			int[] nums = new int[col];
    			for (int i = up; i <= down; i++) {
    				for (int j = 0; j < col; j++) {
    					nums[j] += mat[i][j];
    				}
    			}
    			int[] res = new int[col + 1]; // first i element and must end by i,
    			res[0] = 0;
    			int localMax = 0;
    			for (int i = 1; i <= col; i++) {
    				if (res[i - 1] < 0) {
    					res[i] = nums[i - 1];
    				} else {
    					res[i] = res[i - 1] + nums[i - 1];
    				}
    				localMax = Math.max(localMax, res[i]);
    			} 
    			max = Math.max(localMax, max);
    		}
    	}
		return max;
    }
	
	//brutal force
    public int max_sum_rect2(int[][] mat) {
    	if (mat == null || mat.length == 0 || mat[0].length == 0) {
    		return 0;
    	}
    	int row = mat.length;
    	int col = mat[0].length;
    	int max = 0; // not Integer.MIN_VALUE, because you can make the edge of rectangle to be zero if all element is negative
    	for (int up = 0; up < row; up++) {
    		for (int down = up; down < row; down++) {
    			for (int left = 0; left < col; left++) {
    	    		for (int right = left; right < col; right++) {
    	    			int sum = 0;
    	    			for (int i = up; i <= down; i++) {
    	    	    		for (int j = left; j <= right; j++) {
    	    	    			sum += mat[i][j];
    	    	    		}
    	    	    	}
    	    			max = Math.max(sum, max);
    	    		}
    	    	}
    		}
    	}
		return max;
    }
    


    
}
