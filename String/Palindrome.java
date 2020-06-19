/*String Palindrome. TC:O(N) && SC:O(N)
Note: This solution does only n/2 comparison if string is palindrome.*/

import java.util.*;

class Palindrome{

	static Boolean isPalindrome(String str){

		if(str.length() == 0){
			return true;
		}

		char[] strChar = str.toCharArray();
		int low = 0;
		int high = str.length() - 1;

		while(low < high){

			if(strChar[low++] == strChar[high--]){
				//Increment Low index && Decrement high index.
			}
			else{
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		Boolean result = isPalindrome(str);
		System.out.println("Is the String Palindrome? " + result);
	}
}