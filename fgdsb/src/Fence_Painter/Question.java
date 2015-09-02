package Fence_Painter;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Write an algorithm that counts the number of ways you can paint a fence with N posts using K colors 
	 * such that no more than 2 adjacent fence posts are painted with the same color.
	 */
	
	//Zhe's method
	//twoSame[i] 在位置i，并且第i-1位和第i位颜色相同的方案总数
	//twoDiff[i] 在位置i，并且第i-1位和第i位颜色不同的方案总数
    public int num_colors(int n, int k) {
    	if (n < 1 || k < 1 || n > 2 && k == 1) {
    		return 0;
    	}
    	if (n == 1) {
    		return k;
    	}
    	int[] twoSame = new int[n];
    	int[] twoDiff = new int[n];
    	twoSame[1] = k * 1;
    	twoDiff[1] = k * (k - 1);
    	for (int i = 2; i < n; i++) {
    		twoSame[i] = twoDiff[i - 1];
    		twoDiff[i] = (k - 1) * twoSame[i - 1] + (k - 1) * twoDiff[i - 1];
    	}
    	return twoSame[n - 1] + twoDiff[n - 1];
    }

}
