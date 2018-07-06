package datastructures;

public class LargestElementFromTree {
	public static void main(String... args) {
		TreeNode rootNode = new TreeNode(10);

		rootNode.leftNode = new TreeNode(11);
		rootNode.leftNode.leftNode = new TreeNode(4);
		rootNode.leftNode.rightNode = new TreeNode(9);

		rootNode.rightNode = new TreeNode(3);
		rootNode.rightNode.leftNode = new TreeNode(6);
		rootNode.rightNode.rightNode = new TreeNode(8);

		TreeImpl.printPreOrder(rootNode);
		System.out.println(TreeImpl.getLargestNodeElement(rootNode));

	}

}

class TreeImpl {
	public static void printPreOrder(TreeNode currentNode) {
		if (currentNode == null) {
			return;
		}
		System.out.println(currentNode.data);
		printPreOrder(currentNode.leftNode);
		printPreOrder(currentNode.rightNode);
	}

	public static int getLargestNodeElement(TreeNode currentNode) {
		if (currentNode == null) {
			return Integer.MIN_VALUE;
		}

		int currentValue = currentNode.data;
		int leftMax = getLargestNodeElement(currentNode.leftNode);
		int rightMax = getLargestNodeElement(currentNode.rightNode);

		if (leftMax > currentValue) {
			currentValue = leftMax;
		}

		if (rightMax > currentValue) {
			currentValue = rightMax;
		}
		return currentValue;
	}
}

class TreeNode {
	public int data;
	public TreeNode leftNode;
	public TreeNode rightNode;

	public TreeNode(int data) {
		this.data = data;
	}

	// Getters and Setters are avoided for the easy of tree insertion.
}