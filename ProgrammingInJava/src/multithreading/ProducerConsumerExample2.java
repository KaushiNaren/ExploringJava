package multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * @author nranganmanian
 * 
 *         Producer Consumer demo using SynchronoueQueue
 *
 */
public class ProducerConsumerExample2 {
	public static void main(String... args) {
		ExecutorService pool = Executors.newFixedThreadPool(2);
		Shop2 shop = new Shop2();
		ProducerConsumer2 pc = new ProducerConsumer2(shop);
		pool.execute(pc::produceTask);
		pool.execute(pc::consumeTask);
		pool.shutdown();
	}
}

class ProducerConsumer2 {
	private final Shop2 shop;
	private final List<String> items = Arrays.asList("item1", "item2", "item3", "item4");

	public ProducerConsumer2(Shop2 shop) {
		this.shop = shop;
	}

	public void produceTask() {
		items.forEach(x -> {
			this.shop.produce(x);
			System.out.println(x + " Produced");
		});
	}

	public void consumeTask() {
		int count = 0;
		while (count < items.size()) {
			String item = this.shop.consume();
			System.out.println(item + " Consumed");
			count++;
		}
	}
}

class Shop2 {
	private final SynchronousQueue<String> queue = new SynchronousQueue<String>(true);

	public void produce(String item) {
		try {
			queue.put(item);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String consume() {
		try {
			return queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}
}
