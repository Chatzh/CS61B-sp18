public class ArrayDeque<T> {
    private class DequeNode {
        T[] array;

        DequeNode() {
            array = (T[]) new Object[8];
        }
    }

    private DequeNode sentinel;
    private int size,
                nextFirst,
                nextLast;

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
        } else if (length > 8 && size + i < length / 4) {
            T[] n = (T[]) new Object[length / 2];

            if (nextFirst + size + 1 < length) {
                System.arraycopy(sentinel.array, nextFirst + 1, n, 1, size);
            } else {
                int firstPartLength = length - nextFirst - 1;
                System.arraycopy(sentinel.array, nextFirst + 1, n, 1, firstPartLength);
                System.arraycopy(sentinel.array, 0, n, firstPartLength + 1, size - firstPartLength);
            }
            sentinel.array = n;
            nextFirst = 0;
            nextLast = size + 1;
        }
    }

    public void addFirst(T item) {
        this.resize(1);
        sentinel.array[nextFirst] = item;

        /* Check if the pointer touch the bound. */
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

        /* Check if the pointer touch the bound. */
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
        if (size == 0) {
            return null;
        }
        this.resize(-1);

        /* Check if the pointer touch the bound. */
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
        if (size == 0) {
            return null;
        }
        this.resize(-1);

        /* Check if the pointer touch the bound. */
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

        index += nextFirst + 1;
        if (index >= sentinel.array.length) {
            index -= sentinel.array.length;
        }
        return sentinel.array[index];
    }
}
