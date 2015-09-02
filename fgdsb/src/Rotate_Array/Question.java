package Rotate_Array;



public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + ",");
		}
		System.out.print("===========");
		Question q = new Question();
		q.rotate_array(arr, 3);
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i] + ",");
		}
	}
	
	/**
	 * Write a function to rotate a given array by k places.
	 * Note: Your solution must be in-place and in linear time.
	 */
	
	//same as http://lintcode.com/en/problem/recover-rotated-sorted-array/
    public void rotate_array(int[] arr, int k) {
    	k %= arr.length;
    	reverse(arr, 0, arr.length - k - 1);
    	reverse(arr, arr.length - k, arr.length - 1);
    	reverse(arr, 0, arr.length - 1);
    }
    
    private void reverse (int[] arr, int start, int end) {
    	if (start < 0 || end > arr.length - 1){
    		return;
    	}
    	while (start < end) {
    		int temp = arr[start];
    		arr[start] = arr[end];
    		arr[end] = temp;
    		start++;
    		end--;
    	}
    	return;
    }

}
