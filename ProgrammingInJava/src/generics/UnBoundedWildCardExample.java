package generics;

import java.util.Arrays;
import java.util.List;

public class UnBoundedWildCardExample {

	public static void main(String... args) 
	{
		UnBoundedWildCard ub = new UnBoundedWildCard();
		List<Integer> listInteger = Arrays.asList(1, 2, 3, 4, 5);
		ub.printAll_1(listInteger);
		ub.printAll_2(listInteger);
 
	}

}

class UnBoundedWildCard {

	public <T> void printAll_1(List<T> list) {
		list.forEach(System.out::println);

	}

	public void printAll_2(List<?> list) {
		list.forEach(System.out::println);

	}
}
