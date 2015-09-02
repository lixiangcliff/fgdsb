package Wiggle_Sort;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Write a function to convert the array into alternate increasing decreasing numbers:
		a[0] <= a[1] >= a[2] <= a[3] >=...
		Note: You should solve it in place and one pas
	 */
	
    public void wiggle_sort(int[] arr) {
    	if (arr == null || arr.length == 1) {
    		return;
    	}
    	boolean isPeak = true;
    	int i = 1;
    	for (; i < arr.length - 1 ; i += 2) {
    		swap(arr, i);
    	}
    	if (i == arr.length - 1) {
    		if (arr[i] < arr[i - 1]) {
    			int temp = arr[i];
    			arr[i] = arr[i - 1];
    			arr[i - 1] = temp;
    		}
    	}
    	return;
    }
    
    private void swap(int[] arr, int i) {
    	if (i - 1 < 0 || i + 1 > arr.length) {
    		return;
    	}
    	int maxIdx = -1;
    	if (arr[i - 1] >= arr[i] && arr[i - 1] >= arr[i + 1]) {
    		maxIdx = i - 1;
    	} else if (arr[i + 1] >= arr[i] && arr[i + 1] >= arr[i - 1]) {
    		maxIdx = i + 1;
    	} else {
    		maxIdx = i;
    		return;
    	}
    	int temp = arr[i];
    	arr[i] = arr[maxIdx];
    	arr[maxIdx] = temp;
    	return;
    }

}
