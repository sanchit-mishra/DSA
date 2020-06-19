/*Stack data structure is used to store and reverse the word due to it's property LIFO
TC:O(N) && SC:O(N) */

import java.util.*;

class reverseEachWord{

	static void reverseWord(String str){
		Stack<Character> s = new Stack<Character>();

		for(int i=0; i < str.length(); i++){
			if(str.charAt(i) != ' '){
				s.push(str.charAt(i));
			}
			else{
				while(!s.empty()){
					System.out.print(s.pop());
				}
				System.out.print(" ");
			}
		}
		while(!s.empty()){
			
			System.out.print(s.pop());
		}
	}

	public static void main(String[] args) {
		String str;
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		reverseWord(str);
	}
}