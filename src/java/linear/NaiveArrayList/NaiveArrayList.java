/*
 * Author: fasion
 * Created time: 2019-07-20 16:16:06
 * Last Modified by: fasion
 * Last Modified time: 2019-07-22 14:55:42
 */

public class NaiveArrayList {
	private int listSize;
	private int[] listItems;

	public NaiveArrayList(int capacity) {
		listItems = new int[capacity];
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

	public int get(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return listItems[idx];
	}

	public int set(int idx, int newVal) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		int old = listItems[idx];
		listItems[idx] = newVal;

		return old;
	}

	public void add(int x) {
		add(size(), x);
	}

	public void add(int idx, int x) {
		if (size() == capacity()) {
			throw new ArrayOutOfCapacity();
		}

		for (int i = size(); i > idx; i--) {
			listItems[i] = listItems[i-1];
		}

		listItems[idx] = x;
		listSize++;
	}

	public int remove(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		int value = listItems[idx];

		for (int i = idx; i < size() - 1; i++) {
			listItems[i] = listItems[i+1];
		}

		listSize--;

		return value;
	}

	public void print(String hint) {
		System.out.printf("%s[", hint);

		for (int i = 0; i < listSize; i++) {
			System.out.printf("%d ", listItems[i]);
		}

		System.out.printf("]\n");
	}

	public static void main(String args[]) {
		NaiveArrayList list = new NaiveArrayList(10);
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
			list.print("After append i: ");
			System.out.println();
		}
	}
}
