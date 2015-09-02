package Isomorphic_Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Question {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "foo";
		String b = "app";
		Question q = new Question();
		System.out.println(q.is_isomorphic(a, b));
	}
	
	/**
	 * Given two strings, determine if they are isomorphic. 
	 * Two words are called isomorphic if the letters in one word can be remapped to get the second word. 
	 * Remapping a letter means replacing all occurrences of it with another letter while the ordering of the letters remains unchanged. 
	 * No two letters may map to the same letter, but a letter may map to itself.
	 * 
	 * Examples:
	 * 
	 * Given 'foo', 'app', returns true
	 * We can map 'f' -> 'a' and 'o' -> 'p'
	 * 
	 * Given 'bar', 'foo', returns false
	 * We can’t map both 'a' and 'r' to 'o'
	 * 
	 * Given 'turtle', 'tletur', returns true
	 * We can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' -'r'
	 * 
	 * Given 'ab', 'ca', returns true
	 * We can map 'a' -> 'c', 'b' -> 'a'
	 */
	
	//http://www.fgdsb.com/2015/01/14/isomorphic-string/
	//a到b是一一映射，反过来b到a也一样
	 public boolean is_isomorphic(String a, String b) {
		 if (a == null || b == null || a.length() == 0 || b.length() == 0 || a.length() != b.length()) {
	    		return false;
	    	}
		 HashMap<Character, Character> map1 = new HashMap<Character, Character>();
		 HashMap<Character, Character> map2 = new HashMap<Character, Character>();
		 for (int i = 0; i < a.length(); i++) {
			 char achar = a.charAt(i);
			 char bchar = b.charAt(i);
			 if (!map1.containsKey(achar) && !map2.containsKey(bchar)) {
				 map1.put(achar, bchar);
				 map2.put(bchar, achar);
			 } else if (map1.containsKey(achar) && !map2.containsKey(bchar) || !map1.containsKey(achar) && map2.containsKey(bchar)) {
				 return false;
			 } else {
				 if (achar != map2.get(bchar) || bchar != map1.get(achar)) {
					 return false;
				 }
			 }
		 }
		 return true;
	 }
	
	//my method
    public boolean is_isomorphic2(String a, String b) {
    	if (a == null || b == null || a.length() == 0 || b.length() == 0 || a.length() != b.length()) {
    		return false;
    	}
    	HashMap<Character, ArrayList<Integer>> charMap1 = makeCharMap(a);
    	HashMap<Character, ArrayList<Integer>> charMap2 = makeCharMap(b);
    	HashMap<Integer, ArrayList<Integer>> intMap1 = makeIntMap(charMap1);
    	HashMap<Integer, ArrayList<Integer>> intMap2 = makeIntMap(charMap2);
    	Iterator it = intMap1.entrySet().iterator();
    	while (it.hasNext()) {
    		Map.Entry entry = (Entry) it.next();
    		int key = (Integer) entry.getKey();
    		ArrayList<Integer> item = (ArrayList<Integer>) entry.getValue();
    		if (!intMap2.containsKey(key)) {
    			return false;
    		}
    		if (!item.equals(intMap2.get(key))) {
    			return false;
    		}
    	}
    	return true;
    }

	private HashMap<Character, ArrayList<Integer>> makeCharMap(String str) {
		HashMap<Character, ArrayList<Integer>> map = new HashMap<Character, ArrayList<Integer>>();
    	for (int i = 0; i < str.length(); i++) {
    		char c = str.charAt(i);
    		if (map.containsKey(c)) {
    			map.get(c).add(i);
    		} else {
    			ArrayList<Integer> item = new ArrayList<Integer>();
    			item.add(i);
    			map.put(c, item);
    		}
    	}
		return map;
	}
	
	private HashMap<Integer, ArrayList<Integer>> makeIntMap(HashMap<Character, ArrayList<Integer>> charMap1) {
		HashMap<Integer, ArrayList<Integer>> intMap = new HashMap<Integer, ArrayList<Integer>>();
    	Iterator it = charMap1.entrySet().iterator();
    	while (it.hasNext()) {
    		Map.Entry entry = (Entry) it.next();
    		ArrayList<Integer> item = (ArrayList<Integer>) entry.getValue();
    		intMap.put(item.get(0), item);
    	}
    	return intMap;
	}

}
