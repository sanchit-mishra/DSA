/*Count the occurrence of characters in a string
Approach: Use HashMap for Character-Count Pair
TC: O(N) && SC:O(N)*/


import java.util.*;

class characterOccurrence{

	static void occurrence(String str){
		HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();

		for(int i=0; i < str.length(); i++){
			if(str.charAt(i) != ' '){
			if(hmap.containsKey(str.charAt(i))){
				hmap.put(str.charAt(i),hmap.get(str.charAt(i)) + 1);
			}
			else{
				hmap.put(str.charAt(i),1);
			}
			}
		}

		for(Map.Entry m : hmap.entrySet()){

			System.out.println("Character:" +m.getKey()+ " And it's occurrence: " + m.getValue());
		}

	}

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		occurrence(str);
	}
}