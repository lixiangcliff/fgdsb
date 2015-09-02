package Compress_String;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question q = new Question();
		String str = "aabcccccaaa";
		System.out.println(q.compress(str));
	}
	
	/**
	 * Implement a function to perform basic string compression using the counts of repeated characters.
	 * For example, the string aabcccccaaa would become a2b1c5a3.
	 * If the compressed string would not become smaller than the original string, you should return the original one.
	 */
	
    public String compress(String str) {
    	if (str == null || str.length()  <= 1) {
    		return str;
    	}
    	StringBuilder sb = new StringBuilder();
    	int preIdx = 0;
    	for (int i = 1; i <= str.length(); i++) {
    		if (i != str.length() && str.charAt(i) == str.charAt(preIdx)) {
    			continue;
    		}
    		sb.append(str.charAt(preIdx)).append(i - preIdx);
    		preIdx = i;
    	}
    	return sb.length() < str.length() ? sb.toString() : str;
    }

}
