package eg.edu.alexu.csd.datastructure.maze.cs59;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.queue.cs59.LinkedListBased;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
/**
 *
 * @author Michael
 *
 */
public class MazeSolver implements IMazeSolver {
    /**
     * length of array.
     */
	int n = 0, m = 0;
	/**
	 * magic number.
	 */
	final int boo = 10;
	@Override
	public int[][] solveBFS(final File maze) {
		// TODO Auto-generated method stub
		LinkedListBased q = new LinkedListBased();
		StringBuilder h = new StringBuilder();
		try {
			String zew;
			Scanner s = new Scanner(maze);
			if (s.hasNext()) {
				zew = s.nextLine();
				for (int i = 0; i < zew.length(); i++) {
					if (n == 0) {
						if (isNumber(zew.charAt(i))) {
						n += Integer.valueOf(
			 				String.valueOf(
			 		 		zew.charAt(i)));
						while (isNumber(
							zew.charAt(i + 1))) {
							i++;
							n *= boo;
							n += Integer.valueOf(
			 					String.valueOf(
			 		 			zew.charAt(i)));
							}
						}
					} else if (m == 0) {
						if (isNumber(zew.charAt(i))) {
						 m += Integer.valueOf(
			 					String.valueOf(
			 		 			zew.charAt(i)));
						while (i + 1 < zew.length()
								&& isNumber(
							zew.charAt(i + 1))) {
							i++;
							m *= boo;
							m += Integer.valueOf(
			 				String.valueOf(
			 		 		zew.charAt(i)));
							}
						}
					} else if (zew.charAt(i) != ' ') {
						throw new RuntimeException();
					}
				}
			}
			if (s.hasNext()) {
				zew = s.nextLine();
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < m; k++) {
						h.append(zew.charAt(k));
						if (k == m - 1
						&& zew.charAt(k + 1) != ' ') {
						throw new RuntimeException();
						}
					}
					zew = s.nextLine();
					if (j == n - 1 && s.hasNext()) {
						throw new RuntimeException();
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char[][] f = new char[n][m];
		int b = 0;
		for (int y = 0; y < n; y++) {
			for (int z = 0; z < m; z++) {
				f[y][z] = h.charAt(b);
				b++;
			}
		}
		int[][][] s = new int [200][100][2];
		int[][][] v = new int [200][100][2];
		boolean d = true;
		for (int t = 0; t < n; t++) {
			for (int r = 0; r < m; n++) {
				if (f[t][r] == 's') {
					d = false;
					if (r + 1 < m
						&& f[t][r + 1] == '.') {
						q.enqueue(f[t][r + 1]);
					}
					if (t + 1 < n
							&& f[t + 1][r] == '.') {
						q.enqueue(f[t + 1][r]);
					}
					if (r - 1 >= 0
							&& f[t][r - 1] == '.') {
						q.enqueue(f[t][r - 1]);
					}
					if (t - 1 >= 0
							&& f[t - 1][r] == '.') {
						q.enqueue(f[t - 1][r]);
					}
				}
			}
		}
		if (d) {
			throw new RuntimeException();
		}
		return null;
	}
	/**
	 * check.
	 * @param c character.
	 * @return true or false
	 */
	public boolean isNumber(final char c) {
		if (c >= '0' && c <= '9') {
			return true;
		}
		return false;
	}

	@Override
	public int[][] solveDFS(final File maze) {
		// TODO Auto-generated method stub
		StringBuilder h = new StringBuilder();
		try {
			String zew;
			Scanner s = new Scanner(maze);
			if (s.hasNext()) {
				zew = s.nextLine();
				for (int i = 0; i < zew.length(); i++) {
					if (n == 0) {
						if (isNumber(zew.charAt(i))) {
						n += Integer.valueOf(
			 				String.valueOf(
			 		 		zew.charAt(i)));
						while (isNumber(
							zew.charAt(i + 1))) {
							i++;
							n *= boo;
							n += Integer.valueOf(
			 					String.valueOf(
			 		 			zew.charAt(i)));
							}
						}
					} else if (m == 0) {
						if (isNumber(zew.charAt(i))) {
						 m += Integer.valueOf(
			 					String.valueOf(
			 		 			zew.charAt(i)));
						while (i + 1 < zew.length()
								&& isNumber(
							zew.charAt(i + 1))) {
							i++;
							m *= boo;
							m += Integer.valueOf(
			 				String.valueOf(
			 		 		zew.charAt(i)));
							}
						}
					} else if (zew.charAt(i) != ' ') {
						throw new RuntimeException();
					}
				}
			}
			if (s.hasNext()) {
				zew = s.nextLine();
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < m; k++) {
						h.append(zew.charAt(k));
						if (k == m - 1
						&& zew.charAt(k + 1) != ' ') {
						throw new RuntimeException();
						}
					}
					zew = s.nextLine();
					if (j == n - 1 && s.hasNext()) {
						throw new RuntimeException();
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char[][] f = new char[n][m];
		int b = 0;
		for (int y = 0; y < n; y++) {
			for (int z = 0; z < m; z++) {
				f[y][z] = h.charAt(b);
				b++;
			}
		}
		return null;
	}

}
