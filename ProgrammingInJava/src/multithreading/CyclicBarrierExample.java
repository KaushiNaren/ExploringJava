package multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Narendiran Rangan Manian
 * 
 *         Cyclic Barrier Basic Example
 *
 */
public class CyclicBarrierExample {

	public static void main(String... args) {
		CyclicBarrier cb = new CyclicBarrier(3, BarrierAction::barrierAction);
		new Thread(new CBTask1(cb)::task1).start();
		new Thread(new CBTask2(cb)::task2).start();
	}

}

class BarrierAction {
	public static void barrierAction() {
		System.out.println(Thread.currentThread().getName() + "  Barriet Action Hit !!!!!!");

	}
}

class CBTask1 {
	private final CyclicBarrier cb;

	public CBTask1(CyclicBarrier cb) {
		this.cb = cb;
	}

	public void task1() {
		try {
			Thread.sleep(5000);

			System.out.println(Thread.currentThread().getName() + "  hit the barrier");
			cb.await();
			System.out.println(Thread.currentThread().getName() + "  completed execution !");

		} catch (InterruptedException | BrokenBarrierException ex) {
			ex.printStackTrace();
		}

	}

}

class CBTask2 {
	private final CyclicBarrier cb;

	public CBTask2(CyclicBarrier cb) {
		this.cb = cb;
	}

	public void task2() {
		try {
			Thread.sleep(15000);

			System.out.println(Thread.currentThread().getName() + " hit the barrier");
			cb.await();
			System.out.println(Thread.currentThread().getName() + "  completed execution !");
		} catch (InterruptedException | BrokenBarrierException ex) {
			ex.printStackTrace();
		}

	}

}
