//Java Program to reverse a stack recursively.
import java.util.*;

class StackReverse{

	int top = -1;
	public void push(int[] stack, int value){
		if(top == stack.length - 1){
			System.out.println("Stack Overflow");
			return;
		}
		stack[++top] = value;
	}

	public void display(int[] stack){
		for(int i = top; i >= 0; i--){
			System.out.print(stack[i] + " --> ");
		}
	}

	public void reverseDisplay(int[] stack){
		if(top == 0){
			System.out.print(stack[top]);
		}else{
			int no = stack[top--];
			reverseDisplay(stack); //Recursively call till 1 element left

			stack[++top] = no;
			System.out.print(stack[top]);
		}
	}

	public static void main(String[] args) {
		int[] stack = new int[5];
		StackReverse obj = new StackReverse();

		obj.push(stack,1);
		obj.push(stack,2);
		obj.push(stack,3);
		obj.push(stack,4);
	
		obj.display(stack);
		obj.reverseDisplay(stack);
		obj.display(stack);
	}
}