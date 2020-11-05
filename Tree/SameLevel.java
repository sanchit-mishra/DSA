/* Java program to check whether all leaves are at the same level or not. */
import java.util.*;

class SameLevel{
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
	public static boolean check(Node node){
		if(node == null){
			return true;
		}

		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int level = 0;

		while(q.size() != 0){
			int size = q.size();
			level++;

			while(size > 0){
				Node temp = q.peek();
				q.remove();

				if(temp.left != null){
					q.add(temp.left);

					if(temp.left.left == null && temp.left.right == null){

						if(result == Integer.MAX_VALUE){
							result = level;
						}
						else if(result != level){
							return false;
						}
					}
				}
				if(temp.right != null){
					q.add(temp.right);

					if(temp.right.left == null && temp.right.right == null){

						if(result == Integer.MAX_VALUE){
							result = level;
						}
						else if(result != level){
							return false;
						}
					}
				}
				size--;
			}
		}
		return true;
	}
	/*
	Recursive solution:
	public static boolean(Node node, int level, int result){
		if(node == null) return true;
		if(node.left == null && node.right == null){
			if(result == 0){
				result = level;
				return true;
			}
			else if(result != 0){
				return(level == result);
			}
		}
		return boolean(node.left,level++,result) && boolean(node.right, level++, result);
	}
	*/
	public static int result = Integer.MAX_VALUE;
	public static Node root = null;
	public static void main(String[] args) {
		SameLevel sl = new SameLevel();

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		root.right.left = new Node(6);

		if(check(root)){
			System.out.println("Same Level");
		}
		else{
			System.out.println("Different Level");
		}
	}
}