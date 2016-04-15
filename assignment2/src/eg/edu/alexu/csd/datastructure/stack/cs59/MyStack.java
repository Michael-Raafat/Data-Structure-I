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
	public void add(int index, Object element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object pop() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new RuntimeException ("ERROR");
		}
		Object v = top.getElement();
		top = top.getNext();
		size--;
		return v;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		if(isEmpty()) {
			throw new RuntimeException("ERROR");
		}
		return top;
	}

	@Override
	public void push(Object element) {
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
