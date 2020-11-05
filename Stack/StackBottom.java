//Java Program to insert element at bottom of stack.
import java.util.*;

class StackBottom{

	public void addAtBottom(Stack<Integer> stack, int value){
		if(stack.isEmpty()){
			stack.push(value);
		}else{
			int top = stack.pop();
			addAtBottom(stack, value);

			stack.push(top);
		}
	}

	public void display(Stack<Integer> stack){
		System.out.println(stack);
	}

	public static void main(String[] args) {
		StackBottom stackBottomObj = new StackBottom();

		Stack<Integer> stack = new Stack<Integer>();
		stackBottomObj.addAtBottom(stack, 10);
		stackBottomObj.addAtBottom(stack, 20);
		stackBottomObj.addAtBottom(stack, 30);

		stackBottomObj.display(stack);
	}
}