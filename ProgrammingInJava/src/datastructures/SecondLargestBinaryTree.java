package datastructures;

import java.util.Arrays;
import java.util.List;

public class SecondLargestBinaryTree {
	public static void main(String... args) {

		List<Integer> listScenario1 = Arrays.asList(6, 4, 3, 18, 15, 33, 25, 44);
		// List<Integer> listScenario1 = Arrays.asList(6, 4, 3, 18, 15, 33, 25, 44, 35);
		// List<Integer> listScenario1 = Arrays.asList(6, 4, 3);

		SLBTNodeImpl slbtNodeImpl = new SLBTNodeImpl();
		listScenario1.forEach(data -> slbtNodeImpl.insert(data));
		SLBTNode rootNode = slbtNodeImpl.getRootNode();
		slbtNodeImpl.printPreOrder(rootNode);
		slbtNodeImpl.findSecondLargest(rootNode);

	}

}

class SLBTNodeImpl {

	private SLBTNode rootNode;

	public void insert(int data) {
		this.rootNode = insert(rootNode, data);
	}

	private SLBTNode insert(SLBTNode currentNode, int data) {

		if (currentNode == null) {
			currentNode = new SLBTNode(data);
			return currentNode;
		}

		int currentData = currentNode.getData();
		if (data <= currentData) {
			currentNode.setLeftNode(insert(currentNode.getLeftNode(), data));

		} else {
			currentNode.setRightNode(insert(currentNode.getRightNode(), data));
		}

		return currentNode;
	}

	public SLBTNode getRootNode() {
		return this.rootNode;
	}
	
	public void findSecondLargest(SLBTNode currentNode) {
		Count.count = 0;
		findSecondLargestElement(currentNode);
	}


	private void findSecondLargestElement(SLBTNode currentNode) {
		if (currentNode == null) {
			return;
		}
		findSecondLargestElement(currentNode.getRightNode());
		Count.count++;
		if (Count.count == 2) {
			System.out.println("Largest Node --->" + currentNode.getData());
			return;
		}

		findSecondLargestElement(currentNode.getLeftNode());

	}

	public void printPreOrder(SLBTNode currentNode) {
		if (currentNode == null) {
			return;
		}

		System.out.println(currentNode.getData());
		printPreOrder(currentNode.getLeftNode());
		printPreOrder(currentNode.getRightNode());

	}

	private static class Count {
		public static int count;
	}

}

class SLBTNode {
	private SLBTNode leftNode;
	private SLBTNode rightNode;
	private final int data;

	public SLBTNode(int data) {
		this.data = data;

	}

	public int getData() {
		return this.data;
	}

	public SLBTNode getLeftNode() {
		return this.leftNode;
	}

	public SLBTNode getRightNode() {
		return this.rightNode;
	}

	public void setLeftNode(SLBTNode leftNode) {
		this.leftNode = leftNode;
	}

	public void setRightNode(SLBTNode rightNode) {
		this.rightNode = rightNode;
	}

}