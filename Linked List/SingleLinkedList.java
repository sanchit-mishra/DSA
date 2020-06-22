import java.util.*;

public class SingleLinkedList{
	class Node{
		int data;
		Node next;
	

	public Node(int data){
		this.data = data;
		this.next = null;
	}
}
	public Node head = null;
	public Node tail = null;
	
	public void addNodeAtBegin(int data){
		Node newNode = new Node(data);

		if(head == null){
			head = newNode;
		}
		else{
			newNode.next = head;
			head = newNode;
		}
	}

	public void addNodeAtEnd(int data){
		Node newNode = new Node(data);

		if(head == null && tail == null){
			head = newNode;
			tail = newNode;
		}
		else{
			Node current = head;
			while(current.next != null){
				current = current.next;
			}

			current.next = newNode;
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

		if(current != null && current.data == key){
			head = current.next;
		}
		else{
			while(current.data != key && current != null){
					prev = current;
					current = current.next;
					}
					if(current != null){
						prev.next = current.next;
					}
					if(current == null && current.data == key){
						prev.next = current.next;
					}
			}

	}
	public void display(){
		Node current = head;

		if(head == null){
			System.out.println("List is empty");
		}
		else{
			while(current != null){
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

		s1.display();
		s1.length();

	}

}