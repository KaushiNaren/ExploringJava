package java8;

import java.util.Map;
import java.util.HashMap;

public class IterateMap {
	public static void main(String... args) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "naren1");
		map.put("key2", "naren2");
		map.put("key3", "naren3");

		for (Map.Entry<String, String> entry : map.entrySet()) {
			// System.out.println(entry.getKey() + " ->" + entry.getValue());
		}

		//map.forEach((k, v) -> System.out.println(k + "->" + v));
		
		map.keySet().stream().forEach(key -> System.out.println(key+"->"+map.get(key)));
	}

}
