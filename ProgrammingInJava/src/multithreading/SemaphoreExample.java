package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

/**
 * @author Narendiran Rangan manian - Semaphore Example.
 *
 */
public class SemaphoreExample {
	private static final int MAX_CONNECTIONS = 4;

	public static void main(String... args) {
		DataBase dbConnetion = new DataBase(MAX_CONNECTIONS);
		ExecutorService pool = Executors.newFixedThreadPool(10);
		IntStream.range(0, 10).forEach((x) -> pool.execute(new User(dbConnetion, "User" + (x + 1))::commitTransaction));
		pool.shutdown();
	}
}

class DataBase {

	private final Semaphore semaphore;

	public DataBase(int maxPermit) {
		this.semaphore = new Semaphore(maxPermit);
	}

	public void commitTranaction(String userName) {
		try {
			this.semaphore.acquire();
			Thread.sleep(5000);

			System.out.println(userName + " successfully commited transaction");
			this.semaphore.release();
		} catch (InterruptedException e) {

		}
	}
}

class User {

	private final DataBase dbConnetion;
	private final String name;

	public User(DataBase dbConnetion, String name) {
		this.dbConnetion = dbConnetion;
		this.name = name;
	}

	public void commitTransaction() {
		while (true) {
			dbConnetion.commitTranaction(this.name);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {

			}
		}
	}
}
