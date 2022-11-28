package arraylist;

import java.util.Objects;
 
public class Car /* implements Comparable<Car> если имеем доступ к классу Car, но если не имеем смотреть в main */ {
	private String brand;
	private int number;
	
	public Car(String brand, int number) {
		this.brand = brand;
		this.number = number;
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public int getNum() {
		return this.number;
	}
	
	public void setNum(int num) {
		this.number = num;
	}
	
	@Override
	public String toString() {
		return "brand: " + this.brand + "\nnumber: " + this.number + "\n ------------------------";
	}
	
	
	@Override
	public boolean equals(Object obj) {
//		if(obj instanceof Car) {// проверяем является ли этот объект объектом класса Car
//			Car car = (Car) obj;// downcast
//			if(car.brand.equals(this.brand) && car.number == this.number) {
//				return true;
//			} else {
//				return false;
//			}
//		} else {
//			return false;
//		}
		
		// 2-й способ более правильный
		
		if(this == obj) return true;// сразу проверяет ссылки если ссылки равны то автоматически поля тоже равны
		if(obj == null || getClass() != obj.getClass()) return false;// getClass() возвращает имя класса которыму принадлежат эти классы и если классы не равны то сравнивать не имеет значение
		Car car = (Car) obj;
		return number == car.number && Objects.equals(brand, car.brand);
	}
	
	
	@Override 
	public int hashCode() {
		return Objects.hash(brand,number);// хеширует brand и number и возвращает = так правильнее
		//return brand.hashCode() + number;// мы переопределили hashCode чтобы он завис от полей , но hashCode() в строках уже переопределен и он проверяет их значение
	}

	
//
//	@Override
//	public int compareTo(Car o) {
//		// Если сортировка будет по номеру
//		if(number < o.number) {
//			return -1;
//		} else if(number == o.number) {
//			return 0;
//		} else {
//			return 1;
//		}
//		
//		// если нужно отсортировать по алфавиту
//		return brand.compareTo(o.brand);// compareTo переопределен у класса String
//	}
}
