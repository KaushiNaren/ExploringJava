package general;

import java.util.HashSet;
import java.util.Set;

public class StringPermutationCombination {

	public static void main(String... args) {
		Set<String> permuatedWords = permuteString("abc");
		permuatedWords.forEach(System.out::println);

		
	}

	private  static String charInsert(String str, char initial, int j) {
		String begin = str.substring(0, j);
		//System.out.println("begin=" + begin);
		String end = str.substring(j);
		//System.out.println("end=" + end);
		//System.out.println(begin + initial + end);
		//System.out.println("=======================");
		return begin + initial + end;
	}

	private static Set<String> permuteString(String token) {
		Set<String> permWords = new HashSet<String>();

		if (token.length() == 1) {
			permWords.add(token);
			return permWords;
		}
		char firstChar = token.charAt(0);
		Set<String> remainsWords = permuteString(token.substring(1, token.length()));
		for (String string : remainsWords) {
			for (int i = 0; i <= string.length(); i++) {
				permWords.add(charInsert(string, firstChar, i));
			}
		}

		return permWords;

	}
}
