/* Create a binary tree from string with bracket representation. */

import java.util.*;

class FromString{
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
	public static Node buildTree(int end, String str){
		if(str == null || str.length() == 0){
			return null;
		}
		int num = 0;
		while(start <= end && Character.isDigit(str.charAt(start))){ //Extract digit
			int digit = Character.getNumericValue(str.charAt(start));
			num = num * 10 + digit;
			start++;
		}

		Node node = new Node(num);

		if(start >= end){
			return node;
		}

		if(start <= end && (str.charAt(start) == '(')){  //On opening bracket recursively call for left of node.
			start++;
			node.left = buildTree(end, str);
		}

		if(start <= end && (str.charAt(start) == ')')){  //On closing bracket return to previous node.
			start++;
			return node;
		}

		if(start <= end && (str.charAt(start) == '(')){
			start++;
			node.right = buildTree(end, str);
		}

		if(start <= end && (str.charAt(start) == ')')){
			start++;
			return node;
		}

		return node;
	}
	public void seePreOrder(Node node){
		if(node == null){
			return;
		}

		System.out.print(node.data + " ");
		seePreOrder(node.left);
		seePreOrder(node.right);
	}
	public static int start = 0;
	public static Node root = null;
	public static void main(String[] args) {
		FromString fs = new FromString();

		String s = "4(2(3)(1))(5(6)(7))";

		root = fs.buildTree(s.length()-1, s);
		System.out.println("Constructed Binary Tree is below:");
		fs.seePreOrder(root);
	}
}