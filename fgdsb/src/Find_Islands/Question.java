package Find_Islands;

import java.util.LinkedList;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		//char[][] grid = {{'1','0','1','0','1','1'}};
		//char[][] grid = {{'1'},{'0'},{'1'},{'0'},{'1'},{'1'}};
		int[][] mat = {{1,0,1}, {1,0,1}, {1,1,1}};
		System.out.println(q.num_islands(mat));
	}
	
	/**
	 * Given a 2D matrix with 0s and 1s, write a function to count the number of islands.
	 * A group of connected 1s forms an island. For example, the below matrix contains 4 islands

		0011010
		0010010
		1000110
		0000001
	 */

	
	//same as leetcode: Number_of_Islands
    public int num_islands(int[][] mat) {
    	if (mat == null || mat.length == 0 || mat[0].length == 0) {
    		return 0;
    	}
    	int m = mat.length;
    	int n = mat[0].length;
    	boolean[][] used = new boolean[m][n];
    	int res = 0;
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (!used[i][j] && mat[i][j] == 1) {
    				used[i][j] = true;
    				int pos = i * n + j;
    				LinkedList<Integer> queue = new LinkedList<Integer>();
    				queue.offer(pos);
    				while (!queue.isEmpty()) {
    					int size = queue.size();
    					for (int k = 0; k < size; k++) {
    						pos = queue.poll();
    						int row = pos / n;
    						int col = pos % n;
    						if (row > 0 && !used[row - 1][col] && mat[row - 1][col] == 1) {
    							queue.offer(pos - n); //
    							used[row - 1][col] = true;
    						}
    						if (row < m - 1 && !used[row + 1][col] && mat[row + 1][col] == 1) {
    							queue.offer(pos + n);
    							used[row + 1][col] = true;
    						}
    						if (col > 0 && !used[row][col - 1] && mat[row][col - 1] == 1) {
    							queue.offer(pos - 1);
    							used[row][col - 1] = true;
    						}
    						if (col < n - 1 && !used[row][col + 1] && mat[row][col + 1] == 1) {
    							queue.offer(pos + 1);
    							used[row][col + 1] = true;
    						}
    					}
    				}
    				res++;
    			}
    		}
    	}
    	return res;
    }
}
