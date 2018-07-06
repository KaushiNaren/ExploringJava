package general;

// Java Program to shuffle a given array
import java.util.Random;
import java.util.Arrays;

public class RandamizeArray {
	// A Function to generate a random permutation of arr[]
	static void randomize(int arr[], int n) {
		// Creating a object for Random class
		Random r = new Random();

		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		System.out.println(Arrays.toString(arr));
		for (int i = 0 ; i < arr.length; i++) {

			// Pick a random index from 0 to i
			int j = r.nextInt(arr.length);
			System.out.println("Randam Number Index and Number=["+j+", "+arr[j]+"]");
			
			// Swap arr[i] with the element at random index
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		
			System.out.println(Arrays.toString(arr));

		}
		// Prints the random array
		System.out.println(Arrays.toString(arr));
	}

	// Driver Program to test above function
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8 };
		int n = arr.length;
		randomize(arr, n);
	}
}
// This code is contributed by Sumit Ghosh
