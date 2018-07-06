package multithreading;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.stream.*;

/**
 * @author Narendiran Rangan Manian
 * 
 *         Countdown Latch Basic Example
 *
 */
public class CountdownLatch {
	public static void main(String... args) {
		CountDownLatch countDownLatch = new CountDownLatch(4);
		IntStream.range(1, 5)
				.forEach(count -> new Thread(new CDTask(countDownLatch, count)::cTask, "Thread" + count).start());
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Main Thread completed !!!!");
	}
}

class CDTask {
	private final CountDownLatch cdLatch;
	private final long sleepTime;

	public CDTask(CountDownLatch cdLatch, long sleepTime) {
		this.cdLatch = cdLatch;
		this.sleepTime = sleepTime;
	}

	public void cTask() {
		try {
			Thread.sleep(this.sleepTime * 3 * 1000);
			System.out.println(
					Thread.currentThread().getName() + "--->" + new SimpleDateFormat("hh:mm:ss").format(new Date()));
			this.cdLatch.countDown();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}
}
