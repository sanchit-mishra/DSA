/*Singly Linked List in JAVA with all the necessary operations.*/

import java.util.*;

public class SingleLinkedList{
	class Node{               //Node Structure
		int data;
		Node next;
	

	public Node(int data){   //Constructor
		this.data = data;
		this.next = null;
	}
}
	public Node head = null;
	public Node tail = null;
	
	public void addNodeAtBegin(int data){
		Node newNode = new Node(data);   

		if(head == null){              //If list is empty
			head = newNode;
		}
		else{
			newNode.next = head;      //Make newNode points to where head is pointing.
			head = newNode;           //make Head points to newNode.
		}
	}

	public void addNodeAtEnd(int data){
		Node newNode = new Node(data);

		if(head == null && tail == null){  //If list is empty.
			head = newNode;
			tail = newNode;
		}
		else{
			Node current = head;          
			while(current.next != null){  //Traverse till end
				current = current.next;
			}

			current.next = newNode;      //Place the node
			tail = newNode;
		}
	}

	public void length(){
		Node current = head;
		int count = 0;
		if(head == null){
			System.out.print("Length is 0");
		}
		else{
			while(current != null){
				count++;
				current = current.next;
			}

			System.out.println("Length of the list is: " + count);
		}
	}
	public void delete(int key){
		Node current = head; Node prev = null;

		if(current != null && current.data == key){ //Case 1: if key is present at first place.
			head = current.next;                    //Make head points to next element.
		}
		else{
			while(current.data != key && current != null){ //Case 2. if key is in middle or at the end.
					prev = current;                        //Previous pointer for making it pointing delete next element.
					current = current.next;
					}
					if(current != null && current.data == key){ //If key is at middle or other place than start and end.
						prev.next = current.next;
					}
					else if(current == null && current.data == key){ //If key is at the end.
						prev.next = current.next;
					}
					else{
						System.out.println("Key not present");
					}
			}
		}
	public void search(int value){
		Node current = head;
		while( current != null && current.data != value){
			current = current.next;
		}
		if(current.data == value){
			System.out.println("Element Found");
		}
		else{
			System.out.println("Element not found");
		}
	}
	public void nthNode(int count){
		Node current = head;
		if(count == 1){
			System.out.println("Node at the position" + current.data);	
		}
		else{
			while( current != null && --count != 0){ //relative index
				current = current.next;
			}
			if(count == 0){
				System.out.println("Node at the position" + current.data);
			}
			else{
				System.out.println("End of list");
			}
		}
	}
	public void count(int data){
		Node current = head;
		int count = 0;
		while(current != null){
			if(current.data == data){
				count++;
			}
			current = current.next;
		}
		System.out.println("Count:" + count);
	}
	public void minMax(){
		Node current = head;
		int min = current.data, max = current.data;
		while(current != null){
			if(current.data < min){
				min = current.data;
			}
			if(current.data > max){
				max = current.data;
			}
			current = current.next;
		}
		System.out.println("Minimum:" + min + "" + "Maximum:" + max);
	}
	// public void convertToCircular(){
	// 	Node current = head;
	// 	while(current.next != null){
	// 		current = current.next;
	// 	}
	// 	current.next = head;
	// 	System.out.println("current data: " + current.next.data);
	// }
	public void display(){
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

	public static void main(String[] args) {
		SingleLinkedList s1 = new SingleLinkedList();

		s1.addNodeAtEnd(1);
		s1.addNodeAtBegin(4);
		s1.addNodeAtBegin(7);

		s1.addNodeAtEnd(3);
		s1.addNodeAtBegin(7);
		s1.addNodeAtBegin(4);

		s1.display();

		s1.length();
		s1.delete(4);
		s1.delete(1);
		s1.delete(3);
		s1.addNodeAtEnd(5);

		s1.display();
		s1.length();

		s1.search(7);

		s1.nthNode(4);
		s1.count(7);

		s1.minMax();

		//s1.convertToCircular();
		s1.display();
	}

}