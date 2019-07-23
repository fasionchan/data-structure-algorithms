/*
 * Author: fasion
 * Created time: 2019-07-22 10:40:22
 * Last Modified by: fasion
 * Last Modified time: 2019-07-22 14:55:12
 */

public class ArrayOutOfCapacity extends RuntimeException {
	public ArrayOutOfCapacity() {
		super("Array out of capacity", null);
	}

	public ArrayOutOfCapacity(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
}
