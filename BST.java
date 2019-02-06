/*
 * Mike Moran
 * Notes from 1/22/18
 * 
 */
import java.util.ArrayList;
import java.util.List;


public class BST <Key extends Comparable<Key>, Value> {
	
	private class Node{
		private Key key;
		private Value value;
		private Node left, right;
		
		public Node(Key key, Value value, Node left, Node right) {
			super();
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}
		
		public Node(Key key, Value value) {
			super();
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return "Node [key=" + key + ", value=" + value + "]";
		}
	}//end Node class
	
	private Node root;
	
	public BST(BST<Key, Value>.Node root) {
		super();
		this.root = root;
	}
	
	public BST() {
		super();
		this.root = null;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(Node node) {
		if (node == null)
			return 0;
		
		return 1 + size(node.left) + size(node.right);
	}
	
	
	public void insert(Key key, Value value) {
		root = insert (root, key, value);
	}
	
	private Node insert (Node node, Key key, Value value) {
		if(node == null)
			return new Node(key,value);
		int comp = key.compareTo(node.key);
		if( comp == 0)
			return node;
		else if (comp < 0)
			node.left = insert(node.left, key, value);
		else
			node.right = insert(node.right, key, value);
		
		return node;
	}
	
	
	public List<Key> inOrderVisit() {
		return inOrderVisit(root);
	}
	
	// Violation #3 is from here https://wiki.sei.cmu.edu/confluence/pages/viewpage.action?pageId=88487331
	// EXP51-J. Do not perform assignments in conditional expressions
	private List<Key> inOrderVisit(Node node) {
		
		SimpleStack<Node> stack = new SimpleStack();
		ArrayList<Key> list = new ArrayList();
		
		Node temp;
		
		if(node == null)
			stack.push(node);
		
		while(!stack.isEmpty()) {
			temp = stack.pop();
			if(temp == null)
				continue;
			if(temp.left == null && temp.right == null)
				//System.out.println(temp);
				list.add(temp.key);
			else {
				stack.push(temp.right);
				stack.push(new Node(temp.key, temp.value));
				stack.push(temp.left);
			}
		}
		return list;
	}
	
	
	public List<Key> preOrderVisit(){
		return preOrderVisit(root);
	}
	
private List<Key> preOrderVisit(Node node) {
		
		SimpleStack<Node> stack = new SimpleStack();
		ArrayList<Key> list = new ArrayList();
		
		Node temp;
		
		if(node != null)
			stack.push(node);
		
		while(!stack.isEmpty()) {
			temp = stack.pop();
			if(temp == null)
				continue;
			if(temp.left == null && temp.right == null)
				//System.out.println(temp);
				list.add(temp.key);
			else {
				
				stack.push(temp.right);
				stack.push(temp.left);
				stack.push(new Node(temp.key, temp.value));
			}
		}
		return list;
	}

public List<Key> levelOrderVisit() {
	return levelOrderVisit(root);
}

private List<Key> levelOrderVisit(Node node) {
	
	SimpleQueue<Node> queue = new SimpleQueue();
	ArrayList<Key> list = new ArrayList();
	
	Node temp;
	
	if(node != null)
		queue.enqueue(node);
	
	while(!queue.isEmpty()) {
		temp = queue.dequeue();
		if(temp == null)
			continue;
		
		list.add(temp.key);
		queue.enqueue(temp.left);
		queue.enqueue(temp.right);
		}
	
	return list;
}

public boolean containsKey(Key key) {
	return containsKey(root, key);
}
private boolean containsKey(Node node, Key key) {
	
	if(node == null)
		return false;
	int comp = key.compareTo(node.key);
	if(comp == 0)
		return true;
	else if(comp < 0)
		return containsKey(node.left, key);
	else
		return containsKey(node.right, key);
}
public Key parent(Key key) {
	if(root == null)
		return null;
	if(key.compareTo(root.key) == 0)
		return null;
	
	return parent(root, key);
}
private Key parent(Node node, Key key) {
	if(node == null || key == null)
		return null;
	
	if( (node.left != null && node.left.key.compareTo(key) == 0) ||
			(node.right != null && node.right.key.compareTo(key) == 0))
		return node.key;
	if(key.compareTo(node.key)< 0 )
		return parent(node.left, key);
	else
		return parent(node.right, key);	
		
}
}
