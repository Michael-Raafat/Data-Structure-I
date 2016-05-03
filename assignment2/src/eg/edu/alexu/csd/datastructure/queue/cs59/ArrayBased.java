package eg.edu.alexu.csd.datastructure.queue.cs59;

import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
/**
 *
 * @author Michael
 *
 */
public class ArrayBased implements IQueue, IArrayBased  {
    /**
     * index variables.
     */
	private int r = 0;
	/**
	 * array.
	 */
	private Object[]a;
	/**
	 * constructor.
	 * @param n
	 * length of the array
	 */
	public ArrayBased(final int n) {
		a = new Object[n];
	}
	@Override
	public void enqueue(final Object item) {
		// TODO Auto-generated method stub
		if (r == a.length || item.equals(null)) {
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
		for (int i = 0; i < r - 1; i++) {
			a[i] = a[i + 1];
		}
		r--;
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
