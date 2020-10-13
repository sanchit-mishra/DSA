import java.util.*; 

class GetMinStack{
	
	Stack<Integer> s;
	Integer minimumElement;

	GetMinStack(){
		s = new Stack<Integer>();
	}

	void pushIntoStack(int no){
		if(s.isEmpty()){
			s.push(no);
			minimumElement = no;
		}
		if(no > minimumElement){
			s.push(no);
		}else{
			s.push((2*no) - minimumElement);
			minimumElement = no;
		}
	}

	void getMin(){
		System.out.println("Minimum Element is: " + minimumElement);
	}


	int popFromStack(){
		if(s.isEmpty()){
			return -1;
		}

		int currentElement = s.pop();
		if(currentElement >= minimumElement){
			return currentElement;
		}else{
			int popElement = minimumElement;
			minimumElement = (2*minimumElement) - currentElement;
			return popElement;
		}
	}

	public static void main(String args[]){
		GetMinStack s = new GetMinStack();

		s.pushIntoStack(7);
		s.pushIntoStack(5);
		s.pushIntoStack(2);
		s.pushIntoStack(6);
		s.pushIntoStack(1);

		s.getMin();
		int remove;
		remove = s.popFromStack();
		System.out.println("Popped Element is: " + remove);
		remove = s.popFromStack();
		System.out.println("Popped Element is: " + remove);

		s.pushIntoStack(7);

		s.getMin();
	}
}