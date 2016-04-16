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
		if (element.equals(null)) {
			throw new RuntimeException("ERROR");
		}
		if (index > size || index < 0) {
			throw new RuntimeException("ERROR");
		}
		Node v = top;
		Node temp = new Node(element, null);
		if (index == 0) {		
	    	if (size == 0) {
	        top = temp;
	        size++;
	    	} else {
	    		for (int i = size - 1; i > 0; i--) {
	    		  	v = v.getNext();
	    	       	}
	    	        v.setNext(temp);
	    	        size++;
	    	}
		} else if (index == size) {
			temp.setNext(top);
			top = temp;
			size++;
		} else if (index > 0) {
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
			throw new RuntimeException("ERROR");
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
		if (isEmpty()) {
			Node temp;
			temp = top;
			top = new Node(element, temp);
			size++;
		} else {
		Node temp;
		temp = top;
		Node v = new Node(element, temp);
		top = v;
		size++;
		}
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
