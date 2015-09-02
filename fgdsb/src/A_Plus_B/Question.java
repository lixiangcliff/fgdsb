package A_Plus_B;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		System.out.println(q.plus_num(14545, 4546));
	}
	
	/**
	 * Write a function to calculate A + B without using + - / * %.
		Note: A and B are both 32-bit nonnegative integers, the output is guaranteed not to overflow.
	 */
	
    public int plus_num(int a, int b) {
    	int res = 0;
    	int carry = 0;
    	for (int i = 0; i < 32; i++) {
    		int aBit = (a >> i) & 1;
    		int bBit = (b >> i) & 1;
    		int carryTemp = aBit == 1 && bBit == 1 ? 1 : 0;
    		int sumTemp = (aBit ^ bBit) == 1 ? 1 : 0;
    		int sum = (carry ^ sumTemp) == 1 ? 1 : 0;
    		carry = carryTemp == 1 || (carry == 1 && sumTemp == 1) ? 1 : 0;
    		res ^= (sum << i);
    	}
    	return res; 
    }

}
