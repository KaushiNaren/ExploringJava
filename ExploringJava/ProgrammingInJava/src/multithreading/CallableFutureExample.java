package multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutorService;

/**
 * @author nranganmanian
 * 
 *         Callable Future Demo.
 *
 */
public class CallableFutureExample {

	public static void main(String... args) {

		ExecutorService pool = Executors.newSingleThreadExecutor();
		Future<String> future = pool.submit(CallableTask::callTask);
		pool.shutdown();
		System.out.println("Scheduled Callable Task !!!!");

		try {
			int count = 0;

			while (true) {
				if (future.isDone()) {
					System.out.println("Get---->" + future.get());
					break;
				}
				if (count > 4 && (future.isDone() == false)) {
					future.cancel(true);
					break;
				}

				Thread.sleep(5000);
				count++;
				System.out.println("Waitng for Response!!!!");
			}

		} catch (InterruptedException | ExecutionException e) {

			e.printStackTrace();
		}
	}
}

class CallableTask {

	public static String callTask() {
		System.out.println("Callable Task Started !!");
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException ex) {
			System.out.println("Task Interrupted !!!!!!1");

		}
		System.out.println("Callable Task Completed !!");
		return "success";

	}

}
