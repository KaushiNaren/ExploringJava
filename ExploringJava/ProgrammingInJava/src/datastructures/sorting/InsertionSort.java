package datastructures.sorting;

import java.util.Arrays;

/**
 * @author nranganmanian
 * 
 * Best and Worst : O(n2)
 *
 */
public class InsertionSort {

	public static void main(String... args) {
		int[] numArray = { 5, 4, 3, 2, 1 };

		for (int i = 1; i < numArray.length; i++) {

			for (int j = i; j > 0; j--) {
				if (numArray[j] < numArray[j - 1]) {
					int temp = numArray[j - 1];
					numArray[j - 1] = numArray[j];
					numArray[j] = temp;
				}

			}
		}
		
		System.out.println(Arrays.toString(numArray));
	}

}
