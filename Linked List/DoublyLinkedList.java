/*Doubly Linked List in JAVA*/

import java.util.*;

public class DoublyLinkedList{

	class Node{             //Node Structure
		int data;
		Node next;
		Node prev;
	
	 	public Node(int data){
		this.data = data;
		this.next = null;
		this.prev = null;
		}
	}
	public Node addNodeAtBegin(Node head, int data){ 
		Node newNode = new Node(data);

		if(head == null){ //If list is empty
			head = newNode;
			return head;
		}
		else{
			head.prev = newNode;  
			newNode.next = head;
			head = newNode;
		}
		return head;
	}
	public Node addNodeAtEnd(Node head, int data){
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
			newNode.prev = current;
		}
		return head;
	}
	public int length(Node head){
		if(head == null){
			return 0;
		}
		else{
			Node current = head;
			int item = 0;
			while(current != null){
				current = current.next;
				item++;
			}
			return item;
		}
	}
	public Boolean search(Node head, int key){
		if(head == null){
			return false;
		}
		else{
			Node current = head;
			while(current != null){
				if(current.data == key){
					return true;
				}
				current = current.next;
			}
		}
	return false;
	}
	public Node delete(Node head, int data){
		if(head == null){
			System.out.println("List is empty");
			return head;
		}
		else{
			Node current = head;
			if(current != null && current.data == data){  //Case 1: Element to be deleted is at first.
				head = current.next;
				current.next.prev = null;
				return head;
			}
			while(current.next != null && current.data != data){
				current = current.next;
			}
			if(current.data == data && current.next != null){   //Case 2: Element is in between.
				current.prev.next = current.next;
				current.next.prev = current.prev;
				return head;
			}
			else if(current.data == data && current.next == null){  //Case 3: Element is at end
				current.prev.next = null;
				return head;
			}
			else{
				System.out.println("Element is not there to be deleted");
				return head;
			}
		}
	}
	public Node convertToCircular(Node head){
		if(head == null){
			System.out.println("Empty List");
			return head;
		}
		else{
			Node current = head;
			while(current.next != null){
				current = current.next;
			}
			current.next = head;
			System.out.println(current.next.data);
			return head;
		}
	}
	public void display(Node head){
		Node current = head;
		if(head == null){
			System.out.println("List is empty");
		}
		else{
			while(current.next != head){
				System.out.print("->" + current.data);
				current = current.next;
			}
			System.out.print("->" + current.data);
		}
	}
	public static void main(String[] args) {
		DoublyLinkedList d1 = new DoublyLinkedList();
		Node head = null;

		head = d1.addNodeAtBegin(head,1);
		head = d1.addNodeAtEnd(head,3);
		head = d1.addNodeAtEnd(head,4);
		head = d1.addNodeAtEnd(head,5);
		head = d1.addNodeAtEnd(head,5);
		head = d1.addNodeAtEnd(head,6);


		int len = d1.length(head);
		System.out.println("Length of the DoublyLinkedList: " + len); 
		

		
		Boolean presence = d1.search(head,2);
		if(presence){
			System.out.println("Element is present");
		}
		else{
			System.out.println("Element is absent");
		}

		 head = d1.delete(head,1);
		 head = d1.delete(head,5);
		 head = d1.delete(head,6);
		 head = d1.convertToCircular(head); 


		d1.display(head);

	}
}