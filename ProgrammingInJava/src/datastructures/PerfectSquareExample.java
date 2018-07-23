package datastructures;

public class PerfectSquareExample {
	private static int iterationCount = 0;

	public static void main(String... args) {

		isSquareBinarySearch(90000);
		isSquareLinearSearch(90000);

	}

	private static void isSquareBinarySearch(int originalNumber) {
		iterationCount = 0;
		isSquareBinarySearch(originalNumber, 0, originalNumber);

	}

	private static void isSquareBinarySearch(int originalNumber, int lower, int higher) {
		iterationCount++;

		if (lower > higher) {
			System.out.println(originalNumber + "  Is not Perfect Square !!! Iteration Count with Binary Search->"
					+ iterationCount);
			return;
		}
		int midValue = (lower + higher) / 2;
		int squareValue = midValue * midValue;

		if (originalNumber == squareValue) {
			System.out.println(
					originalNumber + "  Is a Perfect Square !!! Iteration Count with Binary Search->" + iterationCount);
			return;
		}

		if (squareValue > originalNumber) {
			isSquareBinarySearch(originalNumber, lower, midValue - 1);

		} else if (squareValue < originalNumber) {
			isSquareBinarySearch(originalNumber, midValue + 1, higher);
		}
	}

	private static void isSquareLinearSearch(int originalNumber) {

		for (int i = 1; i < originalNumber; i++) {
			int squareValue = i * i;
			if (squareValue == originalNumber) {
				System.out
						.println(originalNumber + "  Is a Perfect Square !!! Iteration Count with Linear Search->" + i);
				break;
			} else if (squareValue > originalNumber) {
				System.out.println(
						originalNumber + "  Is not Perfect Square !!! Iteration Count with Linear Search->" + i);
				break;

			}

		}

	}
}