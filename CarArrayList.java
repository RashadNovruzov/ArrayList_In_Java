package arraylist;

import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList implements CarList {
	private Car[] array = new Car[10];
	int size = 0;

	@Override
	public Car get(int index) {

		this.checkIndex(index);
		return this.array[index];

	}
	
	@Override
	public Car[] getAll() {
		return Arrays.copyOf(array, size);
	}

	@Override
	public boolean add(Car car) {
		increaseArray();
		this.array[size] = car;
		size++;
		return true;
	}

	@Override
	public boolean add(Car car, int index) {
		increaseArray();
		
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		
		System.arraycopy(array, index, array, index+1, size-index);// array - какой массив будем копировать, index - с какого элемента будем перемещать, index+1- на сколько будем премещать, size-index - сколько элементов будут перемещены
		// этот метод быстрее чем наше так как он написан на C++ и работает прямо с памятью . В отличии от нашего метода который по одному пермещали, этот метод все перемещает сразу
		
		array[index] = car;
		size++;
		return true;
	}

	@Override
	public boolean remove(Car car) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(car)) {
				return removeAt(i);
			}
		}
		return false;
	}

	@Override
	public boolean removeAt(int index) {

		checkIndex(index);
        System.arraycopy(array, index + 1, array, index, size - 1 - index);
		size--;
		return true;
	}

	@Override
	public int size() {

		return this.size;
	}

	@Override
	public void clear() {
		array = new Car[10];
		size = 0;

	}
	@Override 
	public boolean contains(Car car) {
		for(int i = 0; i < size; i++) {
			if(array[i].equals(car)) {
				return true;
			}
		}
		return false;
	}

	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	}

	private void increaseArray() {
		if (size >= array.length) {

			array = Arrays.copyOf(array, array.length * 2);

//			Car[] newArray = new Car[array.length*2];
//			for(int i = 0; i < array.length; i++) {
//				newArray[i] = array[i];
//			}
//			array = newArray;
		}
	}

	@Override
	public Iterator<Car> iterator() {
		// TODO Auto-generated method stub
		return new Iterator<Car>(){
			int index = 0;
			@Override
			public boolean hasNext() {
				
				return index < size;
			}

			@Override
			public Car next() {
				Car car = array[index];
				index++;
				return car;
			}
			
		};
	}

}
