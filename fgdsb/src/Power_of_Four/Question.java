package Power_of_Four;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Write a program to check if a 32-bit integer is a power of 4.
	 * Try to solve this problem with different approaches.
	 */
	//1.hashMap
	
	//2.bit shifting
	//1		00000001	1在第0位
	//4		00000100	1在第2位
	//16	00010000	1在第4位
	//32	01000000	1在第6位
	//即奇数位不可以有1，1010 == A 
	public boolean power_of_4(int number) {
    	if (number <= 0){
    		return false;
    	}
    	return (number & 0xAAAAAAAA) == 0 && (number & (number - 1)) == 0; //(number & (number - 1))判断一个数是不是2的n次幂的技巧
    }
	
	
	//3. naive way
    public boolean power_of_4_naive(int number) {
    	if (number <= 0){
    		return false;
    	}
    	while (number > 1) {
    		if (number % 4 != 0) {
    			return false;
    		}
    		number /= 4;
    	}
    	return true;
    }

}
