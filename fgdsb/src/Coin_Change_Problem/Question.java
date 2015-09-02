package Coin_Change_Problem;

import java.util.Arrays;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] coins = {1, 2, 5, 10};
		int target = 1;
		Question q = new Question();
		System.out.println(q.min_coins(coins, target));
	}
	
	/**
	 * Given a set of currency denominations, find the minimum number of coins needed to represent an amount.
	 * Return 0 if you can't use your coins to represent the target amount.
	 * For example:
	 * Suppose you have two kinds of coins: 1, 2. In order to represent 3, you have two options:
	 * 1 + 1 + 1 = 3 or
	 * 
	 * 1 + 2 = 3
	 * So the minimum number of coins is 2.
	 */
	
	//not sure it is the simplest way..
    public int min_coins(int[] coins, int target) {
    	if (coins == null || coins.length == 0 || target <= 0) {
    		return 0;
    	}
    	
    	//there is sth wrong in fgdsb's test case. it miss '1' in "coins". below lines need to be added to pass the OJ
/*    	if (coins.length > 1) {
    	    int[] coins2 = new int[coins.length + 1];
    	    for (int i = 0; i < coins.length; i++) {
    	        coins2[i] = coins[i];
    	    }
    	    coins2[coins.length] = 1;
    	    coins = coins2;
    	}*/
    	
    	Arrays.sort(coins);
    	int pos = 0;
    	int[] min = {Integer.MAX_VALUE};
    	int count = 0;
    	helper(coins, min, pos, target, count);
    	return min[0] == Integer.MAX_VALUE ? 0 : min[0];
    }
    
    private void helper(int[] coins, int[] min, int pos, int target, int count) {
    	if (target == 0) {
    		min[0] = Math.min(count, min[0]);
    	}
    	if (target < coins[pos]) {
    		return;
    	}
    	for (int i = pos; i < coins.length; i++) {
    		if (i > pos && coins[i - 1] == coins[i]) {
    			continue;
    		}
    		helper(coins, min, i, target - coins[i], count + 1);
    	}
    }

}
