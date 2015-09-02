package Ugly_Number;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.kth_ugly_number(7));
	}
	/**
	 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
	 * The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, … shows the first 10 ugly numbers. By convention, 1 is included.
	 * Please write a function to calculate the k-th (one-based) ugly number.
	 */
	
	//http://www.geeksforgeeks.org/ugly-numbers/
	//http://stackoverflow.com/questions/4600048/nth-ugly-number
	//DP
    public int kth_ugly_number(int k) {
    	if (k < 1) {
    		return 0;
    	}
    	int[] res = new int[k + 1];
    	res[1] = 1;
    	int last2 = 1; // last2表示当前res[i]左边的某个位置，对于此位置上的数，再乘以2就会比res[i-1]大的最大的值最小的那个位置
    	int last3 = 1;
    	int last5 = 1;
    	for (int i = 2; i <= k; i++) {
    		while (res[last2] * 2 <= res[i - 1]) {
    			last2++;
    		}
    		while (res[last3] * 3 <= res[i - 1]) {
    			last3++;
    		}
    		while (res[last5] * 5 <= res[i - 1]) {
    			last5++;
    		}
    		res[i] = Math.min(Math.min(res[last2] * 2, res[last3] * 3), res[last5] * 5);
    	}
    	return res[k];
    }

}
