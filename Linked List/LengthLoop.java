import java.util.*;

class LengthLoop{
	class Node{
		int data;
		Node next;

		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public static Node head = null;
	public Node add(Node head, int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			return head;
		}
		else{
			Node current = head;
			while(current.next != null){
				current = current.next;
			}
			current.next = newNode;
			return head;
		}
	}
	public void display(Node head){
		Node current = head;

		if(head == null){
			System.out.println("List is empty");
		}
		else{
			while(current != null ){
				System.out.print("->"+current.data);
				current = current.next;
			}
		}
	}
	public Node createLoop(Node head){
		Node end = head;
		Node loopPosition = head;

		int count = 3;      //Creating the loop from 3 node;
		while(end.next != null){
			end = end.next;
		}
		while(--count != 0){
			loopPosition = loopPosition.next;
		}
		end.next = loopPosition;
		return head;
	}
	public int detectLoopLength(Node head){
		Node hare = head;
		Node tortoise = head;
		Node loopPoint = null;
		while(hare != null && tortoise != null && hare.next != null){
			hare = hare.next.next;
			tortoise = tortoise.next;
			if(hare == tortoise){
				loopPoint = hare;  // Storing the address of any Loop position.				
				break;
			}
		}
		int count = 1;
		while(loopPoint.next != hare){ //comparing current loop position with next, loop will terminate if loopPoint points to hare position.
			loopPoint = loopPoint.next;
			count++;
		}
		return count;
	}
	public static void main(String[] args) {
		
		LengthLoop l1 = new LengthLoop();

			head = l1.add(head,1);
			head = l1.add(head,2);
			head = l1.add(head,3);
			head = l1.add(head,4);
			head = l1.add(head,5);
			head = l1.add(head,6);

			l1.display(head);

			head = l1.createLoop(head);	

			int length = l1.detectLoopLength(head);
			System.out.println("");
			System.out.println("Length of the loop " + length);
	}
}