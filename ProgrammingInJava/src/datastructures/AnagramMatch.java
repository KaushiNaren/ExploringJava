package datastructures;

import java.util.Map;
import java.util.Arrays;

import java.util.HashMap;
import java.util.stream.*;
import java.util.List;
import java.util.ArrayList;

/**
 * @author Narendiran Rangan Manian
 *
 */
public class AnagramMatch {
	public static void main(String... args) {
		String[] array = { "dog", "god", "ogd", "bac", "abc", "cba", "abcd" };
		String toekn = "god";
	}

}

class AnagramDictionary {

	private TrieNodeA rootNode;

	public void insertWords(String[] words) {

	}

	private void insertWord(String orgToken) {
		char[] charAray = orgToken.toCharArray();
		Arrays.sort(charAray);

		if (rootNode == null) {
			rootNode = new TrieNodeA();
		}

		TrieNodeA currentNode = rootNode;

		for (char c : charAray) {

			Map<Character, TrieNodeA> childMap = currentNode.getChildMap();
			TrieNodeA childNode = childMap.get(c);
			if (childNode == null) {
				childMap.put(c, new TrieNodeA());
			}
			currentNode = childNode;

		}
		currentNode.setLastCharacter(true);
		currentNode.addList(orgToken);

	}

	public void printAllAnagrams(String inputToken) {

	}
}

class TrieNodeA {
	private final Map<Character, TrieNodeA> childMap;
	private boolean isLastCharacter;
	private List<String> anagramWordsList;

	public boolean isLastCharacter() {
		return isLastCharacter;
	}

	public void setLastCharacter(boolean isLastCharacter) {
		this.isLastCharacter = isLastCharacter;
	}

	public Map<Character, TrieNodeA> getChildMap() {
		return childMap;
	}

	public TrieNodeA() {

		childMap = new HashMap<Character, TrieNodeA>();
		anagramWordsList = new ArrayList<String>();
		IntStream.range('a', 'z').mapToObj(key -> Character.valueOf((char) key))
				.forEach(key -> childMap.put(key, null));

	}

	public void addList(String word) {
		anagramWordsList.add(word);
	}
}
