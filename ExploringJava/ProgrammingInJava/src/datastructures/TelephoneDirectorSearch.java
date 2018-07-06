package datastructures;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Narendiran Rangan Manian
 * 
 *         Telephone Directory Search using Trie data structure.
 */
public class TelephoneDirectorSearch {
	public static void main(String... args) {

		String[] words = { "amrith", "aasha", "ameer", "anandhan", "anthony" };
		String searchToken = "an";
		PhoneDirectory phoneDiorectory = new PhoneDirectory();
		phoneDiorectory.insertWords(words);
		phoneDiorectory.searchWords(searchToken);
	}
}

class PhoneDirectory {

	private TrieNode rootNode;

	public PhoneDirectory() {
		rootNode = new TrieNode();
	}

	public void insertWords(String[] words) {
		for (String word : words) {
			insertWord(word);
		}
	}

	private void insertWord(String word) {

		TrieNode currentNode = rootNode;

		for (int i = 0; i < word.length(); i++) {
			char character = word.charAt(i);

			Map<Character, TrieNode> childNodeMap = currentNode.getChildNodes();
			TrieNode childNode = childNodeMap.get(character);
			if (childNode == null) {
				childNode = new TrieNode();
				childNodeMap.put(character, childNode);
			}
			currentNode = childNode;
		}
		currentNode.setLastNode(Boolean.TRUE);
	}

	public void searchWords(String searchToken) {
		TrieNode currentNode = rootNode;

		for (int i = 0; i < searchToken.length(); i++) {
			char character = searchToken.charAt(i);
			Map<Character, TrieNode> childNodeMap = currentNode.getChildNodes();
			TrieNode nextNode = childNodeMap.get(character);
			if (nextNode == null) {
				System.out.println("No Elements Found !!!");
				return;
			}
			currentNode = nextNode;
		}
		System.out.println("Tokens for search string [" + searchToken + "] are :");

		displayTokens(currentNode, searchToken);

	}

	private void displayTokens(TrieNode currentNode, String previousToken) {

		if (currentNode.isLastNode()) {
			System.out.println(previousToken);
		}
		currentNode.getChildNodes().forEach((k, v) -> {
			if (v != null) {
				displayTokens(v, previousToken + k);
			}
		});
	}
}

class TrieNode {
	private final Map<Character, TrieNode> childNodes;
	private boolean lastNode;

	public TrieNode() {
		childNodes = new HashMap<Character, TrieNode>();
		for (char c = 'a'; c <= 'z'; c++) {
			childNodes.put(c, null);
		}
		lastNode = false;
	}

	public Map<Character, TrieNode> getChildNodes() {
		return childNodes;
	}

	public boolean isLastNode() {
		return lastNode;
	}

	public void setLastNode(boolean lastNode) {
		this.lastNode = lastNode;
	}
}
