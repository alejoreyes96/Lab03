package arrayIndexList;

import indexList.IndexList;

public class ArrayIndexList<E> implements IndexList<E> {
	private static final int INITCAP = 1; 
	private static final int CAPTOAR = 1; 
	private static final int MAXEMPTYPOS = 2; 
	private E[] element; 
	private int size; 

	public ArrayIndexList() { 
		element = (E[]) new Object[INITCAP]; 
		size = 0; 
	} 
	

	public void add(int index, E e) throws IndexOutOfBoundsException {
		
		if(index>size || index<0){
			throw new IndexOutOfBoundsException("add: Invalid Index = " + index );
		}
		if(size == element.length){
			changeCapacity(CAPTOAR);
			
		}
		element[index] = e;
		size++;
	}


	public void add(E e) {
		
		if(size == element.length){
			changeCapacity(CAPTOAR);
			
		}
		element[size] = e;
		size++;
		
	}


	public E get(int index) throws IndexOutOfBoundsException {
		if(index>=size || index<0){
			throw new IndexOutOfBoundsException("get: Invalid Index = " + index);
		}
		return element[index]; 
	}


	public boolean isEmpty() {
		return size == 0;
	}


	public E remove(int index) throws IndexOutOfBoundsException {
		if(index>=size || index<0){
			throw new IndexOutOfBoundsException("remove: Invalid Index = " + index);
		}
		if(element.length>size+1)
			changeCapacity(-CAPTOAR);
		E elementRemoved = element[index];
		if(index<size-1){
			moveDataOnePositionTL(index+1, size-1);
		}
		
		size--;
		return elementRemoved;
	}


	public E set(int index, E e) throws IndexOutOfBoundsException {
		if(index>=size || index<0){
			throw new IndexOutOfBoundsException("set: Invalid Index = " + index);
		}
		E elementRemoved = element[index];
		element[index] = e; 
		return elementRemoved;
	}


	public int size() {
		return size;
	}	
	
	public int capacity(){
		return element.length;
	}
	
	
	
	// private methods  -- YOU CAN NOT MODIFY ANY OF THE FOLLOWING
	// ... ANALYZE AND USE WHEN NEEDED
	
	// you should be able to decide when and how to use
	// following method.... BUT NEED TO USE THEM WHENEVER
	// NEEDED ---- THIS WILL BE TAKEN INTO CONSIDERATION WHEN GRADING
	
	private void changeCapacity(int change) { 
		int newCapacity = element.length + change; 
		E[] newElement = (E[]) new Object[newCapacity]; 
		for (int i=0; i<size; i++) { 
			newElement[i] = element[i]; 
			element[i] = null; 
		} 
		element = newElement; 
	}
	
	// useful when adding a new element with the add
	// with two parameters....
	private void moveDataOnePositionTR(int low, int sup) { 
		// pre: 0 <= low <= sup < (element.length - 1)
		for (int pos = sup; pos >= low; pos--)
			element[pos+1] = element[pos]; 
	}

	// useful when removing an element from the list...
	private void moveDataOnePositionTL(int low, int sup) { 
		// pre: 0 < low <= sup <= (element.length - 1)
		for (int pos = low; pos <= sup; pos++)
			element[pos-1] = element[pos]; 
	}

}
