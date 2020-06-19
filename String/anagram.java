/*Check wheter two string is anagram or not using HashMap.TC: O(N) 
A optimized solution that store only character and I have also done it in the way,
that it can even check for string having more than one word in it  */

import java.util.*;

class anagram{

	static Boolean isAnagram(String str1, String str2){
		HashMap<Character,Integer> h1 = new HashMap<Character,Integer>();
		HashMap<Character,Integer> h2 = new HashMap<Character,Integer>();

		if(str1.length() != str2.length()){
			return false;
		}

		for(int i=0; i < str1.length(); i++){
			if(h1.containsKey(str1.charAt(i))){
				h1.put(str1.charAt(i),h1.get(str1.charAt(i) + 1));
			}
			else{
				h1.put(str1.charAt(i),1);
			}
			if(h2.containsKey(str2.charAt(i))){
				h2.put(str2.charAt(i),h2.get(str2.charAt(i) + 1));
			}
			else{
				h2.put(str2.charAt(i),1);
			}
		}

		for(int i=0; i < str1.length(); i++){
			if(h1.get(str1.charAt(i)) == h2.get(str1.charAt(i))){
			}
			else{
				return false;
			}
		}

		return true;
	}


	public static void main(String[] args) {
		String str1, str2;
		Scanner sc = new Scanner(System.in);

		str1 = sc.nextLine();
		str2 = sc.nextLine();

		Boolean result = isAnagram(str1,str2);
		System.out.println("String are anagram? Answer: " + result);
	}
}