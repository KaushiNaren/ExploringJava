package multithreading;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {

	public static void main(String... args) {

	System.out.println(1/2);

	}

}

class CFTask {

	public static void cTask() {
		System.out.println(Thread.currentThread().getName() + " !!!!");
	}
}
