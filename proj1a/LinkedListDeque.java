public class LinkedListDeque<T> {
    private class DequeNode{
        public T item;
        public DequeNode prev;
        public DequeNode next;

        public DequeNode(T i, DequeNode p, DequeNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }

    private DequeNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new DequeNode((T) "null", null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public LinkedListDeque(T item) {
        sentinel = new DequeNode((T) "null", null, null);
        DequeNode n = new DequeNode(item, sentinel, sentinel);
        sentinel.prev = n;
        sentinel.next = n;
        size = 1;
    }

    public void addFirst(T item) {
        DequeNode oldFirst = sentinel.next;
        DequeNode n = new DequeNode(item, sentinel, oldFirst);
        oldFirst.prev = n;
        sentinel.next = n;
        size ++;
    }

    public void addLast(T item) {
        DequeNode oldLast = sentinel.prev;
        DequeNode n = new DequeNode(item, oldLast, sentinel);
        oldLast.next = n;
        sentinel.prev = n;

        size ++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        DequeNode tmp = sentinel.next;
        while (tmp != sentinel) {
            System.out.print(tmp.item + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T item = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.next.prev = sentinel;
        size--;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T item = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.prev.next = sentinel;
        size--;
        return item;
    }

    public T get(int index) {
        if (size == 0) {
            return null;
        }
        DequeNode tmp = sentinel.next;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.item;
    }

    public T getRecursive(int index) {
        if (size == 0) {
            return null;
        } else if (index == 0) {
            return sentinel.next.item;
        } else {
            LinkedListDeque<T> tmp = this;
            tmp.sentinel = tmp.sentinel.next;
            tmp.size--;
            return tmp.getRecursive(index - 1);
        }
    }
}
