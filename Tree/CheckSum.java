/* Java Program to check if a binary tree is sum tree with respect to level. */

class CheckSum{
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
	public static boolean checkSum(Node node, boolean answer){
		if(node == null){
			answer = true;
			return answer;
		}
		if(node.left == null && node.right == null){  //For root or leaf node.
			answer = true;
			return answer;
		}
		else if(node.left == null){                //if one child node.
			if(node.right.data == node.data){
				answer = true;
			}
			else{
				answer = false;
				return answer;
			}
		}
		else if(node.right == null){
			if(node.left.data == node.data){
				answer = true;
			}
			else{
				answer = false;
				return answer;
			}
		}
		else{                                    //Two child node.
			if(node.left.data + node.right.data == node.data){
				answer = true;
			}
			else{
				answer = false;
				return answer;
			}
		}
		if(node.left != null){
			answer = checkSum(node.left, answer); //Recursive call to left sub tree.
		}
		if(node.right != null){
			answer = checkSum(node.right, answer); //Recursive call to right sub tree.
		}
		return answer;
	}
	public static Node root = null;
	public static void main(String[] args) {
		CheckSum c = new CheckSum();
		boolean result = false;

		root = new Node(14);
		root.left = new Node(10);
		root.right = new Node(4);
		root.left.left = new Node(4);
		root.left.right = new Node(6);
		root.right.right = new Node(1);
		root.right.left = new Node(3);


		result = c.checkSum(root,result);
		if(result){
			System.out.println("Given Binary Tree is a sum tree.");
		}
		else{
			System.out.println("Given Binary Tree is not a sum tree.");
		}

	}
}