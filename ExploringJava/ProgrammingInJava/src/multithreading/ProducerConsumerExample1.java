package multithreading;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Narendiran Rangan Manian
 * 
 *         Producer Consumer with Threads.
 *
 */
public class ProducerConsumerExample1 {
	public static void main(String... args) {
		ProducerAndConsumer pc = new ProducerAndConsumer(new Shop());
		Thread producerthread = new Thread(pc::produce);
		Thread consumerThread = new Thread(pc::consume);
		producerthread.start();
		consumerThread.start();
	}
}

class ProducerAndConsumer {

	List<String> items = Arrays.asList("cake", "biscuit", "beer", "honey");
	private final Shop shop;

	public ProducerAndConsumer(Shop shop) {
		this.shop = shop;
	}

	public void produce() {
		items.forEach(x -> {

			shop.produce(x);
			System.out.println("Produced Item :" + x);
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
	}

	public void consume() {
		int count = 1;
		while (count <= items.size()) {
			System.out.println("Consumed Item:" + this.shop.consume());
			count++;
		}
	}
}

class Shop {
	private BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(1);

	public void produce(String item) {
		try {
			blockingQueue.put(item);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String consume() {
		String item = null;
		try {
			item = blockingQueue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return item;
	}
}
