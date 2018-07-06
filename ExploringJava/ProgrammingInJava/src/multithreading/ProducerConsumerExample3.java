package multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Narendiran Rangan Manian
 * 
 *         Producer Consumer Traditional Example
 *
 */
public class ProducerConsumerExample3 {

	public static void main(String... args) {
		Shop3 shop = new Shop3();
		Thread producerThread = new Thread(new Producer(shop));
		producerThread.start();

		Thread consumerThread = new Thread(new Consumer(shop));
		consumerThread.start();

	}

}

class Producer implements Runnable {
	private final Shop3 shop;
	private final List<String> items = Arrays.asList("idly", "vada", "dosa", "briyani");

	public Producer(Shop3 shop) {
		this.shop = shop;
	}

	public void run() {
		items.forEach(item -> {

			synchronized (shop) {
				try {
					if (shop.isListFull()) {
						shop.wait();
					}
					this.shop.produce(item);
					shop.notify();
				} catch (InterruptedException ex) {

				}
			}
		});
	}

}

class Consumer implements Runnable {

	private final Shop3 shop;

	public Consumer(Shop3 shop) {
		this.shop = shop;
	}

	public void run() {
		while (true) {
			synchronized (this.shop) {
				try {
					if (this.shop.isListEmpty()) {
						this.shop.wait();
					}
					String item = this.shop.consume();
					if (item.equals("briyani")) {
						break;
					}
					this.shop.notify();
				} catch (InterruptedException ex) {

				}
			}
		}
	}
}

class Shop3 {
	private final List<String> list = new ArrayList<String>();

	public void produce(String item) {
		list.add(item);
		System.out.println(item + " Produced");

	}

	public String consume() {
		String item = list.remove(0);
		System.out.println(item + " Consumed");
		return item;
	}

	public boolean isListEmpty() {
		return list.isEmpty();
	}

	public boolean isListFull() {
		return list.size() == 1;
	}
}
