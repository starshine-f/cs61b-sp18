public class LinkedListDeque<T> {
	/** This internal class will not be used by user. */
	private class Node {
		private T item;
		private Node pre;
		private Node next;

		public Node(T i, Node p, Node n) {
			item = i;
			pre = p;
			next = n;
		}
	}

	/* Make two sentinel Node */
	private Node frontSentinel;
	private Node endSentinel;
	private int size;

	public LinkedListDeque() {
		frontSentinel = new Node(null, null, null);
		endSentinel = new Node(null, null, null);

		frontSentinel.next = endSentinel;
		endSentinel.pre = frontSentinel;

		/* Make circular sentinel */
		frontSentinel.pre = endSentinel;
		endSentinel.next = frontSentinel;

		size = 0;
	}

	/** Adds the item to the front of the list. */
	public void addFirst(T item) {
		Node node = new Node(item, null, null);
		node.next = frontSentinel.next;
		frontSentinel.next.pre = node;
		node.pre = frontSentinel;
		frontSentinel.next = node;
		size = size + 1;
	}

	/** Adds the item to the end of the list. */
	public void addLast(T item) {
		Node node = new Node(item, null, null);
		node.pre = endSentinel.pre;
		endSentinel.pre.next = node;
		node.next = endSentinel;
		endSentinel.pre = node;
		size = size + 1;
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
		Node node = frontSentinel.next;
		frontSentinel.next = node.next;
		node.next.pre = frontSentinel;
		size = size - 1;
		return node.item;
	}

	/** Remove the last item of the list and returns. */
	public T removeLast() {
		if (size == 0) {
			return null;
		}
		Node node = endSentinel.pre;
		endSentinel.pre = node.pre;
		node.pre.next = endSentinel;
		size = size - 1;
		return node.item;
	}

	/** Returns the item of the ith of the list. */
	public T get(int index) {
		Node p = frontSentinel.next;
		int i = 0;

		while (i != index) {
			p = p.next;
			i = i + 1;
		}

		return p.item;
	}

	public T getRecursive(int index) {
		if (index > size - 1) {
			return null;
		}
		return getRecursiveHelp(frontSentinel.next, index);
	}

	/** A method help complete getRecursive(int index). */
	private T getRecursiveHelp(Node node, int index) {
		if (index == 0) {
			return node.item;
		}
		return getRecursiveHelp(node.next, index - 1);
	}

	/** Prints the items in the deque from first to last, separated by a space. */
	public void printDeque() {

	}
}