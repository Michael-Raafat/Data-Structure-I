package eg.edu.alexu.csd.datastructure.linkedList.cs59.tests;



import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.cs59.Polysolver;
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
		dd.add(0);
		dd.add(1,'r');
		dd.add(2,2);
		Assert.assertEquals(3, dd.size());
		Assert.assertEquals(true, dd.contains('r'));
		
	}
	@Test
	public void testdobulee(){
		doubleList dd = new doubleList();
		dd.add(1);
		dd.add(9);
		dd.add(8);
		dd.add(7);
		dd.add(6);
		dd.add(5);
		dd.add(4);
		dd.add(3);
		dd.add(2);
		dd.add(10);
		dd.remove(0);
		dd.remove(0);
		dd.remove(0);
		dd.remove(0);
		dd.remove(0);
		dd.remove(0);
		dd.remove(0);
		dd.remove(0);
		dd.remove(0);
		dd.remove(0);
		Assert.assertEquals(0, dd.size());
		
	}
	@Test
	public void equ(){
		Polysolver pl = new Polysolver();
		int [][]eq1 = new int[3][2];
		eq1[0][0]= 3;
		eq1[0][1]=3;
		eq1[1][0]=4;
		eq1[1][1]=1;
		eq1[2][0]=5;
		eq1[2][1]=0;
		int [][]eq2 = new int[2][2];
		eq2[0][0]= 4;
		eq2[0][1]=1;
		eq2[1][0]=-4;
		eq2[1][1]=0;
		pl.setPolynomial('A', eq1);
		pl.setPolynomial('B', eq2);
		Assert.assertEquals("4x^1+-4", pl.print('B'));
		float result= pl.evaluatePolynomial('A', 2);
		Assert.assertEquals(37, (long)result);
		int [][] add =new int [3][2];
		add[0][0]=3;
		add[0][1]=3;
		add[1][0]=8;
		add[1][1]=1;
		add[2][0]=1;
		add[2][1]=0;
		int [][] subtract1 =new int [2][2];
		subtract1[0][0]=3;
		subtract1[0][1]=3;
		subtract1[1][0]=9;
		subtract1[1][1]=0;
		int [][] subtract2 =new int [2][2];
		subtract2[0][0]=-3;
		subtract2[0][1]=3;
		subtract2[1][0]=-9;
		subtract2[1][1]=0;
		int [][] multi =new int [5][2];
		multi[0][0]=12;
		multi[0][1]=4;
		multi[1][0]=-12;
		multi[1][1]=3;
		multi[2][0]=16;
		multi[2][1]=2;
		multi[3][0]=4;
		multi[3][1]=1;
		multi[4][0]=-20;
		multi[4][1]=0;
         Assert.assertArrayEquals(add, pl.add('A', 'B'));
         Assert.assertArrayEquals(subtract1, pl.subtract('A', 'B'));
        Assert.assertArrayEquals(subtract2, pl.subtract('B', 'A'));
         Assert.assertArrayEquals(multi, pl.multiply('A', 'B'));
		
	}
}
