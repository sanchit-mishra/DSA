/* Java Program to create binary tree from given inorder and preorder traversal. */

import java.util.*;

class CreateBT{
	static class Node{
		char data;
		Node left;
		Node right;

		public Node(char data){
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	public Node buildTree(char in[], char pre[], int inStart, int inEnd){
		if(inStart > inEnd){
			return null;
		}
		Node node = new Node(pre[preIndex]);
		if(inStart == inEnd){
			root = node;
			return root;
		}

		int index = hmap.get(pre[preIndex++]);

		root.left = buildTree(in , pre, inStart, index-1);
		root.right = buildTree(in , pre, index+1, inEnd);

	}
	public void createHashMap(HashMap<Character,Integer> hmap, char[] in){
		for(int i=0; i < in.length; i++){
			hmap.put(in[i],i);
		}
	}
	public static int preIndex = 0;
	public static Node root = null;
	public static void main(String[] args) {
		CreateBT bt = new CreateBT();

		char in[] = {'D','B','E','A','F','C'};
		char pre[] = {'A','B','D','E','C','F'};

		int len = in.length;
		Node root = bt.buildTree(in, pre, 0, len-1);

		HashMap<Character,Integer> hmap = new HashMap<Character,Integer>();
		bt.createHashMap(hmap,in);

		System.out.println("Inorder traversal of the constructed Tree is:");
		bt.seeInOrder(root);

	}
}