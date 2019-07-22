/*
 * Author: fasion
 * Created time: 2019-07-20 16:16:06
 * Last Modified by: fasion
 * Last Modified time: 2019-07-22 14:57:07
 */

public class GenericArrayList<AnyType> {
	private int listSize;
	private AnyType[] listItems;

	public GenericArrayList(int capacity) {
		listItems = (AnyType[]) new Object[capacity];
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

	public void add(AnyType x) {
		add(size(), x);
	}

	public void add(int idx, AnyType x) {
		if (size() == capacity()) {
			throw new ArrayOutOfCapacity();
		}

		for (int i = size(); i > idx; i--) {
			listItems[i] = listItems[i-1];
		}

		listItems[idx] = x;
		listSize++;
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

	public static void main(String args[]) {
		GenericArrayList<String> strlist = new GenericArrayList<String>(10);
		strlist.print("After init: ");
		System.out.println();

		strlist.add("apple");
		strlist.add("boy");
		strlist.add("cat");

		strlist.print("After add apple boy cat: ");
		System.out.printf("#1 is: %s\n", strlist.get(1));
		System.out.println();

		strlist.add(0, "Ant");
		strlist.print("After insert Ant: ");
		System.out.println();

		strlist.remove(1);
		strlist.print("After remove #1: ");
		System.out.println();

		strlist.add("dog");
		strlist.print("After append four: ");
		System.out.println();

		GenericArrayList<Integer> list = new GenericArrayList<Integer>(10);
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
	}
}
