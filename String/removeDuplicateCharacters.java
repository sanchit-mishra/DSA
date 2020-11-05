/* Using HashMap store distinct character as Key and lookup Operation is constant time.
TC: O(N).*/

import java.util.*;

class removeDuplicateCharacters{

	static String remove(String str){

		String newStr = "";
		HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
		if(str.length() == 0){
			return " ";
		}

		for(int i=0; i < str.length(); i++){
			if(hmap.containsKey(str.charAt(i))){
				hmap.put(str.charAt(i),hmap.get(str.charAt(i)) + 1);
			}
			else{
				hmap.put(str.charAt(i),1);
			}
		}

		for(Map.Entry mp : hmap.entrySet()){
			newStr += mp.getKey();
		}
		return newStr;
	}

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		String result = remove(str);
		System.out.println("Distinct Character String:" + result);
	}
}

/*
One More Approach: Using indexOf()
for(int i=0; i < s.length(); i++){
char c = s.charAt(i);
if(str.indexOf(c) < 0){
str += c;
}
}*/