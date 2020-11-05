/*Check whether a SLL is palindrome or not; Uses Stack
TC: O(N) && SC:O(N) */

import java.util.*;

class PalindromeSLL{

	class Node{
		int data;
		Node next;
		public Node(int data){
			this.data = data;
			this.next = null;
		}
	}
	public static Node head = null;
	public Node addNode(Node head, int data){
		Node newNode = new Node(data);
		if(head == null){
			head = newNode;
			return head;
		}else{
			Node current = head;
			while(current.next != null){
				current = current.next;
			}
			current.next = newNode;
			return head;
		}
	}
	public void display(Node head){
		if(head == null){
			System.out.println("List is empty");
		}
		else{
			Node current = head;
			while(current != null){
				System.out.print("->"+current.data);
				current = current.next;
			}
		}
	}
	public static Boolean isPalindrome(Node head){
		Stack<Integer> stack = new Stack<Integer>();
		if(head == null){
			return false;
		}
		else{
			Node current = head;
			while(current != null){
				stack.push(current.data);
				current = current.next;
			}
			current = head;
			while(!stack.isEmpty()){
				if(stack.pop() != current.data){
					return false;
				}
				else{
					current = current.next;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		PalindromeSLL l1 = new PalindromeSLL();
		head = l1.addNode(head,1);
		head = l1.addNode(head,2);
		head = l1.addNode(head,2);
		head = l1.addNode(head,1);

		l1.display(head);

		Boolean result = isPalindrome(head);
		if(result){
			System.out.println("LinkedList is Palindrome");
		}
		else{
			System.out.println("LinkedList is not Palindrome");
		}
	}
}