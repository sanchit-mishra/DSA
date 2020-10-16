//Designing "N" stack in an array
import java.util.*;

class Nstack{

	int number;
	int capacity;

	int[] topOfStack; // To store top index of each stack.
	int[] stackData;  // To store actual stack data.
	int[] nextIndex;  // Use for two purpose.

	// To have next index for storing stack data.
	// To have index of previous top for stack.


	int nextAvailable = 0; // Initial pointer for stack location.

	public Nstack(int number, int capacity){
		this.number = number;
		this.capacity = capacity;

		topOfStack = new int[number];
		for(int i = 0; i < number; i++){
			topOfStack[i] = -1;
		}

		stackData = new int[capacity];

		nextIndex = new int[capacity];
		for(int i = 0; i < nextIndex.length - 1; i++){
			nextIndex[i] = i + 1;
		}
		nextIndex[nextIndex.length - 1] = -1;
	}

	public void push(int stack, int value){
		if(stack < 0 || stack >= topOfStack.length){
			throw new IndexOutOfBoundsException();
		}

		int currentIndex = nextAvailable;
		nextAvailable = nextIndex[currentIndex];
		stackData[currentIndex] = value;
		nextIndex[currentIndex] = topOfStack[stack]; // Storing previous top.
		topOfStack[stack] = currentIndex;            // Storing current top index for that stack.

	}

	public int pop(int stack){
		if(stack < 0 || stack >= topOfStack.length || topOfStack[stack] < 0){
			throw new IndexOutOfBoundsException();
		}

		int currentIndex = topOfStack[stack];
		int value = stackData[currentIndex];
		topOfStack[stack] = nextIndex[currentIndex]; // Getting previous top
		nextIndex[currentIndex] = nextAvailable;
		nextAvailable = currentIndex;
		return value;
	}

	public void display(){
		for(int i = 0; i < stackData.length; i++){
			System.out.println(stackData[i]);
		}
	}

	public static void main(String[] args) {
		Nstack s = new Nstack(3,9);	

		s.push(0,10);
		s.push(0,20);
		s.push(1,30);

		s.display();
		int popElement = s.pop(0);
		System.out.println("Poppec Element is: " + popElement);
		//s.display();
	}
}