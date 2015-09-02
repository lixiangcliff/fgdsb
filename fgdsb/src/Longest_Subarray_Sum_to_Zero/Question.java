package Longest_Subarray_Sum_to_Zero;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		int[] arr = {5, -9, 2, 7, 1, 2, 10, -6, -4, 6, 4, 6, 2, -1, -9, 5, 0};
		List<Integer> res = q.longest_subarray(arr);
		for (int num : res) {
			//System.out.print(num + ",");
		}

	}
	
	/**
	 * Given an integer array, find the longest contiguous subarray that sum up to zero.
	 * For example:
	 * Input: [1, 2, -3, 1, 5, -5, 6]
	 * Output: [2, -3, 1, 5, -5]
	 */
	
	//http://www.fgdsb.com/2015/01/10/find-longest-contiguous-subarray-sum-to-zero/
	//从头开始加，把直到每个位置的sum加入map（map<sum, index>），如果在位置i出发现cursum在map中存在，则表明从map[sum] + 1 到 i - 1之间连续subarray加和等于零。
    public List<Integer> longest_subarray(int[] arr) {
    	List<Integer> res = new ArrayList<Integer>();
    	if (arr == null || arr.length == 0) {
    		return res;
    	}
    	int sum = 0;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(0, -1); //【注】相当于一个都不取的时候，sum也是0
    	int left = -1; // subarray's leftMost index
    	int right = -1; // subarray's rightMost index
    	int len = 0;
    	for (int i = 0; i < arr.length; i++) {
    		int curSum = sum + arr[i];
    		System.out.print(curSum + ",");
    		if (map.containsKey(curSum)) {
    			if (i - map.get(curSum) > len) {
    				left = map.get(curSum) + 1;
    				right = i;
    				len = right - left;
    			} 
    		} else {
				map.put(curSum, i);
			}
    		sum = curSum;
    	}
    	if (left != -1) {
    		for (int i = left; i <= right; i++) {
    			res.add(arr[i]);
    		}
    	}
    	return res;
    }

}
