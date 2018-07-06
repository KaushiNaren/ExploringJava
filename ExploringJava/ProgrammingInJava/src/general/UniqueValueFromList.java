package general;

import java.util.Arrays;
import java.util.List;

public class UniqueValueFromList 
{
	public static void main(String... args)
	{
		List<String> list = Arrays.asList("naren111","naren2","naren333","naren4","naren111","aaa","naren333");
		list.stream().distinct().forEach(System.out::println);
	}

}
