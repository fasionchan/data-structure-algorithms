/*
 * Author: fasion
 * Created time: 2019-07-20 16:16:06
 * Last Modified by: fasion
 * Last Modified time: 2019-07-23 15:21:41
 */

public class NaiveArrayList {

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
		// index out of bounds
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		return listItems[idx];
	}

	public int set(int idx, int newVal) {
		// index out of bounds
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		// store old value for returning
		int oldVal = listItems[idx];
		listItems[idx] = newVal;

		return oldVal;
	}

	public void add(int idx, int x) {
		// there's no space left
		if (isFull()) {
			throw new ArrayOutOfCapacity();
		}

		// shift items behind backward
		for (int i = size() - 1; i >= idx; i--) {
			listItems[i+1] = listItems[i];
		}

		// store new item
		listItems[idx] = x;
		listSize++;
	}

	public void add(int x) {
		add(size(), x);
	}

	public int remove(int idx) {
		// index out of bounds
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		// store value for returning
		int value = listItems[idx];

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

	private int listSize;
	private int[] listItems;

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
