/*
 * Author: fasion
 * Created time: 2019-07-20 16:16:06
 * Last Modified by: fasion
 * Last Modified time: 2019-07-23 15:22:50
 */

public class ArrayList<AnyType> implements Iterable<AnyType> {

	public ArrayList() {
		listItems = (AnyType[]) new Object[DEFAULT_CAPACITY];
		listSize = 0;
	}

	public int size() {
		return listSize;
	}

	public int capacity() {
		return listItems.length;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == capacity();
	}

	public AnyType get(int idx) {
		// index out of bounds
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		return listItems[idx];
	}

	public AnyType set(int idx, AnyType newVal) {
		// index out of bounds
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		// store old value for returning
		AnyType oldVal = listItems[idx];
		listItems[idx] = newVal;

		return oldVal;
	}

	public void ensureCapacity(int newCapacity) {
		// current capacity is enough
		if (newCapacity <= capacity()) {
			return;
		}

		// record old items
		AnyType [] oldItems = listItems;

		// allocate memory with new capactity
		listItems = (AnyType []) new Object[newCapacity];

		// copy old items
		for (int i = 0; i < size(); i++) {
			listItems[i] = oldItems[i];
		}
	}

	public void add(int idx, AnyType x) {
		// there's no space left
		if (isFull()) {
			ensureCapacity(capacity() * 2);
		}

		// shift items behind backward
		for (int i = size() - 1; i >= idx; i--) {
			listItems[i+1] = listItems[i];
		}

		// store new item
		listItems[idx] = x;
		listSize++;
	}

	public void add(AnyType x) {
		add(size(), x);
	}

	public AnyType remove(int idx) {
		// index out of bounds
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		// store value for returning
		AnyType value = listItems[idx];

		// shift items behind forward
		for (int i = idx + 1; i < size(); i++) {
			listItems[i-1] = listItems[i];
		}

		listSize--;

		return value;
	}

	public void print(String hint) {
		System.out.printf("%s[ ", hint);

		for (int i = 0; i < listSize; i++) {
			System.out.printf("%s ", listItems[i]);
		}

		System.out.printf("]\n");
	}

	public java.util.Iterator<AnyType> iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements java.util.Iterator<AnyType> {
		// index for next item
		private int next = 0;

		public boolean hasNext() {
			// index in bounds
			return next < size();
		}

		public AnyType next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}

			return listItems[next++];
		}

		public void remove() {
			ArrayList.this.remove(--next);
		}
	}

	private static final int DEFAULT_CAPACITY = 10;

	private int listSize;
	private AnyType[] listItems;

	public static void main(String args[]) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.print("After init: ");
		System.out.println();

		list.add(1);
		list.add(2);
		list.add(3);

		list.print("After add 1, 2, 3: ");
		System.out.printf("#1 is: %d\n", list.get(1));
		System.out.println();

		list.add(0, -1);
		list.print("After insert -1: ");
		System.out.println();

		list.remove(1);
		list.print("After remove #1: ");
		System.out.println();

		list.add(4);
		list.print("After append 4: ");
		System.out.println();

		for (int i = 5; i < 20; i++) {
			list.add(i);
		}

		list.print("Finally: ");
		System.out.println();

		System.out.println("iterate over list");
		java.util.Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
