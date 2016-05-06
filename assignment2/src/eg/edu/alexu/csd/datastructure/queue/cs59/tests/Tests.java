package eg.edu.alexu.csd.datastructure.queue.cs59.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.queue.cs59.ArrayBased;
import eg.edu.alexu.csd.datastructure.queue.cs59.LinkedListBased;
/**
 *
 * @author Michael
 *
 */
public class Tests {
      /**
       * variables.
       */
	  private final int n = 0, three = 3,
			  five = 5, seven = 7, four = 4;
	  /**
	   * interface.
	   */
	  IQueue be;
	  /**
	   * initialization.
	   */
	@Before
	public final void begin() {
		be = new ArrayBased(n); //comment this
		//when use linkedlist
		//enter the n you
		// want but
		be = new LinkedListBased();
	}
	/**
	 * test 1.
	 */
	@Test
	public void testAllOperations() {
		be.enqueue(three);
		be.enqueue(five);
		be.enqueue(seven);
		be.enqueue(three);
		be.enqueue(five);
		be.enqueue(seven);
		be.dequeue();
		Assert.assertEquals(five, be.dequeue());
		Assert.assertEquals(four, be.size());
		Assert.assertEquals(false, be.isEmpty());
		Assert.assertEquals(seven, be.dequeue());
		be.dequeue();
		be.dequeue();
		be.dequeue();
		try {
			be.dequeue();
			Assert.assertTrue("You didn't throw exception"
					+ "queue is empty",
					false);
		} catch (RuntimeException e) {
			return;
		}
	}

}
