package eg.edu.alexu.csd.datastructure.linkedList.cs59.tests;


import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.cs59.doubleList;
import eg.edu.alexu.csd.datastructure.linkedList.cs59.singleList;


public class Mytests {

	@Test
	public void testdoubleList() {
		doubleList dd = new doubleList();
		Assert.assertEquals(true, dd.isEmpty());
		dd.add(5);
		dd.add(6);
		dd.add(3);
		Assert.assertEquals(3, dd.size());
		Assert.assertEquals(5, dd.get(0));
		Assert.assertEquals(6, dd.get(1));
		Assert.assertEquals(3, dd.get(2));
		dd.add(1, 8);
		Assert.assertEquals(8, dd.get(1));
		Assert.assertEquals(6, dd.get(2));
		Assert.assertEquals(3, dd.get(3));
		Assert.assertEquals(3, dd.sublist(0, 2).size());
		Assert.assertEquals(8, dd.sublist(0, 2).get(1));
		Assert.assertEquals(6, dd.sublist(0, 2).get(2));
		Assert.assertEquals(6, dd.sublist(1, 3).get(1));
		dd.set(1, 9);
		Assert.assertEquals(9, dd.get(1));
		Assert.assertEquals(4, dd.size());
		dd.remove(1);
		Assert.assertEquals(3, dd.size());
		Assert.assertEquals(5, dd.get(0));
		Assert.assertEquals(6, dd.get(1));
		Assert.assertEquals(3, dd.get(2));
		Assert.assertEquals(true, dd.contains(6));
		Assert.assertEquals(false, dd.contains(8));
		Assert.assertEquals(true, dd.contains(5));
		Assert.assertEquals(true, dd.contains(3));
		dd.clear();
		Assert.assertEquals(true, dd.isEmpty());
		dd.add(0, 5);
		dd.add(1, 11);
		Assert.assertEquals(5, dd.get(0));
		Assert.assertEquals(11, dd.get(1));
		Assert.assertEquals(11, dd.sublist(1, 1).get(0));
		dd.remove(0);
		Assert.assertEquals(1, dd.size());
		Assert.assertEquals(11, dd.get(0));
		dd.remove(0);
		Assert.assertEquals(true, dd.isEmpty());
	}
	@Test
	public void testsingleList() {
		singleList dd = new singleList();
		Assert.assertEquals(true, dd.isEmpty());
		dd.add(5);
		dd.add(6);
		dd.add(3);
		Assert.assertEquals(3, dd.size());
		Assert.assertEquals(5, dd.get(0));
		Assert.assertEquals(6, dd.get(1));
		Assert.assertEquals(3, dd.get(2));
		dd.add(1, 8);
		Assert.assertEquals(8, dd.get(1));
		Assert.assertEquals(6, dd.get(2));
		Assert.assertEquals(3, dd.get(3));
		Assert.assertEquals(3, dd.sublist(0, 2).size());
		Assert.assertEquals(8, dd.sublist(0, 2).get(1));
		Assert.assertEquals(6, dd.sublist(0, 2).get(2));
		Assert.assertEquals(6, dd.sublist(1, 3).get(1));
		dd.set(1, 9);
		Assert.assertEquals(9, dd.get(1));
		Assert.assertEquals(4, dd.size());
		dd.remove(1);
		Assert.assertEquals(3, dd.size());
		Assert.assertEquals(5, dd.get(0));
		Assert.assertEquals(6, dd.get(1));
		Assert.assertEquals(3, dd.get(2));
		Assert.assertEquals(true, dd.contains(6));
		Assert.assertEquals(false, dd.contains(8));
		Assert.assertEquals(true, dd.contains(5));
		Assert.assertEquals(true, dd.contains(3));
		dd.clear();
		Assert.assertEquals(true, dd.isEmpty());
		dd.add(0, 5);
		dd.add(1, 11);
		Assert.assertEquals(5, dd.get(0));
		Assert.assertEquals(11, dd.get(1));
		Assert.assertEquals(11, dd.sublist(1, 1).get(0));
		dd.remove(0);
		Assert.assertEquals(1, dd.size());
		Assert.assertEquals(11, dd.get(0));
		dd.remove(0);
		Assert.assertEquals(true, dd.isEmpty());
		
	}
}
