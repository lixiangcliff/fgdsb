package Smallest_Character;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * Given a sorted character array and a character, 
	 * return the smallest character that is strictly larger than the search character.
	 * If no such character exists, return the smallest character in the array.
	 * For example:

		Input: ['c', 'f', 'j', 'p', 'v'], 'a' 
		Output: 'c'
		
		Input: ['c', 'f', 'j', 'p', 'v'], 'c' 
		Output: 'f'
		
		Input: ['c', 'f', 'j', 'p', 'v'], 'z' 
		Output: 'c'
		
		Input: ['c', 'c', 'k'], 'f' 
		Output: 'k'
	 */
	
	//binary search
    public char smallest_character(String str, char c) {
    	if (str == null || str.length() == 0) {
    		return ' ';
    	}
    	int l = 0;
    	int r = str.length() - 1;
    	while (l + 1 < r) {
    		int m = l + (r - l) / 2;
    		if (str.charAt(m) > c) {
    			r = m;
    		} else {
    			l = m;
    		}
    	}
    	if (str.charAt(l) > c) {
    		return str.charAt(l);
    	}
    	if (str.charAt(r) > c) {
    		return str.charAt(r);
    	}
    	return str.charAt(0);
    }

}
