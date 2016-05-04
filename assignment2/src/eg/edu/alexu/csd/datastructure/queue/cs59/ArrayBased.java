package eg.edu.alexu.csd.datastructure.queue.cs59;
import java.util.Arrays;
import eg.edu.alexu.csd.datastructure.queue.IArrayBased;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
/**
 *
 * @author Michael
 *
 */
public class ArrayBased implements IQueue, IArrayBased  {
    /**
     * index variables and counter.
     */
	private int r = 0, f = 0, c = 0;
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
	public void enqueue(Object item) {
		// TODO Auto-generated method stub
		if (c == a.length) {
			throw new RuntimeException();
		}
		a[r] = item;
		r++;
		if (r == a.length) {
			r = 0;
		}
		c++;
	}
	@Override
	public Object dequeue() {
		// TODO Auto-generated method stub
		if (c == 0) {
			throw new RuntimeException();
		}
		Object v = a[f];
		f++;
		if (f == a.length) {
			f = 0;
		}
		c--;
		return v;
	}
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (c == 0);
	}
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return c;
	}
}
