/*
 * Author: fasion
 * Created time: 2019-07-29 17:21:16
 * Last Modified by: fasion
 * Last Modified time: 2019-07-30 10:00:44
 */

#include <stdio.h>
#include <stdlib.h>
#include "single-linked-list.h"

void init(ListPtr l) {
	l->head = l->tail = NULL;
}

ListPtr create() {
	ListPtr l = (ListPtr)malloc(sizeof(List));
	if (l != NULL) {
		init(l);
	}

	return l;
}

int isEmpty(ListPtr l) {
	return l->head == NULL;
}

NodePtr head(ListPtr l) {
	return l->head;
}

NodePtr tail(ListPtr l) {
	return l->tail;
}

Position find(ListPtr l, Element x) {
	Position p;
	for (p = l->head; p != NULL; p = p->next) {
		if (p->element == x) {
			return p;
		}
	}

	return NULL;
}

void delete(ListPtr l, Element x) {
	// find x and trace previous one at the same time
	Position prev, p;
	for (prev = NULL, p = l->head; p != NULL; prev = p, p = p->next) {
		if (p->element == x) {
			break;
		}
	}

	// find nothing
	if (p == NULL) {
		return;
	}

	// delete it
	if (p == l->head) {
		l->head = p->next;
	}
	if (p == l->tail) {
		l->tail = prev;
	}
	if (prev != NULL) {
		prev->next = p->next;
	}
	free(p);
}

int add(ListPtr l, Position p, Element x) {
	// allocate memory for element node
	Position node = malloc(sizeof(Node));
	if (node == NULL) {
		return -1;
	}

	// fill element value
	node->element = x;

	if (p == NULL) {
		// add to head
		node->next = l->head;
		l->head = node;
	} else {
		node->next = p->next;
		p->next = node;
	}

	if (l->tail == p) {
		l->tail = node;
	}

	return 0;
}

void traverse(ListPtr l, NodeHandler h) {
	Position p = l->head;
	while (p != NULL) {
		Position tmp = p;
		p = p->next;
		h(tmp);
	}
}

void printNode(NodePtr n) {
	printf("%d ", n->element);
}

void print(ListPtr l, char *hint) {
	printf("%s[ ", hint);
	traverse(l, printNode);
	printf("]\n");
}

void reverse(ListPtr l) {
	Position h1 = l->head;
	Position h2 = NULL;

	while (h1 != NULL) {
		Position n = h1;
		h1 = h1->next;

		n->next = h2;
		h2 = n;
	}

	l->tail = l->head;
	l->head = h2;
}

void clear(ListPtr l) {
	traverse(l, (NodeHandler)free);
	l->head = l->tail = NULL;
}

void destroy(ListPtr l) {
	clear(l);
	free(l);
}
