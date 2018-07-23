package datastructures;

public class FindElementInSortedArray {
	public static void main(String... args) {
		int[] array1 = { 1, 3, 7, 8, 11, 12, 45, 46, 56, 58 };
		int[] array2 = { 1, 3, 7, 8, 11, 12, 45, 46, 56, 58, 65 };

		FindElementImpl find = new FindElementImpl();

		find.findIndex(array1, 46);
		find.findIndex(array1, 58);
		find.findIndex(array1, 13);
		find.findIndex(array1, 58);

		find.findIndex(array2, 48);
		find.findIndex(array2, 65);

	}

}

class FindElementImpl {

	public void findIndex(int[] numberArray, int givenNumber) {
		findElement(numberArray, 0, numberArray.length, givenNumber);

	}

	public void findElement(int[] numberArray, int lower, int higher, int givenNumber) {

		if (lower > higher) {
			System.out.println("Original Elment " + givenNumber + " Not Found !!!");
			return;
		}
		int midPoint = (lower + higher) / 2;

		if (numberArray[midPoint] == givenNumber) {
			System.out.println(givenNumber + " Found at the positon-->" + midPoint);
			return;
		}

		if (numberArray[midPoint] > givenNumber) {
			higher = midPoint - 1;

		} else if (numberArray[midPoint] < givenNumber) {
			lower = midPoint + 1;
		}

		findElement(numberArray, lower, higher, givenNumber);
	}

}
