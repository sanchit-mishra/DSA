//Checking valid balanced parenthesis Using Stack
import java.util.*; 


class BalancedParenthesis{

	static boolean checkValidness(String str){
		Stack<Character> stack = new Stack<Character>();
		if(str.length() == 0){
			return false;
		}

		for(int i = 0; i < str.length(); i++){
			if(str.charAt(i) == '{' || str.charAt(i) == '(' || str.charAt(i) == '['){
				stack.push(str.charAt(i));
			}else if(stack.isEmpty()){
					return false;
			}else{
				switch(str.charAt(i)){
					case '}':
						char openingBracket = stack.pop();
						if(openingBracket == '[' || openingBracket == '(')
							return false;
						break;

					case ')':
							openingBracket = stack.pop();
						if(openingBracket == '{' || openingBracket == '[')
							return false;
						break;

					case ']':
							openingBracket = stack.pop();
						if(openingBracket == '{' || openingBracket == '(')
							return false;
						break;
				}
			}
		}
		return (stack.isEmpty());
	}


	public static void main(String args[]){
		String str1 = "{[()]}";
		String str2 = "]{[}";

		boolean answer = checkValidness(str1);
		//boolean answer = checkValidness(str2);
		if(answer){
			System.out.println("Parenthesis are balanced");
		}else{
			System.out.println("Parenthesis are not balanced");
		}

	}
}