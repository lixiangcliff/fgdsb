package Find_Subarray_with_Given_Sum_II;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2, 8, 5, -7};
		int t = 10;
		Question q = new Question();
		System.out.println(q.subarray_sum(arr, t));

	}
	
	/**
	 * Follow up for "Find Subarray with Given Sum": 
	 * If the input array contains negative numbers?
	 */
	
	//O(n) time and O(n) space
	//http://stackoverflow.com/questions/14948258/given-an-input-array-find-all-subarrays-with-given-sum-k
	//http://www.geeksforgeeks.org/find-subarray-with-given-sum/
    public boolean subarray_sum(int[] array, int t) {
        if (array == null ) {
     	   return false;
        }
        int len = array.length;
        if (len == 0) {
     	   return t == 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>(); //<sum, index>
        map.put(0, -1);
        int sum = 0; 
        for (int i = 0; i < len; i++) {
        	sum = array[i] + sum;
        	map.put(sum, i);
        }
/*      Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
        	Map.Entry entry =  (Entry) it.next();
        	int curSum = (Integer) entry.getKey();
        	int curIdx = (Integer) entry.getValue();
        	if (map.containsKey(curSum - t) && map.get(curSum - t) < curIdx) {
        		return true;
        	}
        }*/
        
        //same as iterator, but fgdsb will not compile for iterating map
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
        	int curSum = (Integer) entry.getKey();
        	int curIdx = (Integer) entry.getValue();
        	if (map.containsKey(curSum - t) && map.get(curSum - t) < curIdx) {
        		return true;
        	}
        }
        return false;
    }

}
