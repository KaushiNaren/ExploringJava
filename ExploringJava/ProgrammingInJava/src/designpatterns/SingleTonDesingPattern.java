package designpatterns;

public class SingleTonDesingPattern {
	public static void main(String... args) {

	}

}

// Doucble Check Locking
class SingleTonObject1 {

	private static volatile SingleTonObject1 instance = null;

	private SingleTonObject1() {

	}

	public static SingleTonObject1 getInstance() {
		if (instance == null) {
			synchronized (SingleTonObject1.class) {
				if (instance == null) {
					instance = new SingleTonObject1();
				}
			}
		}
		return instance;
	}
}

// Option2
class SingletonObject2 {

	private SingletonObject2() {
	}

	private static class SingletonObject2Holder {
		private static final SingletonObject2 INSTANCE = new SingletonObject2();
	}

	public static SingletonObject2 getInstance() {
		return SingletonObject2Holder.INSTANCE;
	}

	public Object readResolve() {
		return getInstance();
	}

}