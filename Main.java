package arraylist;

public class Main {

	public static void main(String[] args) {
		CarArrayList2 carList = new CarArrayList2();
		for (int i = 0; i < 13; i++) {
			Car car = new Car("BMW", i);
			carList.add(car);
		}

		Car[] cars = carList.getAll();
		
		for(Car car:cars) {
			System.out.println(car);
		}
		
		System.out.println("------------------------");
		Car car2 = new Car("Merc",2);
		carList.add(car2);
		carList.remove(car2);
		carList.add(car2, 12);
		
		cars = carList.getAll();
		
		for(Car car:cars) {
			System.out.println(car);
		}
		


	}

}
