package Coin_Change_Problem_II;

import java.util.Arrays;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {2, 5, 10};
		int target = 10;
		Question q = new Question();
		System.out.println(q.count_changes(coins, target));
	}
	
	/**
	 * Follow up for "Coin Change Problem":
	 * Please write a function and return how many ways can we make the change.
	 */
	
	//same as: combination sum
    public int count_changes(int[] coins, int target) {
    	if (coins == null || coins.length == 0 || target <= 0) {
    		return 0;
    	}
    	Arrays.sort(coins);
    	int pos = 0;
    	int[] ways = {0};
    	helper(coins, ways, pos, target);
    	return ways[0];
    }
    
    private void helper(int[] coins, int[] ways, int pos, int target) {
    	if (target == 0) {
    		ways[0]++;
    	}
    	if (target < coins[pos]) {
    		return;
    	}
    	for (int i = pos; i < coins.length; i++) {
    		if (i > pos && coins[i - 1] == coins[i]) {
    			continue;
    		}
    		helper(coins, ways, i, target - coins[i]);
    	}
    }
    
    

}
