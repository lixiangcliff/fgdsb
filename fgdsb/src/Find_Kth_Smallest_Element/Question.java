package Find_Kth_Smallest_Element;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxHeap mah = new MaxHeap(4);
		//mah.printHeap();
		mah.insert(2);
		//mah.printHeap();
		mah.insert(3);
		//mah.printHeap();
		mah.insert(6);
		//mah.printHeap();
		mah.insert(4);
		//mah.printHeap();
		mah.insert(1);
		//mah.printHeap();
		int[] arr = {6,4,1,2,5,3,8,9,7};
		int k = 6;
		Question q = new Question();
		System.out.println(q.kth_element(arr, k));
		
		
	}
	
	/**
	 * Find the k-th (zero-based) smallest element in an unordered array.
	 * Can you provide an O(N) solution?
	 */
	//zero-based, 计数从0开始
	//quick selection
	//http://stackoverflow.com/questions/10846482/quickselect-algorithm-understanding
	// 三数中值分割法 http://www.cppblog.com/liyuxia713/archive/2009/04/22/80749.html
    public int kth_element(int[] arr, int k) {
    	if (arr == null || arr.length < k - 1) {
    		return Integer.MAX_VALUE;
    	}
    	MaxHeap mah = new MaxHeap(k);
    	for (int num : arr) {
    		mah.insert(num);
    	}
    	return mah.getRoot();
    }
    
    private int getK(int[] arr, int l, int r) {
    	return 0;
    }
}

class MaxHeap {
	private int count;
	private int[] arr;
	
	public MaxHeap(int cap) {
		count = 0;
		arr = new int[cap];
	}
	
	private void build(int a) {
		arr[count] = a;
		int pos = count;
		count++;
		if (pos == 0) {
			return;
		}
		while ((pos - 1) / 2 >= 0) {
			if (arr[pos] > arr[(pos - 1) / 2]) {
				swap(arr, pos, (pos - 1) / 2);
				pos = (pos - 1) / 2;
			} else {
				return;
			}
			if (pos == 0) {
				return;
			}
		}
	}
	
	public int getRoot() {
		return arr[0];
	}
	
	public void insert(int a) {
		if (count < arr.length) {
			build(a);
			return;
		}
		if (a >= arr[0]) {
			return;
		}
		arr[0] = a;
		int pos = 0;
		int len = arr.length;
		while (pos < len) {
			boolean isMax = false;
			if (2 * pos + 1 >= len) {
				isMax = true;
			} else if (arr[pos] >= arr[pos * 2 + 1]) {
				if (2 * pos + 2 >= len || arr[pos] >= arr[pos * 2 + 2]) {
					isMax = true;
				}
			}
			if (isMax) {
				return;
			}
			int maxIdx = -1;
			if (2 * pos + 2 < len) {
				maxIdx = arr[2 * pos + 1] >= arr[2 * pos + 2] ? 2 * pos + 1 : 2 * pos + 2;
			} else {
				maxIdx = 2 * pos + 1; 
			}
			swap(arr, pos, maxIdx);
			pos = maxIdx;
		}
		return;
	}
	
	private void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		return;
	}
	
	public void printHeap() {
		System.out.println("******heap start******");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + ",");
			if (((i + 2) & (i + 1)) == 0 || i == arr.length - 1) {
				System.out.println();
			}
		} 
		System.out.println("******heap end******");
	}
}