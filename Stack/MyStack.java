// Java Program to implement Stack
import java.util.*; 

class MyStack{
	int size;
	int top;
	private long[] stack;
	MyStack(int s){
		size = s;
		stack = new long[size];
		top = -1;
	}

	void push(int insertValue){
		if(top == size-1){
			System.out.println("Stack Overflow");
			return;
		}
		top++;
		stack[top] = insertValue;
	}

	long pop(){
		if(top == -1){
			System.out.println("Stack Underflow");
			return -1;
		}
		return stack[top--];
	}

	long peek(){
		return stack[top];
	}

	void findmiddle(){
		int middle = stack.length / 2;
		System.out.println("Middle Elemet is: " + stack[--middle]);
	}

	void displayStack(){
		for(int i = top; i > -1; i--){
			System.out.print(stack[i] + " -> ");
		}
	}


	public static void main(String[] args) {
		MyStack s = new MyStack(6);
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);

		s.displayStack();
		s.findmiddle();
		s.push(7);

		long popElement = s.pop();
		System.out.println("Popped Element: " + popElement);
		s.findmiddle();
		
		s.displayStack();

		long peekElement = s.peek();
		System.out.println("Peek Element: " + peekElement);

	}
}