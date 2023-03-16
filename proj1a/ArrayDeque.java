public class ArrayDeque<T> {
	private T[] items;
	private int head;
	private int tail;
	private int size;

	public ArrayDeque() {
		items = (T[]) new Object[100];
		head = 0;
		tail = 0;
		size = 0;
	}

	/** Adds the item to the front of the list. */
	public void addFirst(T item) {
		items[head] = item;
		size = size + 1;
		head = head == 0 ? items.length - 1 : head - 1;
	}

	/** Adds the item to the end of the list. */
	public void addLast(T item) {
		items[tail] = item;
		size = size + 1;
		tail = tail == items.length - 1 ? 0 : tail + 1;
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
		if (size == 0) {
			return null;
		}
		size = size - 1;
		head = head == items.length - 1 ? 0 : head + 1;
		T item = items[head];
		return item;
	}

	/** Remove the last item of the list and returns. */
	public T removeLast() {
		if (size == 0) {
			return null;
		}
		size = size - 1;
		tail = tail == 0 ? items.length - 1 : tail - 1;
		T item = items[tail];
		return item;
	}

	/** Returns the item of the ith of the list. */
	public T get(int index) {
		if (head + index + 1 > items.length - 1) {
			return items[head + index - items.length + 1];
		}
		return items[head + index + 1];
	}

	/** Prints the items in the deque from first to last, separated by a space. */
	public void printDeque() {

	}

}