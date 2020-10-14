//Java Program to implement two stack using one array.
import java.util.*; 

class TwoStack{
	int size;
	private int[] stack;
	int top1,top2;

	TwoStack(int s){
		size = s;
		stack = new int[size];
		top1 = -1; top2 = size;
	}

	void push1(int value){
		boolean result = stackOverFlow();
		if(result)
			return;
		top1++;
		stack[top1] = value;
	}

	boolean stackOverFlow(){
		if(top1 == top2-1 || top2 == top1+1){
			System.out.println("Stack Overflow");
			return true;
		}
		return false;
	}

	void push2(int value){
		boolean result = stackOverFlow();
		if(result)
			return;
		top2--;
		stack[top2] = value;
	}

	int pop1(){
		return stack[top1--];
	}

	int pop2(){
		return stack[top2++];
	}

	void displayStack1(){
		for(int i = top1; i > -1; i--){
			System.out.print(stack[i] + " --> ");
		}
	}

	void displayStack2(){
		for(int i = top2; i < size; i++){
			System.out.print(stack[i] + " --> ");
		}
	}

	public static void main(String args[]){
		TwoStack s = new TwoStack(6);
	
		s.push1(1);
		s.push1(2);
		s.push2(3);
		s.push1(4);
		s.push2(5);
		s.push1(6);
		s.push2(7);

		s.pop2();
		//s.pop1();
		s.push2(7);

		s.displayStack1();
		s.displayStack2();

	}
}