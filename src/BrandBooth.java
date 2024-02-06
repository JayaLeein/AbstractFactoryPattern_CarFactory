
interface Sedan {
	void turnOnHeadLight();
}

interface SUV {
	void turnOnHeadLight();
}

class BMWM5 implements Sedan {
	
	@Override
	public void turnOnHeadLight() {
		System.out.println("BMW M5 headlight");
	}
}

class BMWX5 implements SUV {
	
	@Override
	public void turnOnHeadLight() {
		System.out.println("BMW X5 headlight");
	}
}

class TeslaModelS implements Sedan {
	
	@Override
	public void turnOnHeadLight() {
		System.out.println("Tesla ModelS headlight");
	}
}

class TeslaModelY implements SUV {

	@Override
	public void turnOnHeadLight() {
		System.out.println("Tesla ModelY headlight");
	}
}

interface CarFactory {
	Sedan createSedan();
	SUV createSUV();
}

class BMWFactory implements CarFactory {

	@Override
	public Sedan createSedan() {
		return new BMWM5();
	}

	@Override
	public SUV createSUV() {
		return new BMWX5();
	}
	
}

class TeslaFactory implements CarFactory {

	@Override
	public Sedan createSedan() {
		return new TeslaModelS();
	}

	@Override
	public SUV createSUV() {
		return new TeslaModelY();
	}
	
}

public class BrandBooth {
	
	private Sedan sedan;
	private SUV suv;

	public static void main(String[] args) {
		
		BMWFactory bmwFactory = new BMWFactory();
		BrandBooth bmwBooth = new BrandBooth(bmwFactory);
		bmwBooth.showTime();
		
		TeslaFactory teslaFactory = new TeslaFactory();
		BrandBooth teslaBooth = new BrandBooth(teslaFactory);
		teslaBooth.showTime();

	}
	
	public BrandBooth(CarFactory factory) {
		this.sedan = factory.createSedan();
		this.suv = factory.createSUV();
	}
	
	public void showTime() {
		sedan.turnOnHeadLight();
		suv.turnOnHeadLight();
	}

}
