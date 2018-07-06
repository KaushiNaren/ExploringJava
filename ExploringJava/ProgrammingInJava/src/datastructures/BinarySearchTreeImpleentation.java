package datastructures;

import java.util.Arrays;
import java.util.List;

/**
 * @author Narendiran Rangan Manian
 * 
 *         Binary Search Tree Operations.
 *
 */
public class BinarySearchTreeImpleentation {

	public static void main(String... args) {
		BSTNodeImpl bstImpl = new BSTNodeImpl();
		List<Integer> data = Arrays.asList(6, 4, 3, 5, 8, 7, 9);
		data.forEach(x -> bstImpl.insert(x));
		BSTNode rootNode = bstImpl.getRootNode();
		System.out.println("========Pre-Order Traversal=========");
		bstImpl.printPreOrder(rootNode);
		System.out.println("=======Post-Order Traversal ==========");
		bstImpl.printPostOrder(rootNode);
		System.out.println("======In-Order Traversal===========");
		bstImpl.printInOrder(rootNode);
	}
}

class BSTNodeImpl {
	private BSTNode rootNode;

	public void insert(int data) {
		rootNode = insert(rootNode, data);
	}

	private BSTNode insert(BSTNode currentNode, int data) {

		if (currentNode == null) {
			currentNode = new BSTNode(data);
			return currentNode;
		}
		int currentData = currentNode.getData();
		if (data < currentData) {
			currentNode.setLeftNode(insert(currentNode.getLeftNode(), data));

		} else if (data > currentData) {
			currentNode.setRightNode(insert(currentNode.getRightNode(), data));
		}
		return currentNode;

	}

	public BSTNode getRootNode() {
		return this.rootNode;
	}

	public void printPreOrder(BSTNode currentNode) {
		if (currentNode == null) {
			return;
		}
		System.out.println(currentNode.getData());
		printPreOrder(currentNode.getLeftNode());
		printPreOrder(currentNode.getRightNode());

	}

	public void printPostOrder(BSTNode currentNode) {
		if (currentNode == null) {
			return;
		}

		printPostOrder(currentNode.getLeftNode());
		printPostOrder(currentNode.getRightNode());
		System.out.println(currentNode.getData());

	}

	public void printInOrder(BSTNode currentNode) {
		if (currentNode == null) {
			return;
		}

		printInOrder(currentNode.getLeftNode());
		System.out.println(currentNode.getData());
		printInOrder(currentNode.getRightNode());

	}
}

class BSTNode {
	private final int data;
	private BSTNode leftNode;
	private BSTNode rightNode;

	public BSTNode(int data) {
		this.data = data;

	}

	public BSTNode getLeftNode() {
		return leftNode;
	}

	public void setLeftNode(BSTNode leftNode) {
		this.leftNode = leftNode;
	}

	public BSTNode getRightNode() {
		return rightNode;
	}

	public void setRightNode(BSTNode rightNode) {
		this.rightNode = rightNode;
	}

	public int getData() {
		return data;
	}

}
