package designpatterns;

public class AbstractFactoryExample {

}

class GlobalCarFactory {
	public static Car buildCar(CarType carType) {
		FactoryLocation factoryLocation = FactoryLocation.INDIA;
		CarLocationFactory abstractCarFactory = null;

		switch (factoryLocation) {
		case INDIA:
			abstractCarFactory = new IndiaCarFctory();
			return abstractCarFactory.buildCar(carType);

		case USA:
			abstractCarFactory = new USACarFactory();
			return abstractCarFactory.buildCar(carType);
		case CHINA:
			abstractCarFactory = new ChinaCarFactory();
			return abstractCarFactory.buildCar(carType);
		}

		return null;
	}
}

enum FactoryLocation {
	INDIA, USA, CHINA;
}

class IndiaCarFctory extends CarLocationFactory {

	@Override
	public Car buildCar(CarType carType) {

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

class USACarFactory extends CarLocationFactory {

	@Override
	public Car buildCar(CarType carType) {

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

class ChinaCarFactory extends CarLocationFactory {

	@Override
	public Car buildCar(CarType carType) {

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

abstract class CarLocationFactory {
	public abstract Car buildCar(CarType carType);
}
