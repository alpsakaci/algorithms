package binarytrees;

class Node {

	int data;
	Node leftChild;
	Node rightChild;

	public Node(int data) {
		this.data = data;
	}

	public void displayNode() {
		System.out.println("Data: " + data + " Hash: " + this.hashCode());
	}

}

class Tree {

	private Node root;

	public Node getRoot() {
		return root;
	}

	public Node find(int key) {
		Node current = root;

		while (current.data != key) {
			if (key < current.data) {
				current = current.leftChild;
			} else {
				current = current.rightChild;
			}

			if (current == null) {
				return null;
			}
		}

		return current;
	}

	public void insert(int data) {
		Node newNode = new Node(data);

		if (root == null) {
			root = newNode;
		} else {
			Node current = root;
			Node parent;

			while (true) {
				parent = current;
				if (data < current.data) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;

		while (current != null) {
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}

		if (successor != delNode.rightChild) {
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}

		return successor;
	}

	public boolean delete(int key) {
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;

		while (current.data != key) {
			parent = current;
			if (key < current.data) {
				isLeftChild = true;
				current = current.leftChild;
			} else {
				isLeftChild = false;
				current = current.rightChild;
			}

			if (current == null) {
				return false;
			}
		}

		if (current.leftChild == null && current.rightChild == null) {

			if (current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.leftChild = null;
			} else {
				parent.rightChild = null;
			}

		} else if (current.rightChild == null) {

			if (current == root) {
				root = current.leftChild;
			} else if (isLeftChild) {
				parent.leftChild = current.leftChild;
			} else {
				parent.rightChild = current.leftChild;
			}

		} else if (current.leftChild == null) {

			if (current == root) {
				root = current.rightChild;
			} else if (isLeftChild) {
				parent.leftChild = current.rightChild;
			} else {
				parent.rightChild = current.rightChild;
			}

		} else {
			Node successor = getSuccessor(current);

			if (current == root) {
				root = successor;
			} else if (isLeftChild) {
				parent.leftChild = successor;
			} else {
				parent.rightChild = successor;
			}

			successor.leftChild = current.leftChild;
		}

		return true;
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.leftChild);
			root.displayNode();
			inorder(root.rightChild);
		}
	}

	public void preorder(Node root) {
		if (root != null) {
			root.displayNode();
			preorder(root.leftChild);
			preorder(root.rightChild);
		}
	}

	public void postorder(Node root) {
		if (root != null) {
			postorder(root.leftChild);
			postorder(root.rightChild);
			root.displayNode();
		}
	}

	public void min() {
		Node current = root;

		if (current == null) {
			System.out.println("Tree is empty.");
			return;
		}

		while (current.leftChild != null) {
			current = current.leftChild;
		}

		System.out.print("Min: ");
		current.displayNode();
	}

	public void max() {
		Node current = root;

		if (current == null) {
			System.out.println("Tree is empty.");
			return;
		}

		while (current.rightChild != null) {
			current = current.rightChild;
		}

		System.out.print("Max: ");
		current.displayNode();
	}

}

public class BinaryTreeApp {

	public static void main(String[] args) {
		Tree tree = new Tree();

		tree.insert(50);
		tree.insert(20);
		tree.insert(46);
		tree.insert(90);
		tree.insert(60);
		tree.insert(71);

		int key = 20;
		Node found = tree.find(key);

		if (found != null) {
			System.out.print("Found: ");
			found.displayNode();
		} else {
			System.out.println("Couldn't found node with key " + key);
		}

		System.out.println("inorder");
		tree.inorder(tree.getRoot());
		System.out.println("preorder");
		tree.preorder(tree.getRoot());
		System.out.println("postorder");
		tree.postorder(tree.getRoot());

		tree.min();
		tree.max();

		System.out.println(tree.delete(90));
	}

}
