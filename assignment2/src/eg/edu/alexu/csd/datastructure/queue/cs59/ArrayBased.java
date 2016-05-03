package eg.edu.alexu.csd.datastructure.queue.cs59;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
/**
 *
 * @author Michael
 *
 */
public class ArrayBased implements IQueue,IArrayBased  {
    /**
     * index variables.
     */
	private int r = 0;
	private Object []a ;
	/**
	 * constructor.
	 * @param n
	 * length of the array
	 */
	public ArrayBased (int n) {
		a = new Object[n];
	}
	@Override
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if (r == a.length) {
			throw new RuntimeException();
		}
		a[r] = item;
		r++;
	}

	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (r == 0) {
			throw new RuntimeException();
		}
		Object v = a[0];
		for (int i = 0; i < r-1; i++) {
			a[i] = a[i+1];
		}
		return v;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (r == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return r;
	}

}
