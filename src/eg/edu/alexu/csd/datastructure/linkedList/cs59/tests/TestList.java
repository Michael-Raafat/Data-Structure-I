package eg.edu.alexu.csd.datastructure.linkedList.cs59.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.ILinkedList;
import eg.edu.alexu.csd.datastructure.linkedList.cs59.DoubleList;
import eg.edu.alexu.csd.datastructure.linkedList.cs59.SingleList;

/**
 *
 * @author Amr
 *
 */
public class TestList {
	/**
	 * constant numbers.
	 */
	private final int magic3 = 3, magic4 = 4, magic5 = 5,
			magic7 = 7;
	/**
	 * List to test.
	 */
	private ILinkedList list;
	/**
	 * function called before each test.
	 */
	@Before
	public final void init() {
		list = new SingleList();
		list = new DoubleList(); // You should comment
		//this if you want to test single List , 'CheckStyle'
	}
	/**
	 * test about adding in nodes.
	 */
	@Test
	public final void testadd() {
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		Assert.assertEquals('a', list.get(0));
		Assert.assertEquals('b', list.get(1));
		Assert.assertEquals('c', list.get(2));
		Assert.assertEquals('d', list.get(magic3));
		try {
			list.get(magic4);
			Assert.assertTrue("You didn't throw error "
					+ "when an invalid Index is called !",
					false);
		} catch (RuntimeException e) {
			return;
		}
		try {
			list.get(-1);
			Assert.assertTrue("You didn't throw error "
					+ "when an invalid Index is called !",
					false);
		} catch (RuntimeException e) {
			return;
		}
	}
	/**
	 * test adding to a determined index.
	 */
	@Test
	public final void testaddInMiddle() {
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		Assert.assertEquals('a', list.get(0));
		Assert.assertEquals('b', list.get(1));
		Assert.assertEquals('c', list.get(2));
		Assert.assertEquals('d', list.get(magic3));
		list.add(2, 'f');
		Assert.assertEquals('f', list.get(2));
		Assert.assertEquals('c', list.get(magic3));
		Assert.assertEquals('d', list.get(magic4));
		try {
			list.add(-1, 'F');
			Assert.assertTrue("You didn't throw error when "
					+ "an invalid Index is entered !",
					false);
		} catch (RuntimeException e) {
			return;
		}
		try {
			list.add(magic7, 'F');
			Assert.assertTrue("You didn't throw error "
					+ "when an invalid Index is entered !",
					false);
		} catch (RuntimeException e) {
			return;
		}
		try {
		list.add(magic5, 'm');
		Assert.assertEquals('m', list.get(magic5));
		} catch (Exception e) {
			Assert.assertTrue("You throwed error when we tried "
					+ "to add an object in an index "
					+ "that equals the size !",
					false);
		}
	}
	/**
	 * test replacing to a determined index.
	 */
	@Test
	public final void testreplace() {
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		list.set(1, 'f');
		Assert.assertEquals('f', list.get(1));
		try {
			list.set(magic7, 'm');
			Assert.assertTrue("You didn't throw error "
					+ "when an invalid Index is called !",
					false);
		} catch (RuntimeException e) {
			return;
		}
	}
	/**
	 * test sublist to a determined list.
	 */
	@Test
	public final void testSubList() {
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		Assert.assertEquals(2, list.sublist(1, 2).size());
		Assert.assertEquals('b', list.sublist(1, 2).get(0));
		Assert.assertEquals('c', list.sublist(1, 2).get(1));
	}
	/**
	 * test delete to a determined list.
	 */
	@Test
	public final void testDelete() {
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		list.remove(1);
		Assert.assertEquals('a', list.get(0));
		Assert.assertEquals('c', list.get(1));
		Assert.assertEquals('d', list.get(2));
		list.remove(0);
		list.remove(0);
		list.remove(0);
		Assert.assertTrue(list.isEmpty());
	}
	/**
	 * test contains to a determined list.
	 */
	@Test
	public final void testContains() {
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		Assert.assertTrue(list.contains('c'));
		Assert.assertTrue(!list.contains('F'));
	}
	/**
	 * test clear.
	 */
	@Test
	public final void testClear() {
		list.add('a');
		list.add('b');
		list.add('c');
		list.add('d');
		Assert.assertTrue(!list.isEmpty());
		list.clear();
		Assert.assertTrue(list.isEmpty());
	}
}
