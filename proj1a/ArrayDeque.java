public class ArrayDeque<T> {
	private T[] items;
	private int head;
	private int tail;
	private int size;

	public ArrayDeque() {
		items = (T[]) new Object[8];
		head = items.length - 1;
		tail = 0;
		size = 0;
	}

	/** Resize the ArrayDeque */
	private void resize(int capacity) {
		T[] target = (T[]) new Object[capacity];
		System.arraycopy(items, 0, target, 0, tail);
		int length = items.length - 1 - head;
		System.arraycopy(items, head + 1, target, capacity - length, length);
		head = capacity - length - 1;
		items = target;
	}

	/** Adds the item to the front of the list. */
	public void addFirst(T item) {
		if (head - 1 == tail) {
			resize(items.length * 2);
		}
		items[head] = item;
		size = size + 1;
		head = head - 1;
	}

	/** Adds the item to the end of the list. */
	public void addLast(T item) {
		if (head - 1 == tail) {
			resize(items.length * 2);
		}
		items[tail] = item;
		size = size + 1;
		tail = tail + 1;
	}

	/** Returns the boolean value whether the list is empty. */
	public boolean isEmpty() {
		return size == 0;
	}

	/** Returns the size of the list. */ 
	public int size() {
		return size;
	}

	/** Remove the first item of the list and returns. */
	public T removeFirst() {
		if (head == items.length - 1) {
			return null;
		}
		size = size - 1;
		head = head + 1;
		T item = items[head];
		if (items.length >= 16 && size < items.length/4) {
			resize(items.length/2);
		}
		return item;
	}

	/** Remove the last item of the list and returns. */
	public T removeLast() {
		if (tail == 0) {
			return null;
		}
		tail = tail - 1;
		T item = items[tail];
		items[tail] = null;
		size = size - 1;
		if (items.length >= 16 && size < items.length/4) {
			resize(items.length/2);
		}
		return item;
	}

	/** Returns the item of the ith of the list. */
	public T get(int index) {
		if (index >= size) {
			return null;
		}
		return items[(head + 1 + index) % items.length];
	}

	/** Prints the items in the deque from first to last, separated by a space. */
	public void printDeque() {

	}

}