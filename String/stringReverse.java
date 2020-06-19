/*A simple program to reverse a string in java:
1) Simple Approach
2) Indexing Approach n/2 Note: String in java is immutable
 TC: O(N)*/

import java.util.*;

class stringReverse{

	static String reverseString(String str){
	// 	String rev = "";
	// 	int i = str.length()-1;
	// 	while(i >= 0){
	// 		rev += str.charAt(i);
	// 		i--;
	// 	}
	// return rev;

	char[] character = str.toCharArray();
	int low = 0; int high = str.length() - 1;
	while(low < high){
		char temp = character[high];
		character[high] = character[low];
		character[low] = temp;

		low++;
		high--;
	}
	
	return String.copyValueOf(character);
	}
	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		System.out.println("Original String:" + str);
		String reverse = reverseString(str);
		System.out.print("Reverse String:" + reverse);
	}
}