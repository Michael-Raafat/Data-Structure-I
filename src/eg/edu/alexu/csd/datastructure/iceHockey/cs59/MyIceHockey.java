package eg.edu.alexu.csd.datastructure.iceHockey.cs59;

import java.awt.Point;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;
/**
 *
 * @author Michael.
 *
 */
public class MyIceHockey implements IPlayersFinder {
   /**
	 * magic numbers.
	 */
	private final int magic0 = 0, magic1 = 1,
			magic100 = 100, magic2500 = 2500,
			magic1000 = 1000,
			magic4 = 4;
	/**
	 * array 2d to store picture.
	 */
	private char[][] a = new char[magic100][magic100];
	/**
	 * array of points.
	 */
	private Point[] it = new Point[magic2500];
	/**
	 * many variables.
	 */
	private int down = magic0, zew = magic1, up = magic0, left = magic0,
			right = magic0,
			ioo = magic0, ioo1 = magic0,
			foo = magic0, joo = magic0,
			joo1 = magic0, joo2 = magic0, f = magic0;
    /**
     * to set the array.
     * @param photo
     * the picture.
     */
	public final void settingarray(final String[] photo) {
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[i].length(); j++) {
				a[i][j] = photo[i].charAt(j);
			}
		}

	}
    /**
     * to sort array of points.
     * @param real
     * array of points.
     */
	public final void arraysort(final Point[] real) {
		Point temp = new java.awt.Point(magic1000, magic1000);
		if (real.length >= 0 && real[0] != null) {
			for (int i = 0; i < real.length - 1; i++) {
				for (int j = i + 1; j < real.length; j++) {

					if (real[i].x > real[j].x) {

						temp = real[j];
						real[j] = real[i];
						real[i] = temp;
					} else if (real[i].x == real[j].x) {
						if (real[i].y > real[j].y) {
							temp = real[j];
							real[j] = real[i];
							real[i] = temp;
						}

					}

				}
			}
		}

	}
    @Override
	public final Point[] findPlayers(
			final String[] photo, final int team,
			final int threshold) {
		settingarray(photo);
		for (int i = 0; i < photo.length; i++) {
			for (int j = 0; j < photo[i].length(); j++) {
				foo = i;
				ioo = i;
				ioo1 = i;
				if (a[i][j]
						==
					String.valueOf(team).toCharArray()[0]) {

					joo = j;
					joo1 = j;
					joo2 = j;
					Point hhh = centre(
						i, j, a, threshold,
						photo[i].length(), team);
					if (hhh != null) {
						it[f] = hhh;
						f++;
					}
				}
			}
		}
		Point[] real = new Point[f];
		for (int i = 0; i < f; i++) {
			real[i] = it[i];
		}
		if (f != 0) {
			arraysort(real);
		}
		f = 0;
		return real;
	}
   /**
     * recursive method.
     * @param i
     * x.
     * @param j
     * y.
     * @param s
     * array 2d.
     * @param threshold
     * area.
     * @param length
     * size.
     * @param team
     * number.
     * @return point.
     */
	public final Point centre(final int i, final int j,
			final char[][] s, final int threshold,
			final int length, final int team) {
		s[i][j] = '-';
		if (i + 1 < s.length && s[i + 1][j]
				==
				String.valueOf(team).toCharArray()[0]) {
			if (i + 1 < s.length) {
				s[i + 1][j] = '-';
			}
			zew++;
			if (i + 1 > ioo1) {
				down++;
				ioo1 = i + 1;
			}
			if (i + 1 < s.length) {
				centre(i + 1, j, a, threshold, length, team);
			}
		}
		if (j + 1 < length && s[i][j + 1]
				== String.valueOf(team).toCharArray()[0]) {
			if (j + 1 < s.length) {
				s[i][j + 1] = '-';
			}
			zew++;
			if (j + 1 > joo1) {
				right++;
				joo1 = j + 1;
			}
			centre(i, j + 1, a, threshold, length, team);
		}
		if (j - 1 >= 0 && s[i][j - 1]
				==
				String.valueOf(team).toCharArray()[0]) {
			if (j - 1 >= 0) {
				s[i][j - 1] = '-';
			}
			zew++;
			if (j - 1 < joo2) {
				left++;
				joo2 = j - 1;
			}
			if (j - 1 >= 0) {
				centre(i, j - 1, a, threshold, length, team);
			}
		}
		if (i - 1 >= 0 && s[i - 1][j]
				==
				String.valueOf(team).toCharArray()[0]) {
			if (i >= 0) {
				s[i - 1][j] = '-';
			}
			zew++;
			if (i - 1 < ioo) {
				up++;
				ioo = i - 1;
			}
			if (i - 1 >= 0) {
				centre(i - 1, j, a, threshold, length, team);
			}

		}
		if (foo == i && joo == j) {
			if ((magic4 * zew) >= threshold) {
				int centrex = 0, centrey = 0;
				int y = up + down + 1;
				int x = left + right + 1;
				if (j > joo2) {
					centrex = x + joo2 * 2;
				} else {
					centrex = x + j * 2;
				}
				if (i > ioo) {
					centrey = y + ioo * 2;
				} else {
					centrey = y + i * 2;
				}
				up = 0;
				down = 0;
				left = 0;
				right = 0;
				zew = 1;
				joo1 = 0;
				joo2 = 0;
				ioo1 = 0;
				ioo = 0;
				Point point =
				new java.awt.Point(centrex, centrey);

				return point;
			} else {
				up = 0;
				down = 0;
				left = 0;
				right = 0;
				zew = 1;
				joo1 = 0;
				joo2 = 0;
				ioo1 = 0;
				ioo = 0;
				Point point = null;
				return point;
			}
		} else {
			return null;
		}
	}

}
