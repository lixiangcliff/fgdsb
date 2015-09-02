package Hamming_Distance;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Write a function to calculate Hamming distance between two integers.
	 * Hamming distance between two numbers is the number of positions at which the corresponding digits are different. 
	 * Examples:

		The Hamming distance between:
		
		2173896 and 2233796 is 3.
		100 and (0)10 is 2.
	 */
	
    public int hamming(int a , int b) {
    	a = Math.abs(a);
    	b = Math.abs(b);
    	int count = 0;
    	while (a != 0 || b != 0) {
    		if (a % 10 != b % 10) {
    			count++;
    		}
    		a /= 10;
    		b /= 10;
    	}
    	return count;
    }

}
