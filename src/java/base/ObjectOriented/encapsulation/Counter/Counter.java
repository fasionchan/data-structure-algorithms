/*
 * Author: fasion
 * Created time: 2019-07-20 15:38:55
 * Last Modified by: fasion
 * Last Modified time: 2019-07-22 16:03:33
 */

public class Counter {
	int count;

	public Counter() {
		count = 0;
	}

	public void add() {
		count += 1;
	}

	public void reset() {
		count = 0;
	}

	public int get() {
		return count;
	}

	public static void main(String args[]) {
		Counter counter = new Counter();
		System.out.printf("Initial: %d\n", counter.get());

		counter.add();
		System.out.printf("After first add: %d\n", counter.get());

		counter.add();
		System.out.printf("After second add: %d\n", counter.get());

		counter.reset();
		System.out.printf("After reset: %d\n", counter.get());

		counter.add();
		System.out.printf("After another add: %d\n", counter.get());
	}
}
