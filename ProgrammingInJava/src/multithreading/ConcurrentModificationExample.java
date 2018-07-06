package multithreading;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExample {
	public static void main(String... args) {

		// Map<String, String> map = new ConcurrentHashMap<String, String>();
		Map<String, String> map = new HashMap<String, String>();

		map.put("key1", "naren1");
		map.put("key2", "naren2");
		map.put("key3", "naren2");
		
		Iterator<String> itr = map.keySet().iterator();
		
		while(itr.hasNext())
		{
			String key = itr.next();
			System.out.println("key=="+key);
			if(key.equals("key2"))
			{
				map.remove(key);
			}
			
		}

	}
}
