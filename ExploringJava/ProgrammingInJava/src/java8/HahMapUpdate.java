package java8;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HahMapUpdate 
{
	public static void main(String... args)
	{
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1","naren1");
		map.put("key2","naren2");
		map.put("key3","naren3");		
		map.forEach((k ,v) -> System.out.println(k + " , " + v));		
		System.out.println("============== 1. Compute If Present=========================");
		map.computeIfPresent("key3",(k, v) ->  "3333333333333");
		map.forEach((k ,v) -> System.out.println(k + " , " + v));	
		System.out.println("============== 1. Compute If Absetn=========================");
		map.computeIfAbsent("key5", k-> "55555555555");
		map.forEach((k ,v) -> System.out.println(k + " , " + v));	
		
		
		
		
	}

}

