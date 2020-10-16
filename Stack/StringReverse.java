//String Reverse using stack.
import java.util.*;

class StringReverse{


	static String stringReverse(String original){
		if(original.length() < 0){
			System.out.println("Empty String");
			return "";
		}

		String reverse = "";
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < original.length(); i++){
			if(original.charAt(i) != ' '){
				stack.push(original.charAt(i));
			}else{
				while(!stack.isEmpty()){
					reverse += stack.pop();
				}
				reverse += " " ;
			}
		}
		while(!stack.isEmpty()){
			reverse += stack.pop();
		}
		return reverse;
	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String original = sc.nextLine();

		String reverse = stringReverse(original);
		System.out.println("Original String: " + original);
		System.out.println("Reverse String: " + reverse);
	}
}