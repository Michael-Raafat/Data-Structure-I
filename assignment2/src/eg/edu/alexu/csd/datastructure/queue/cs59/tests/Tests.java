package eg.edu.alexu.csd.datastructure.queue.cs59.tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.queue.cs59.ArrayBased;
import eg.edu.alexu.csd.datastructure.queue.cs59.LinkedListBased;

public class Tests {

	  private int n = 0;
	  IQueue be;
	@Before
	public final void begin() {
		be = new ArrayBased(n);//comment this 
		//when use linkedlist 
		//enter the n you 
		be = new LinkedListBased();
	}
	@Test
	public void testAllOperations() {
		be.enqueue(3);
		be.enqueue(5);
		be.enqueue(7);
		be.enqueue(3);
		be.enqueue(5);
		be.enqueue(7);
		be.dequeue();
		Assert.assertEquals(5,be.dequeue());
		Assert.assertEquals(4, be.size());
		Assert.assertEquals(false, be.isEmpty());
		Assert.assertEquals(7, be.dequeue());
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
