package Search_Sorted_Matrix;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given an M x N matrix, where every row and column is sorted. 
	 * Write an efficient function that searches a number in this matrix.
	 * For example, given matrix:
		
		1, 2, 4
		2, 6, 8
		3, 7, 9
		The result of searching 6 is true.
	 */
	
	//same as: http://lintcode.com/en/problem/search-a-2d-matrix-ii/
    public boolean search_mat(int[][] mat, int target) {
    	if (mat == null || mat.length == 0 || mat[0].length == 0) {
    		return false;
    	}
    	int row = mat.length - 1;
    	int col = 0;
    	int count = 0;
    	while (row >= 0 && col <= mat[0].length - 1){
    		if (mat[row][col] == target) {
    			return true;
    		} else if (mat[row][col] < target) {
    			col++;
    		} else {
    			row--;
    		}
    	}
    	return false;
    }

}
