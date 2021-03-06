package eg.edu.alexu.csd.datastructure.iceHockey.cs59;

import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author Michael.
 *
 */
public class My {
   /**
	 * magic numbers.
	 */
	private final int magic3 = 3, magic13 = 13, magic8 = 8,
			magic9 = 9, magic2 = 2, magic6 = 6,
			magic12 = 12, magic5 = 5, magic4 = 4;
	/**
	 * test corner.
	 */
	@Test
	public final void testCorner() {
		MyIceHockey pl = new MyIceHockey();
		java.awt.Point[] points = {
				new java.awt.Point(1, magic6),
				new java.awt.Point(magic13, magic6)};
		String[] photo = {"4QW4QW4",
				"T4REW4Q",
				"4Q4W4E4",
				"4ER4TY4" };
		Assert.assertArrayEquals("test1", points,
				pl.findPlayers(photo, magic4, magic5));
	}
	/**
	 * test direction.
	 */
	@Test
	public final void testDirections() {
		MyIceHockey pl = new MyIceHockey();
		java.awt.Point[] points = {};
		String[] photo = {"1J1U1B1U1",
				"R1U1R1E1W",
				"1P1R1N1B1",
				"P1O1N1S1D",
				"1E1E1E1E1" };
		Assert.assertArrayEquals("test2", points,
				pl.findPlayers(photo, 1, magic5));
	}
	/**
	 * test monster.
	 */
	@Test
	public final void testMonster() {
		MyIceHockey pl = new MyIceHockey();
		java.awt.Point[] points = {
				new java.awt.Point(magic13, magic8)};
		String[] photo = {"8888888888888",
				"8888888888888",
				"8888888888888",
				"8888888888888",
				"8QJ88R8SG88TY",
				"88V88B88OUZ8O",
				"88WF8Q8GG88B8",
				"8MX88D88888T8K8" };
		Assert.assertArrayEquals("test3", points,
				pl.findPlayers(photo, magic8, magic9));
	}

	/**
	 * test 4.
	 */
	@Test
	public final void test4() {
		MyIceHockey pl = new MyIceHockey();
		java.awt.Point[] points = {new java.awt.Point(magic8, magic2),
				new java.awt.Point(magic9, magic8)};
		String[] photo = {"44K44L444",
				"44J44T4X4",
				"44OEVI4F4",
				"4444444D4",
				"4VY4KBYM4",
				"4EW4H4ER4",
				"4U4ZDUS4",
				"444444444" };
		Assert.assertArrayEquals("test4", points,
				pl.findPlayers(photo, magic4, magic12));

	}
	/**
	 * test bigman.
	 */
	@Test
	public final void testBigMan() {
		MyIceHockey pl = new MyIceHockey();
		java.awt.Point[] points = {new java.awt.Point(magic9, magic8)};
		String[] photo = {"33KEEL333",
				"33JERT3X3",
				"33OEVI3F3",
				"3333333D3",
				"3VY3KBYM3",
				"3EW3H4ER3",
				"3UR4DUS3",
				"333333333" };
		Assert.assertArrayEquals("test5", points,
				pl.findPlayers(photo, magic3, magic3));

	}
}
