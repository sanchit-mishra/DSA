//Queue Data Structure using Array.
import java.util.*;

class MyQueue{

	private int front, rear, size;
	private int[] queueArray;
	MyQueue(int size){
		this.size = size;
		queueArray = new int[size];
		this.front = -1;
		this.rear  = -1;
	}

	boolean isFull(){
		if(rear == size - 1){
			return true;
		}
		return false;
	}

	boolean isEmpty(){
		if(front == -1 && rear == -1){
			return true;
		}else if(front == size){
			return true;
		}
		return false;
	}

	void enqueue(int value){
		if(isFull()){
			System.out.println("Queue is Full");
			return;
		}
		if(front == -1){
			front = 0;
		}
		queueArray[++rear] = value;
	}

	int dequeue(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
			return -1;
		}
		return queueArray[front++];
	}

	void display(){
		if(isEmpty()){
			System.out.println("Queue is Empty");
			return;
		}
		for(int i = front; i <= rear; i++){
			System.out.print(queueArray[i] + " -> " );
		}
	}


	public static void main(String args[]){
		MyQueue queue = new MyQueue(5);

		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.enqueue(60);

		queue.display();

		int item = queue.dequeue();
		System.out.println();
		System.out.println(item);

		queue.display();
	}
}