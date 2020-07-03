/*Left View of Binary Tree*/

import java.util.*;

class RightView{
	static class Node{
		int data;
		Node left;
		Node right;

		public Node(int data){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	static class NodeLevel{
		Node node;
		int level;

		public NodeLevel(Node n, int l){
			this.node = n;
			this.level = l;
		}
	}
	public static void seeRightView(Node root){
		//Case 1:
		if(root == null){
			System.out.println("Tree is empty");
		}

		Queue<NodeLevel> q = new LinkedList<NodeLevel>();
		Map<Integer,Integer> mp = new TreeMap<Integer,Integer>();

		Node temp = null;
		q.add(new NodeLevel(root,0));
       		
		while(q.size() > 0){
			temp = q.peek().node;
			int level = q.peek().level;
			q.remove();

			if(mp.get(level) == null){  //add left node of same level
				mp.put(level,temp.data);
			}

			if(temp.right != null){
				q.add(new NodeLevel(temp.right,level+1));  //same level
			}
			if(temp.left != null){
				q.add(new NodeLevel(temp.left,level+1));
			}
		}

		for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
			System.out.print(entry.getValue()+"->");
		}

	}
	public static Node root = null;
	public static void main(String[] args) {
		RightView l1 = new RightView();

		root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.left.left.left = new Node(6);
		root.left.left.right = new Node(7);
		root.left.left.right.left = new Node(8);

		   //           1
		   //         2   3
		   //       4   5
		   //     6   7
		   //       8

		l1.seeRightView(root); //1->3->5->7->8
	}
}