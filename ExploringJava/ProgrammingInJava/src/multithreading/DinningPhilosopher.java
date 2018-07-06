package multithreading;

public class DinningPhilosopher {

	public static void main(String... args) {
		Philosopher[] philosopher = new Philosopher[5];
		Object[] forks = new Object[philosopher.length];

		for (int i = 0; i < forks.length; i++) {
			forks[i] = new Object();
		}

		for (int i = 0; i < philosopher.length; i++) {
			Object leftFork = forks[i];
			Object rightFork = forks[(i + 1) % forks.length];
			if (i == (philosopher.length - 1)) {
				philosopher[0] = new Philosopher(rightFork, leftFork);
			} else {
				philosopher[0] = new Philosopher(leftFork, rightFork);
			}
			Thread thread = new Thread(philosopher[0]::task, "Philosopher" + (i + 1));
			thread.start();
		}
	}
}

class Philosopher {

	private final Object leftFork, rightFork;

	public Philosopher(Object leftFork, Object rightFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}

	public void task() {
		while (true) {
			eat();
			think();
		}
	}

	public void eat() {
		System.out.println(Thread.currentThread().getName() + " is ready to eat");
		grabLeftFork();
		System.out.println(Thread.currentThread().getName() + " Finished Eating");
		think();

	}

	public void think() {
		System.out.println(Thread.currentThread().getName() + " Is Thinking");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
		}

	}

	private void grabLeftFork() {
		synchronized (this.leftFork) {
			System.out.println(Thread.currentThread().getName() + " grabed Left Fork!");
			synchronized (this.rightFork) {

				grabRightFork();
				System.out.println(Thread.currentThread().getName() + " is eating");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				leaveRightFork();
			}
			leaveLeftFork();
		}
	}

	private void grabRightFork() {
		System.out.println(Thread.currentThread().getName() + " grabed Right Fork !");

	}

	private void leaveLeftFork() {
		System.out.println(Thread.currentThread().getName() + " dropped Left Fork");

	}

	private void leaveRightFork() {
		System.out.println(Thread.currentThread().getName() + " dropped Right Fork");
	}

}
