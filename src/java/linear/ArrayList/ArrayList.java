/*
 * Author: fasion
 * Created time: 2019-07-20 16:16:06
 * Last Modified by: fasion
 * Last Modified time: 2019-07-22 13:59:07
 */

public class ArrayList<AnyType> implements Iterable<AnyType> {
	private static final int DEFAULT_CAPACITY = 10;

	private int listSize;
	private AnyType[] listItems;

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
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return listItems[idx];
	}

	public AnyType set(int idx, AnyType newVal) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		AnyType old = listItems[idx];
		listItems[idx] = newVal;

		return old;
	}

	public void ensureCapacity(int newCapacity) {
		if (newCapacity <= capacity()) {
			return;
		}

		AnyType [] oldItems = listItems;

		listItems = (AnyType []) new Object[newCapacity];
		for (int i = 0; i < size(); i++) {
			listItems[i] = oldItems[i];
		}
	}

	public void add(int idx, AnyType x) {
		if (size() == capacity()) {
			ensureCapacity(capacity() * 2);
		}

		for (int i = size(); i > idx; i--) {
			listItems[i] = listItems[i-1];
		}

		listItems[idx] = x;
		listSize++;
	}

	public void add(AnyType x) {
		add(size(), x);
	}

	public AnyType remove(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		AnyType value = listItems[idx];

		for (int i = idx; i < size() - 1; i++) {
			listItems[i] = listItems[i+1];
		}

		listSize--;

		return value;
	}

	public void print(String hint) {
		System.out.printf("%s[", hint);

		for (int i = 0; i < listSize; i++) {
			System.out.printf("%s ", listItems[i]);
		}

		System.out.printf("]\n");
	}

	private class ArrayListIterator implements java.util.Iterator<AnyType> {
		private int current = 0;

		public boolean hasNext() {
			return current < size();
		}

		public AnyType next() {
			if (!hasNext()) {
				throw new java.util.NoSuchElementException();
			}
			return listItems[current++];
		}

		public void remove() {
			ArrayList.this.remove(--current);
		}
	}

	public java.util.Iterator<AnyType> iterator() {
		return new ArrayListIterator();
	}

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
