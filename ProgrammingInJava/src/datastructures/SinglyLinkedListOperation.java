package datastructures;

import java.util.Arrays;
import java.util.List;

public class SinglyLinkedListOperation {
	public static void main(String... args) {

		SLOperations slOperation = new SLOperations();
		List<Integer> list = Arrays.asList(5, 4, 3, 2, 1);
		list.forEach(x -> slOperation.insert(x));

		System.out.println("Traverse Before Reverse :");
		slOperation.traverse();
		slOperation.reverse();
		System.out.println("\nTraverse After Reverse :");
		slOperation.traverse();

	}

}

class SLNode {
	private final int data;
	private SLNode nextNode;

	public SLNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public SLNode getNextNode() {
		return nextNode;
	}

	public void setNextNode(SLNode nextNode) {
		this.nextNode = nextNode;
	}
}

class SLOperations {

	private SLNode head;

	public void insert(int data) {

		SLNode currentNode = head;
		if (currentNode == null) {
			currentNode = new SLNode(data);

			head = currentNode;
		} else {

			while (currentNode.getNextNode() != null) {
				currentNode = currentNode.getNextNode();
			}
			currentNode.setNextNode(new SLNode(data));

		}
	}

	public void reverse() {

		SLNode currentNode = head;
		SLNode prevNode = null;

		while (currentNode != null) {
			SLNode nextNode = currentNode.getNextNode();
			currentNode.setNextNode(prevNode);
			prevNode = currentNode;
			currentNode = nextNode;
		}

		head = prevNode;

	}

	public void traverse() {
		SLNode currentNode = head;
		while (true) {
			System.out.print(currentNode.getData());
			currentNode = currentNode.getNextNode();
			if (currentNode == null) {
				break;
			}
			System.out.print("->");
		}

	}

}
