package eg.edu.alexu.csd.datastructure.queue.cs59;

import eg.edu.alexu.csd.datastructure.queue.ILinkedBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;


public class LinkedListBased implements IQueue,ILinkedBased {
	/**
     * list size.
     */
	private int size = 0;
	/**
	 * list head.
	 */
	private Node head = new Node();
	/**
	 * list tail.
	 */
	private Node tail = new Node();
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		    Node temp;
			temp = tail;
			tail = new Node(item, null,temp);
			size++;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new RuntimeException("ERROR");
		}
		Object q = head.getElement();
		head = head.getNext();
		size--;
		return q;
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

}
