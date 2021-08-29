public class LinkedListDeque<T> {
    private class DequeNode {
        T item;
        DequeNode prev;
        DequeNode next;

        DequeNode(T i, DequeNode p, DequeNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private DequeNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new DequeNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        DequeNode oldFirst = sentinel.next;
        DequeNode n = new DequeNode(item, sentinel, oldFirst);
        oldFirst.prev = n;
        sentinel.next = n;
        size++;
    }

    public void addLast(T item) {
        DequeNode oldLast = sentinel.prev;
        DequeNode n = new DequeNode(item, oldLast, sentinel);
        oldLast.next = n;
        sentinel.prev = n;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        DequeNode tmp = sentinel.next;
        for (; tmp != sentinel; tmp = tmp.next) {
            System.out.print(tmp.item.toString() + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;
        return item;
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        DequeNode tmp = sentinel.next;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.item;
    }

    public T getRecursive(int index) {
        if (isEmpty() || index == 0) {
            return sentinel.next.item;
        } else {
            sentinel = sentinel.next;
            T result = getRecursive(index - 1);
            sentinel = sentinel.prev;
            return result;
        }
    }
}
