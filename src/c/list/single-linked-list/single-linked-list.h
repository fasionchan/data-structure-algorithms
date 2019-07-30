/*
 * Author: fasion
 * Created time: 2019-07-29 17:15:23
 * Last Modified by: fasion
 * Last Modified time: 2019-07-30 10:00:45
 */

typedef int Element;

typedef struct node Node;
typedef Node* NodePtr;

struct node {
	Element element;
	NodePtr next;
};

typedef struct {
	NodePtr head;
	NodePtr tail;
} List, *ListPtr;

typedef NodePtr Position;
typedef void (*NodeHandler)(NodePtr);

void init(ListPtr l);
ListPtr create();
int isEmpty(ListPtr l);
NodePtr head(ListPtr l);
NodePtr tail(ListPtr l);
Position find(ListPtr l, Element x);
void delete(ListPtr l, Element x);
int add(ListPtr l, Position p, Element x);
void traverse(ListPtr l, NodeHandler h);
void printNode(NodePtr n);
void print(ListPtr l, char *hint);
void reverse(ListPtr l);
void clear(ListPtr l);
void destroy(ListPtr l);
