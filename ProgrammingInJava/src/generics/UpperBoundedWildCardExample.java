package generics;

import java.util.Arrays;
import java.util.List;

public class UpperBoundedWildCardExample {
	public static void main(String... args) {

		List<Integer> listInteger = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Double> listDouble = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0, 6.0);
		List<Number> listNumber = Arrays.asList(1, 2, 3, 4, 5, 6);

		UpperBoundedWildCard ub = new UpperBoundedWildCard();
		System.out.println(ub.sum1(listNumber));
		// System.out.println(ub.sum1(listDouble)); Compiler Error
		// System.out.println(ub.sum1(listInteger)); Compiler Error

		System.out.println(ub.sum2(listDouble));
		System.out.println(ub.sum2(listInteger));

	}

}

class UpperBoundedWildCard {

	public double sum1(List<Number> list) {
		return list.stream().mapToDouble(i -> i.doubleValue()).sum();
	}

	public double sum2(List<? extends Number> list) {
		return list.stream().mapToDouble(i -> i.doubleValue()).sum();

	}
}
