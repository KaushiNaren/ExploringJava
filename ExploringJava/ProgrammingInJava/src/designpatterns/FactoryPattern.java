package designpatterns;

/**
 * @author Narendiran Rangna Manian
 * 
 *         Simple Factory Pattern Demo, Reference : How to do i java
 *
 */
public class FactoryPattern {
	public static void main(String... args) {

		System.out.println(CarFactory.build(CarType.SEDAN));
		System.out.println(CarFactory.build(CarType.HATCHBACK));
		System.out.println(CarFactory.build(CarType.LUXURY));
	}
}

enum CarType {
	SEDAN, HATCHBACK, LUXURY;

}

class CarFactory {

	public static Car build(CarType carType) {
		Car car = null;
		switch (carType) {
		case SEDAN:
			car = new Sedan();

			break;
		case HATCHBACK:
			car = new HatchBack();
			break;
		case LUXURY:
			car = new LuxuryCar();
			break;
		}
		return car;
	}
}

abstract class Car {
	protected CarType carType;

	public Car(CarType carType) {
		this.carType = carType;
		System.out.println("Caling Super Construcot!!!!!!");
		construt();
	}

	public abstract void construt();

	public CarType getType() {
		return this.carType;
	}
}

class HatchBack extends Car {

	public HatchBack() {
		super(CarType.HATCHBACK);

	}

	@Override
	public void construt() {
		System.out.println("Building " + this.carType + " Back Car");

	}

}

class Sedan extends Car {

	public Sedan() {
		super(CarType.SEDAN);

	}

	@Override
	public void construt() {
		System.out.println("Building " + this.carType + " Back Car");

	}

}

class LuxuryCar extends Car {

	public LuxuryCar() {
		super(CarType.LUXURY);

	}

	@Override
	public void construt() {
		System.out.println("Building " + this.carType + " Back Car");

	}

}
