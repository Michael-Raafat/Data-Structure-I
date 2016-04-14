package eg.edu.alexu.csd.datastructure.linkedList.cs59.tests;

import org.junit.Assert;
import org.junit.Test;

import eg.edu.alexu.csd.datastructure.linkedList.cs59.DoubleList;
import eg.edu.alexu.csd.datastructure.linkedList.cs59.Polysolver;
import eg.edu.alexu.csd.datastructure.linkedList.cs59.SingleList;
/**
 *
 * @author Amr
 *
 */
public class Mytests {
	/**
	 * constant.
	 */
	private final int magic1 = 1;
	/**
	 * constant.
	 */
	private final int magic3 = 3;
	/**
	 * constant.
	 */
	private final int magic6 = 6;
	/**
	 * constant.
	 */
	private final int magic8 = 8;
	/**
	 * constant.
	 */
	private final int magic9 = 9;
	/**
	 * constant.
	 */
	private final int magic4 = 4;
	/**
	 * constant.
	 */
	private final int magic5 = 5;
	/**
	 * constant.
	 */
	private final int magic11 = 11;
	/**
	 * constant.
	 */
	private final int magic7 = 7;
	/**
	 * constant.
	 */
	private final int magic12 = 12;
	/**
	 * constant.
	 */
	private final int magic16 = 16;
	/**
	 * constant.
	 */
	private final int magic20 = 20;
	/**
	 * constant.
	 */
	private final int magic23 = 23;
	/**
	 * constant.
	 */
	private final int magic15 = 15;
	/**
	 * constant.
	 */
	private final int magic13 = 13;
	/**
	 * constant.
	 */
	private final int magic10 = 10;
	/**
	 * constant.
	 */
	private final int magic40 = 40;
	/**
	 * constant.
	 */
	private final int magic120 = 120;
	/**
	 * constant.
	 */
	private final int magic180 = 180;
	/**
	 * constant.
	 */
	private final int magic37 = 37;
	/**
	 * constant.
	 */
	private final int magic220 = 220;
	/**
	 * constant.
	 */
	private final int magic80 = 80;
	/**
	 * test on doubleList.
	 */
	@Test
	public final void testdoubleList() {
		DoubleList dd = new DoubleList();
		Assert.assertEquals(true, dd.isEmpty());
		dd.add(magic5);
		dd.add(magic6);
		dd.add(magic3);
		Assert.assertEquals(magic3, dd.size());
		Assert.assertEquals(magic5, dd.get(0));
		Assert.assertEquals(magic6, dd.get(magic1));
		Assert.assertEquals(magic3, dd.get(2));
		dd.add(magic1, magic8);
		Assert.assertEquals(magic8, dd.get(1));
		Assert.assertEquals(magic6, dd.get(2));
		Assert.assertEquals(magic3, dd.get(magic3));
		Assert.assertEquals(magic3, dd.sublist(0, 2).size());
		Assert.assertEquals(magic8, dd.sublist(0, 2).get(1));
		Assert.assertEquals(magic6, dd.sublist(0, 2).get(2));
		Assert.assertEquals(magic6, dd.sublist(1, magic3).get(1));
		dd.set(1, magic9);
		Assert.assertEquals(magic9, dd.get(1));
		Assert.assertEquals(magic4, dd.size());
		dd.remove(1);
		Assert.assertEquals(magic3, dd.size());
		Assert.assertEquals(magic5, dd.get(0));
		Assert.assertEquals(magic6, dd.get(1));
		Assert.assertEquals(magic3, dd.get(2));
		Assert.assertEquals(true, dd.contains(magic6));
		Assert.assertEquals(false, dd.contains(magic8));
		Assert.assertEquals(true, dd.contains(magic5));
		Assert.assertEquals(true, dd.contains(magic3));
		dd.clear();
		Assert.assertEquals(true, dd.isEmpty());
		dd.add(0, magic5);
		dd.add(1, magic11);
		Assert.assertEquals(magic5, dd.get(0));
		Assert.assertEquals(magic11, dd.get(1));
		Assert.assertEquals(magic11, dd.sublist(1, 1).get(0));
		dd.remove(0);
		Assert.assertEquals(1, dd.size());
		Assert.assertEquals(magic11, dd.get(0));
		dd.remove(0);
		Assert.assertEquals(true, dd.isEmpty());
	}
	/**
	 * test on singleList.
	 */
	@Test
	public final void testsingleList() {
		SingleList dd = new SingleList();
		Assert.assertEquals(true, dd.isEmpty());
		dd.add(magic5);
		dd.add(magic6);
		dd.add(magic3);
		Assert.assertEquals(magic3, dd.size());
		Assert.assertEquals(magic5, dd.get(0));
		Assert.assertEquals(magic6, dd.get(1));
		Assert.assertEquals(magic3, dd.get(2));
		dd.add(1, magic8);
		Assert.assertEquals(magic8, dd.get(1));
		Assert.assertEquals(magic6, dd.get(2));
		Assert.assertEquals(magic3, dd.get(magic3));
		Assert.assertEquals(magic3, dd.sublist(0, 2).size());
		Assert.assertEquals(magic8, dd.sublist(0, 2).get(1));
		Assert.assertEquals(magic6, dd.sublist(0, 2).get(2));
		Assert.assertEquals(magic6, dd.sublist(1, magic3).get(1));
		dd.set(1, magic9);
		Assert.assertEquals(magic9, dd.get(1));
		Assert.assertEquals(magic4, dd.size());
		dd.remove(1);
		Assert.assertEquals(magic3, dd.size());
		Assert.assertEquals(magic5, dd.get(0));
		Assert.assertEquals(magic6, dd.get(1));
		Assert.assertEquals(magic3, dd.get(2));
		Assert.assertEquals(true, dd.contains(magic6));
		Assert.assertEquals(false, dd.contains(magic8));
		Assert.assertEquals(true, dd.contains(magic5));
		Assert.assertEquals(true, dd.contains(magic3));
		dd.clear();
		Assert.assertEquals(true, dd.isEmpty());
		dd.add(0, magic5);
		dd.add(1, magic11);
		Assert.assertEquals(magic5, dd.get(0));
		Assert.assertEquals(magic11, dd.get(1));
		Assert.assertEquals(magic11, dd.sublist(1, 1).get(0));
		dd.remove(0);
		Assert.assertEquals(1, dd.size());
		Assert.assertEquals(magic11, dd.get(0));
		dd.remove(0);
		Assert.assertEquals(true, dd.isEmpty());
		dd.add(0);
		dd.add(1, 'r');
		dd.add(2, 2);
		Assert.assertEquals(magic3, dd.size());
		Assert.assertEquals(true, dd.contains('r'));

	}
	/**
	 * test on double List.
	 */
	@Test
	public final void testdobulee() {
		DoubleList dd = new DoubleList();
		dd.add(1);
		dd.add(magic9);
		dd.add(magic8);
		dd.add(magic7);
		dd.add(magic6);
		dd.add(magic5);
		dd.add(magic4);
		dd.add(magic3);
		dd.add(2);
		dd.add(magic10);
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
	/**
	 * test on polynomial solver.
	 */
	@Test
	public final void equ() {
		Polysolver pl = new Polysolver();
		int[][] eq1 = new int[magic3][2];
		eq1[0][0] = magic3;
		eq1[0][1] = magic3;
		eq1[1][0] = magic4;
		eq1[1][1] = 1;
		eq1[2][0] = magic5;
		eq1[2][1] = 0;
		int[][] eq2 = new int[2][2];
		eq2[0][0] = magic4;
		eq2[0][1] = 1;
		eq2[1][0] = -magic4;
		eq2[1][1] = 0;
		pl.setPolynomial('A', eq1);
		pl.setPolynomial('B', eq2);
		Assert.assertEquals("4x^1+-4", pl.print('B'));
		float result = pl.evaluatePolynomial('A', 2);
		Assert.assertEquals(magic37, (long) result);
		int[][] add = new int[magic3][2];
		add[0][0] = magic3;
		add[0][1] = magic3;
		add[1][0] = magic8;
		add[1][1] = 1;
		add[2][0] = 1;
		add[2][1] = 0;
		int[][] subtract1 = new int[2][2];
		subtract1[0][0] = magic3;
		subtract1[0][1] = magic3;
		subtract1[1][0] = magic9;
		subtract1[1][1] = 0;
		int[][] subtract2 = new int[2][2];
		subtract2[0][0] = -magic3;
		subtract2[0][1] = magic3;
		subtract2[1][0] = -magic9;
		subtract2[1][1] = 0;
		int[][] multi = new int[magic5][2];
		multi[0][0] = magic12;
		multi[0][1] = magic4;
		multi[1][0] = -magic12;
		multi[1][1] = magic3;
		multi[2][0] = magic16;
		multi[2][1] = 2;
		multi[magic3][0] = magic4;
		multi[magic3][1] = 1;
		multi[magic4][0] = -magic20;
		multi[magic4][1] = 0;
		Assert.assertArrayEquals(add, pl.add('A', 'B'));
		Assert.assertArrayEquals(subtract1, pl.subtract('A', 'B'));
		Assert.assertArrayEquals(subtract2, pl.subtract('B', 'A'));
		Assert.assertArrayEquals(multi, pl.multiply('A', 'B'));
		pl.clearPolynomial('A');
		pl.clearPolynomial('B');
		int[][] l1 = {{2, 2 }, {1, 1 }, {1, 0 } };
		int[][] l2 = {{magic3, 2 }, {magic6, 1 }, {magic7, 0 } };
		pl.setPolynomial('A', l1);
		pl.setPolynomial('B', l2);
		int[][] multi2 = {{magic6, magic4 },
				{magic15, magic3 }, {magic23, 2 },
				{magic13, 1 }, {magic7, 0 } };
		Assert.assertArrayEquals(multi2, pl.multiply('A', 'B'));
		int[][] f1 = {{1, 1 }, {1, 0 } };
		int[][] f2 = {{1, 1 }, {-1, 0 } };
		int[][] multi3 = {{1, 2 }, {-1, 0 } };
		pl.setPolynomial('A', f1);
		pl.setPolynomial('B', f2);
		Assert.assertArrayEquals(multi3, pl.multiply('A', 'B'));
		int[][] x1 = {{magic40, 1 }, {-magic40, 0 } };
		int[][] x2 = {{-magic180, 1 }, {magic80, 0 } };
		pl.setPolynomial('A', x1);
		pl.setPolynomial('B', x2);
		int[][] multi33 = {{magic220, 1 }, {-magic120, 0 } };
		Assert.assertArrayEquals(multi33, pl.subtract('A', 'B'));
	}
}
