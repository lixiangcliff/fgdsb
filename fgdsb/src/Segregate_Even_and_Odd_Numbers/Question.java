package Segregate_Even_and_Odd_Numbers;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {12, 34, 45, 9, 8, 90, 3};
		for (int num : arr) {
			System.out.print(num + ",");
		}
		System.out.println("");
		Question q = new Question();
		q.segregate(arr);
		for (int num : arr) {
			System.out.print(num + ",");
		}
		System.out.println("");

	}
	
	/**
	 * Given an array, write a function that segregates even and odd numbers. The functions should put all even numbers first, and then odd numbers. 
	 * Example:
	 * Input = [12, 34, 45, 9, 8, 90, 3]
	 * Output = [12, 34, 8, 90, 45, 9, 3]
	 */
	
    public void segregate(int[] arr) {
    	if (arr == null || arr.length < 2) {
    		return;
    	}
    	int len = arr.length;
    	int l = 0;
    	int r = len - 1;
    	while (l < r) {
    		while (arr[l] % 2 == 0) {
    			if (l < r) {
    				l++;
    			} else {
    				return;
    			}
    		}
    		while (arr[r] % 2 == 1) {
    			if (l < r) {
    				r--;
    			} else {
    				return;
    			}
    		} 
    		int temp = arr[l];
    		arr[l] = arr[r];
    		arr[r] = temp;
    	}
    	return;
    }

}
