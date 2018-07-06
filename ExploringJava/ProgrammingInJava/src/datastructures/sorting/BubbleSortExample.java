package datastructures.sorting;

import java.util.Arrays;

/**
 * @author nranganmanian
 * 
 * Worst Case : O(n2)
 * Best Case : O(n)
 *
 */
public class BubbleSortExample {
	public static void main(String... args) {
		int[] numArray = { 1, 2, 3, 4, 5};

		for (int i = 0; i < numArray.length; i++) {
			boolean swap = false;
			for (int j = 0; j < numArray.length - i - 1; j++) {
				if (numArray[j] > numArray[j + 1]) {
					int temp = numArray[j];
					numArray[j] = numArray[j + 1];
					numArray[j + 1] = temp;
					swap = true;
				}
			}
			if (swap == false) {
				break;
			}
			System.out.println(Arrays.toString(numArray));
		}
		System.out.println(Arrays.toString(numArray));
	}

}
