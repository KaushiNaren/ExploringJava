package multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

/**
 * @author Narendiran Rangan Manian
 * 
 *         Dining Philosophers Problem Demo
 *
 */
public class DiningPhilosopher1 {

	public static void main(String... args) {

		DPhilosopher[] philosophers = new DPhilosopher[5];
		Object[] forks = new Object[philosophers.length];
		IntStream.range(0, 5).forEach(count -> {
			forks[count] = new Object();
		});
		ExecutorService pool = Executors.newFixedThreadPool(5);

		IntStream.range(0, 5).forEach((count) -> {
			Object leftFork = forks[count];
			Object rightFork = forks[(count + 1) % philosophers.length];
			if (count == (philosophers.length - 1)) {
				philosophers[count] = new DPhilosopher(rightFork, leftFork, "PHILOSOPHER->" + (count + 1));
			} else {
				philosophers[count] = new DPhilosopher(leftFork, rightFork, "PHILOSOPHER->" + (count + 1));
			}
			pool.execute(philosophers[count]::eat);

		});
		pool.shutdown();
	}
}

class DPhilosopher {
	private final Object leftFork;
	private final Object rightFork;
	private final String name;

	public DPhilosopher(Object leftFork, Object rightFork, String name) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.name = name;
	}

	public void eat() {
		while (true) {
			try {
				System.out.println(this.name + " ready to eat !!");

				synchronized (leftFork) {
					grabLeftFork();
					synchronized (rightFork) {
						grabRightFork();
						System.out.println(this.name + " is eating  !!");
						Thread.sleep(3000);
						dropRightFork();
					}
					dropLeftFork();
				}
				think();
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	private void grabLeftFork() {
		System.out.println(this.name + " grabbed left fork !!");
	}

	private void grabRightFork() {
		System.out.println(this.name + " grabbed right fork !!!");
	}

	private void dropLeftFork() {
		System.out.println(this.name + " dropped left fork  !!");
	}

	private void dropRightFork() {
		System.out.println(this.name + " dropped right fork !!");
	}

	private void think() throws InterruptedException {
		System.out.println(this.name + " is thinking  !!");
		Thread.sleep(3000);
	}
}
