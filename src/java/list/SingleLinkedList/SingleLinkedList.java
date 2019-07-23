/*
 * Author: fasion
 * Created time: 2019-07-22 16:41:01
 * Last Modified by: fasion
 * Last Modified time: 2019-07-22 18:25:01
 */

import java.io.StringWriter;
import java.io.PrintWriter;

public class SingleLinkedList<AnyType> implements Iterable<AnyType> {

    public SingleLinkedList() {
        doClear();
    }

    private void doClear() {
        listSize = 0;
        listHead = new Node(null, null);
    }

    public void clear() {
        doClear();
    }

    public int size() {
        return listSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public AnyType get(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new IndexOutOfBoundsException();
        }

        return getNode(idx).data;
    }

    public AnyType set(int idx, AnyType newVal) {
        if (idx < 0 || idx >= size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<AnyType> node = getNode(idx);
        AnyType oldVal = node.data;
        node.data = newVal;
        return oldVal;
    }

    public void add(int idx, AnyType x) {
        if (idx < 0 || idx > size()) {
            throw new IndexOutOfBoundsException();
        }

        Node<AnyType> node = getNode(idx);
        addBefore(node, x);
    }

    public void add(AnyType x) {
        add(size(), x);
    }

    public void remove(Node<AnyType> node) {
        Node<AnyType> next = node.next;

        node.data = next.data;
        node.next = next.next;
    }

    public void remove(int idx) {
        if (idx < 0 || idx >= size()) {
            throw new IndexOutOfBoundsException();
        }

        remove(getNode(idx));
    }

    public java.util.Iterator<AnyType> iterator() {
        return new SingleLinkedListIterator();
    }

    public String toString() {
        java.io.StringWriter sw = new java.io.StringWriter();
        java.io.PrintWriter pw = new java.io.PrintWriter(sw);

        sw.write("[ ");

        java.util.Iterator it = iterator();
        while (it.hasNext()) {
            pw.format("%s ", it.next());
        }

        sw.write("]");

        return sw.toString();
    }

    private static class Node<AnyType> {
        public AnyType data;
        public Node<AnyType> next;

        public Node(AnyType d, Node<AnyType> n) {
            data = d;
            next = n;
        }

        public Node(Node<AnyType> n) {
            data = n.data;
            next = n.next;
        }
    }

    private int listSize;
    private Node<AnyType> listHead;

    private class SingleLinkedListIterator implements java.util.Iterator<AnyType> {
        private Node<AnyType> current = null;
        private Node<AnyType> next = listHead;
        private int idx = 0;

        public boolean hasNext() {
            return idx < size();
        }

        public AnyType next() {
            current = next;
            next = next.next;
            idx++;

            return current.data;
        }

        public void remove() {
            SingleLinkedList.this.remove(current);
        }
    }

    private void addBefore(Node<AnyType> node, AnyType x) {
        Node<AnyType> dup = new Node(node);
        node.data = x;
        node.next = dup;

        listSize++;
    }

    private Node<AnyType> getNode(int idx) {
        Node<AnyType> current = listHead;
        for (int i = 0; i < idx; i++) {
            current = current.next;
        }

        return current;
    }

    public static void main(String args[]) {
        SingleLinkedList<Integer> list = new SingleLinkedList();
        System.out.printf("After init: %s\n", list);
        System.out.println();

        list.add(1);
        list.add(2);
        list.add(4);
        System.out.printf("After add: %s\n", list);
        System.out.println();

        list.add(0, 0);
        System.out.printf("After add at the front: %s\n", list);
        System.out.println();

        list.add(3, -3);
        System.out.printf("After add in the middle: %s\n", list);
        System.out.println();

        System.out.printf("#3: %s\n", list.get(3));

        list.remove(3);
        System.out.printf("After remove: %s\n", list);
        System.out.println();

        list.clear();
        System.out.printf("After clear: %s\n", list);
        System.out.println();
    }
}
