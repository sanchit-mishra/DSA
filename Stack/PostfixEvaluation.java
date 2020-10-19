//Program on postfix evaluation.
import java.util.*;

class PostfixEvaluation{

	int evaluation(String expression){
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0; i < expression.length(); i++){
			char c = expression.charAt(i);
			if(Character.isDigit(c)){
				stack.push(c - '0');
			}else{
			int val1 = stack.pop();
			int val2 = stack.pop();
			switch(c){
				case '+':
					stack.push(val2 + val1);
					break;
				case '-':
					stack.push(val2 - val1);
					break;
				case '/':
					stack.push(val2 / val1);
					break;
				case '*':
					stack.push(val2 * val1);
					break;
				case '^':
					stack.push(val2 ^ val1);
					break;
				}
			}
		}
		return stack.pop();
	}

	public static void main(String[] args) {
		String expression;
		Scanner sc = new Scanner(System.in);

		expression = sc.nextLine();
		PostfixEvaluation pf = new PostfixEvaluation();
		int result = pf.evaluation(expression);
		System.out.println("PostFix Evaluation Result: " + result);
	}
}