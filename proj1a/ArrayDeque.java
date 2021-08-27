public class ArrayDeque<T> {
    private class DequeNode {
        T[] array;

        DequeNode() {
            array = (T[]) new Object[8];
        }
    }

    private DequeNode sentinel;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        sentinel = new DequeNode();
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    private void resize(int i) {
        int length = sentinel.array.length;
        if (size + i > length) {
            T[] n = (T[]) new Object[size * 2];
            System.arraycopy(sentinel.array, 0, n, 0, nextLast);
            System.arraycopy(sentinel.array, nextLast, n, size + nextLast, size - nextLast);
            sentinel.array = n;
            nextFirst = size + nextLast - 1;
        } else if (size + i < length / 4 - 2) {
            T[] n = (T[]) new Object[length / 2];
            System.arraycopy(sentinel.array, nextFirst + 1, n, 1, size - nextLast);
            System.arraycopy(sentinel.array, 0, n, 2, nextLast);
            sentinel.array = n;
            nextFirst = 0;
            nextLast = size + 1;
        }
    }

    public void addFirst(T item) {
        this.resize(1);
        sentinel.array[nextFirst] = item;

        /* Check if the pointer touch the border. */
        if (nextFirst == 0) {
            nextFirst = sentinel.array.length - 1;
        } else {
            nextFirst--;
        }

        size++;
    }

    public void addLast(T item) {
        this.resize(1);
        sentinel.array[nextLast] = item;

        /* Check if the pointer touch the border. */
        if (nextLast == sentinel.array.length - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }

        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (T item : this.sentinel.array) {
            System.out.print(item.toString() + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        this.resize(-1);
        if (size == 0) {
            return null;
        }

        /* Check if the pointer touch the border. */
        if (nextFirst == sentinel.array.length - 1) {
            nextFirst = 0;
        } else {
            nextFirst++;
        }

        T item = sentinel.array[nextFirst];
        sentinel.array[nextFirst] = null;
        size--;
        return item;
    }

    public T removeLast() {
        this.resize(-1);
        if (size == 0) {
            return null;
        }

        /* Check if the pointer touch the border. */
        if (nextLast == 0) {
            nextLast = sentinel.array.length - 1;
        } else {
            nextLast--;
        }

        T item = sentinel.array[nextLast];
        sentinel.array[nextLast] = null;
        size--;
        return item;
    }

    public T get(int index) {
        if (size == 0) {
            return null;
        }

        /* Check if the index touch the border. */
        if (nextFirst + index + 1 > sentinel.array.length) {
            return sentinel.array[nextLast - 1];
        } else {
            return sentinel.array[nextFirst + index + 1];
        }
    }
}
