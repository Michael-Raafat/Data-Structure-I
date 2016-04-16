package eg.edu.alexu.csd.datastructure.stack.cs59;

import eg.edu.alexu.csd.datastructure.stack.IStack;
/**
 *
 * @author Michael.
 *
 */
public class MyStack implements IStack {
    /**
     * list size.
     */
	private int size = 0;
	/**
	 * list top.
	 */
	private Node top = new Node();
	@Override
	public void add(final int index, final Object element) {
		// TODO Auto-generated method stub
		if (index > size || index < 0) {
			throw new RuntimeException("ERROR");
		}
		Node v = top;
		Node temp = new Node(element, null);
		if (index == size && size != 0) {
			temp.setNext(top);
			top = temp;
		} else if (size == 0 && index == size) {
			top.setElement(element);
		} else {
	        	for (int i = size - 1; i > index + 1; i--) {
		     	v = v.getNext();
	         	}
		        temp.setNext(v.getNext());
		        v.setNext(temp);
		        size++;
		}
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return null;
		}
		Object v = top.getElement();
		top = top.getNext();
		size--;
		return v;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new RuntimeException("ERROR");
		}
		return top;
	}

	@Override
	public void push(final Object element) {
		// TODO Auto-generated method stub
		Node v = new Node(element, top);
		top = v;
		size++;
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
