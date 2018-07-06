package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

import java.util.Date;

public class RentrantLockExample {
	public static void main(String... args) {

		ReentrantLock lock = new ReentrantLock();
		ExecutorService pool = Executors.newFixedThreadPool(2);
		pool.execute(new RentractnTask(lock, "Job1")::task);
		pool.execute(new RentractnTask(lock, "Job2")::task);	
		pool.shutdown();
	}
}

class RentractnTask {
	private final ReentrantLock lock;
	private final String taskName;

	public RentractnTask(ReentrantLock lock, String name) {
		this.lock = lock;
		this.taskName = name;

	}

	public void task() {

		boolean done = false;
		while (!done) {

			// Getting outer Lock
			boolean flag = lock.tryLock();
			try {
				if (flag) {

					System.out.println(taskName + "Acquired outerlock and doing outer work, Lock Count::"
							+ lock.getHoldCount() + " " + new Date());
					Thread.sleep(10000);
					
					lock.lock();
					System.out.println(taskName + "Acquired inner and doing outer work, Lock Count::"
							+ lock.getHoldCount() + " " + new Date());
					Thread.sleep(10000);					
					lock.unlock();
					System.out.println(taskName + "Release inner lock  and work done... Lock Count::"
							+ lock.getHoldCount() + " " + new Date());
					lock.unlock();
					System.out.println(taskName + "Release outer lock  and work done... Lock Count::"
							+ lock.getHoldCount() + " " + new Date());
					done = true;
				} else {
					System.out.println(taskName + " waiting for lock... Lock Count::"+ lock.getHoldCount() + " "+new Date());
					Thread.sleep(2000);
				}
			} catch (InterruptedException ex) {

			}

		}
	}
}
