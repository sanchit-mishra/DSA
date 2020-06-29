import java.util.*;

class BSTree{
	class Node{
		int data;
		Node left;
		Node right;

		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	public Node insert(Node root, int data){
		Node newNode = new Node(data);

		//Base Condition 1:
		if(root == null){
			root = newNode;
			return root;
		}
		if(root.data < newNode.data){
			root.right = insert(root.right,newNode.data);
		}
		if(root.data > newNode.data){
			root.left = insert(root.left,newNode.data);
		}

		return root;
	}
	public void preOrder(Node root){
		//Base Condition:
		if(root != null){
			System.out.print(root.data+"->");
			preOrder(root.left);
			preOrder(root.right);
		}	
	}
	public void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data+"->");
			inOrder(root.right);
		}
	}
	public void postOrder(Node root){
		if(root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data+"->");
		}
	}
	public Node delete(Node root, int key){
		//Base Case: if tree is empty
		if(root == null){
			return root;
		}
		 if(key < root.data){
		 	root.left = delete(root.left,key);
		 }
		 else if(key > root.data){
		 	root.right = delete(root.right,key);
		 }

		 else{
		 	//If one child
		 	if(root.left == null){
		 		return root.right;
		 	}
		 	else if(root.right == null){
		 		return root.left;
		 	}

		 	//If two child
		 	root.data = minValue(root.right);
		 	root.right = delete(root.right, root.data);
		 }
		 return root;
	}
	public int minValue(Node root){
		int minV = root.data;
		while(root.left != null){
			minV = root.left.data;
			root = root.left;
		}
		return minV;
	}
	public boolean search(Node root, int key){
		boolean ans = false;
		if(root == null){
			return ans;
		}
		if(root.data == key){
			return true;
		}
		if(key < root.data){
			ans = search(root.left, key);
		}
		if(key > root.data){
			ans = search(root.right,key);
		}

		return ans;
	}
	public void minMax(Node root){
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

		Node temp = root;
		while(temp.left != null){
			temp = temp.left;
		}
		while(root.right != null){
			root = root.right;
		}
		System.out.println("Minimum Element: " + temp.data + "Maximum Element: " + root.data);
	}
	public static Node root = null;
	public static void main(String[] args) {
		BSTree b1 = new BSTree();

		root = b1.insert(root,10);
		root = b1.insert(root,7);
		root = b1.insert(root,14);
		root = b1.insert(root,6);
		root = b1.insert(root,9);

		b1.preOrder(root);

		root = b1.delete(root,7);
		System.out.println("");
		b1.inOrder(root);

		boolean result = b1.search(root,6);
		if(result){
			System.out.println("Element found");
		}
		else{
			System.out.println("Element not found");
		}
		System.out.println("");
		b1.minMax(root);

	}
}