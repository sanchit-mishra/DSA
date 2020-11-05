/* Java program for Boundary Traversal of a tree. */

import java.util.*;

class BoundaryTraversal{
	static class Node{
		int data;
		Node left;
		Node right;

		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public static void printLeftBoundary(Node node){

		if(node == null){
			return;
		}
        //print in top-down manner
		if(node.left != null){  
			System.out.print(node.data + " ");
			printLeftBoundary(node.left);
		}
		else if(node.right != null){
			System.out.print(node.data + " ");
			printLeftBoundary(node.right);
		}
	}
	public static void printLeafs(Node node){

		if(node.left != null){
			printLeafs(node.left);
		}
		if(node.left == null && node.right == null){
			System.out.print(node.data + " ");
		}
		if(node.right != null){
			printLeafs(node.right);
		}
	}
	public static void printRightBoundary(Node node){
		if(node == null){
			return;
		}
		//print in bottom-up manner
		if(node.right != null){
			printRightBoundary(node.right);
			System.out.print(node.data + " ");
		}
		else if(node.left != null){
			printRightBoundary(node.left);
			System.out.print(node.data + " ");
		}
	}
	public static void seeBoundary(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data + " ");  //Print root
		printLeftBoundary(node.left);       //Visit left but don't print left leaf.
		printLeafs(node.left);              // Print leafs
		printLeafs(node.right);
		printRightBoundary(node.right);     //Visit right but don't print right leaf.
	}
	public static Node root = null;
	public static void main(String[] args) {
		BoundaryTraversal b1 = new BoundaryTraversal();

		root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		root.left.left = new Node(4);

		root.left.right = new Node(12);
		root.right.right = new Node(25);
		root.right.right.right = new Node(30);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);

		System.out.println("Boundary Traversal");
		b1.seeBoundary(root);	

	}
}