/*
 * Author: fasion
 * Created time: 2019-07-30 09:31:01
 * Last Modified by: fasion
 * Last Modified time: 2019-07-30 10:00:40
 */

#include <stdio.h>
#include "single-linked-list.h"

int main(int argc, char *argv[]) {
	ListPtr l = create();
	if (l == NULL) {
		return -1;
	}

	print(l, "after init: ");

	add(l, NULL, 1);
	add(l, NULL, 2);
	add(l, NULL, 3);
	print(l, "after add 1, 2, 3 to head: ");

	add(l, tail(l), 4);
	add(l, tail(l), 5);
	add(l, tail(l), 6);
	print(l, "after add 4, 5, 6 to tail: ");

	Position p = find(l, 1);
	add(l, p, 0);
	print(l, "after add 0 after 1: ");

	reverse(l);
	print(l, "after reverse: ");

	delete(l, 0);
	print(l, "after delete 0: ");

	clear(l);
	print(l, "after clear: ");

	destroy(l);

	return 0;
}
