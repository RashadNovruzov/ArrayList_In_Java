package arraylist;

import java.util.Arrays;
import java.util.Iterator;

public class CarArrayList2 implements CarList {
	
	private Car[] array = new Car[10];
	public int size = 0;
	
	@Override
	public Car get(int index) {
		
		checkIndex(index);
		return array[index];
	}
	

	@Override
	public boolean add(Car car) {
		this.increaseArray();
		array[size] = car;
		size++;
		return true;
	}

	@Override
	public boolean add(Car car, int index) {
		
		increaseArray();
		
		if(index > size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		
		System.arraycopy(array, index, array, index+1, size-index);
		array[index] = car;
		size++;
		return true;
		
	}

	@Override
	public boolean remove(Car car) {
		for(int i = 0; i < size; i++) {
			if(array[i].equals(car)) {
				removeAt(i);
			}
		}
		return false;
	}

	@Override
	public boolean removeAt(int index) {
		this.checkIndex(index);
		System.arraycopy(array, index+1, array, index, size-index-1);
		size--;
		return true;
	}

	@Override
	public int size() {
		
		return size;
	}

	@Override
	public void clear() {
		array = new Car[10];
		size = 0;
		
	}
	
	@Override
	public Car[] getAll() {
		return Arrays.copyOf(array, size);
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
	

	private void checkIndex(int index) {
		if(index >= size || index < 0 ) {
			throw new IndexOutOfBoundsException();
		}
	}
	
	private void increaseArray() {
		if(size >= array.length) {
			array = Arrays.copyOf(array, array.length*2);// возвращает копию переданного как параметр массива с длиной 2 раза больше первоначального
		}
	}

}
