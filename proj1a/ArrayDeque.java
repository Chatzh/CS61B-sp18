public class ArrayDeque<T> {
    private class DequeNode {
        T[] array;

        DequeNode() {
            array = (T[]) new Object[8];
        }
    }

    private DequeNode sentinel;
    private int size,
                capacity,
                nextFirst,
                nextLast;

    public ArrayDeque() {
        sentinel = new DequeNode();
        capacity = 8;
        nextFirst = capacity - 1;
        nextLast = 0;
        size = 0;
    }

    /** Check this.Arraydeque needs to resize or not.
     *  If it needs to resize, then resize it, otherwise do nothing.
     * @param i stands for the calling method is increasing the size of
     *          this.Arraydeque or decreasing.
     *          Positive means increasing, negative means decreasing.
     */
    private void resize(int i) {
        int newCapacity;
        if (size + i > capacity) {
            newCapacity = capacity * 2;
        } else if (capacity > 8 && size + i < capacity / 4) {
            newCapacity = capacity / 2;
        } else {
            return;
        }

        /* Copy all items form this.ArrayDeque to new ArrayDeque.
           srcPos: index of first item, destPos: 0, length: size.
         */
        int index = increment(nextFirst);
        T[] n = (T[]) new Object[newCapacity];
        for (int j = 0; j < size; j++) {
            n[j] = sentinel.array[index];
            index = increment(index);
        }

        sentinel.array = n;
        capacity = newCapacity;
        nextFirst = capacity - 1;
        nextLast = size;
    }

    public void addFirst(T item) {
        resize(1);
        sentinel.array[nextFirst] = item;
        nextFirst = decrement(nextFirst);
        size++;
    }

    public void addLast(T item) {
        resize(1);
        sentinel.array[nextLast] = item;
        nextLast = increment(nextLast);
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
        if (isEmpty()) {
            return null;
        }
        resize(-1);

        nextFirst = increment(nextFirst);
        T item = sentinel.array[nextFirst];
        sentinel.array[nextFirst] = null;
        size--;
        return item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        resize(-1);

        nextLast = decrement(nextLast);
        T item = sentinel.array[nextLast];
        sentinel.array[nextLast] = null;
        size--;
        return item;
    }

    public T get(int index) {
        if (isEmpty()) {
            return null;
        }

        index += nextFirst + 1;
        if (index >= capacity) {
            index -= capacity;
        }
        return sentinel.array[index];
    }

    /** Return the correct index regardless the bound. */
    private int increment(int i) {
        if (i == capacity - 1) {
            return 0;
        }
        return ++i;
    }

    /** Return the correct index regardless the bound. */
    private int decrement(int i) {
        if (i == 0) {
            return capacity - 1;
        }
        return --i;
    }
}
