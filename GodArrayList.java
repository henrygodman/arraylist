package com.salesforce.arraylist;


public class GodArrayList<E> {

	private E[] mArray;
	private int count = 0;
	
	/**
	 * constructor initializes object array to given size.
	 * @param i
	 */
	public GodArrayList(int i) {
		mArray = (E[]) new Object[i];
	}

	/**
	 * appends data to the end of the array
	 * @param elem
	 * @return
	 */
	public boolean add(E elem) {
		E[] temp = (E[]) new Object[size()+1];
		for(int i = 0; i < size(); i++) {
			temp[i] = mArray[i];
		}
		temp[size()] = elem;
		mArray = temp;
		count++;
		return true;
	}

	/**
	 * add element at given index
	 * @param i
	 * @param elem
	 * @return
	 */
	public boolean add(int i, E elem) {
		E[] temp = (E[]) new Object[size()+1];
		for( int j = 0; j < size()+1; j++) {
			if(j == i)
				temp[j] = elem;
			else if(j < i )
				temp[j] = mArray[j];
			else 
				temp[j] = mArray[j-1];
		}
		mArray = temp;
		count++;
		return true;
	}

	/**
	 * returns the element at the specified index
	 * @param i
	 * @return
	 */
	public E get(int i) {
		if(isEmpty() || i >= size())
			return null;
		else
			return (E) mArray[i];
	}

	/**
	 * removes the element at the indicated index
	 * @param i
	 * @return
	 */
	public boolean remove(int i) {
		if(isEmpty() || i >= size()) {
			return false;
		} else {
			E[] temp = (E[]) new Object[size()-1];
			for(int j = 0; j < size()-1; j++) {
				if(j < i)
					temp[j] = mArray[j];
				else
					temp[j] = mArray[j+1];
			}
			mArray = temp;
			return true;
		}
	}
	
	/**
	 * remove first occurence of object from the array
	 * @param elem
	 * @return
	 */
	public boolean remove(E elem) {
		int i = indexOf(elem);
		if(isEmpty() || i < 0) {
			return false;
		} else {
			return remove(i);
		}
	}

	/**
	 * removes a range of elements from the array and throws an exception if out of bounds
	 * @param start
	 * @param end
	 */
	public void removeRange(int start, int end) {
		if( start < 0 || start >= size() || end > size() || end < start ) {
			throw new IndexOutOfBoundsException();
		} else {
			E[] temp = (E[]) new Object[size()-(end-start)];
			for(int i = 0; i < start; i++) {
				temp[i]	 = mArray[i];
			}
			for(int i = end; i < size(); i++) {
				temp[i-(end-start)] = mArray[i];
			}
			mArray = temp;
		}
	}

	/**
	 * replaces element at specified index with given element
	 * @param i
	 * @param elem
	 * @return
	 */
	public E set(int i, E elem) {
		if(isEmpty() || i >= size()) {
			return null;
		} else {
			E temp = mArray[i];
			mArray[i] = elem;
			return temp;
		}
	}

	/**
	 * determines if array contains specified object
	 * @param elem
	 * @return
	 */
	public boolean contains(E elem) {
		if(indexOf(elem) < 0)
			return false;
		else 
			return true;
	}

	/**
	 * returns an array containing all the elements in order
	 * @return
	 */
	public E[] toArray() {
		return mArray;
	}

	/**
	 * increase array size to ensure the array can hold a specified minimum element range
	 * @param i
	 */
	public void ensureCapacity(int i) {
		if(i >= size()) {
			E[] temp = (E[]) new Object[i];
			for(int j = 0; j < size(); j++) {
				temp[j] = mArray[j];
			}
			mArray = temp;
		}
	}
	
	/**
	 * determines if and where element is in the array
	 * @param elem
	 * @return
	 */
	public int indexOf(E elem) {
		if(isEmpty()) {
			return -1;
		} else {
			for(int i = 0; i < size(); i++) {
				if(elem.equals(mArray[i]))
					return i;
			}
			return -1;
		}
	}
	
	/**
	 * returns if the array is empty.
	 * @return
	 */
	public boolean isEmpty() {
		if(size() == 0)
			return true;
		else 
			return false;
	}
	
	public boolean isOutOfBounds(int i) {
		if( i < 0 || i >= size()) 
			return true;
		else 
			return false;
	}
	
	/**
	 * returns the dimension of the array.
	 * @return
	 */
	public int size() {
		return mArray.length;
	}
	
	/**
	 * clears the array so that it has empty elements.
	 */
	public void clear() {
		mArray = (E[]) new Object[size()];
	}
}
