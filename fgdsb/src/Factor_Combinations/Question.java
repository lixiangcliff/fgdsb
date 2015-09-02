package Factor_Combinations;

import java.util.ArrayList;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 15;
		Question q = new Question();
		
		List<List<Integer>> result = q.factors_combinations(n);
		System.out.println("size: " + result.size());
		for (int i = 0; i < result.size(); i++) {
			ArrayList<Integer> item = (ArrayList<Integer>) result.get(i);
			for (int j = 0; j < item.size(); j++) {
				System.out.print(item.get(j)+ ",");
			}
			System.out.println("");
		}
	}
	
	/**
	 * Print all unique combination of factors (except 1) of a given number.
	 * For example:
	 * Input:    12
	 * Output: [[2, 2, 3], [2, 6], [3, 4]]
	 * Input:    15
	 * Output: [[3, 5]]
	 * Input:    28
	 * Output: [[2, 2, 7], [2, 14], [4, 7]]
	 */
	
    public List<List<Integer>> factors_combinations(int n) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if ( n <= 1) {
    		return res;
    	}
    	List<Integer> item = new ArrayList<Integer>();
    	int factor = 2;
    	helper(res, item, n, factor);
    	return res;
    }
    
	//dfs
    private void helper(List<List<Integer>> res, List<Integer> item, int n, int factor) {
    	if (n == 1) {
    		if (item.size() != 1) { //rule out item that has content of "n"
    			res.add(new ArrayList<Integer>(item));
    		}
    		return;
    	}
    	for (int i = factor; i <= n; i++) {
    		if (n % i == 0) {
    			item.add(i);
    			helper(res, item, n / i, i);
    			item.remove(item.size() - 1);
    		}
    	}
    }
	

}
