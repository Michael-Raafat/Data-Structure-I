package eg.edu.alexu.csd.datastructure.maze.cs59;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs59.LinkedListBased;
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
						while (i + 1 < zew.length()
								&& isNumber(
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
				for (int j = 0; j < n; j++) {
					zew = s.nextLine();
					for (int k = 0; k < m; k++) {
						h.append(zew.charAt(k));
					}
					if (j == n - 1 && s.hasNext()) {
						throw new RuntimeException();
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException();
		}
		Node [][] f = new Node[n][m];
		int b = 0;
		for (int y = 0; y < n; y++) {
			for (int z = 0; z < m; z++) {
				f[y][z].setVal(h.charAt(b));
				f[y][z].setCoordinates(y, z);
				b++;
			}
		}
		int fx = 0, fy = 0;
		boolean d = true;
		for (int t = 0; t < n; t++) {
			for (int r = 0; r < m; n++) {
				if (Character.valueOf((char)
						f[t][r].getVal()) == 'S') {
					d = false;
					f[t][r].setVisited(true);
					q.enqueue(f[t][r]);
					while (!q.isEmpty()) {
						Node temp = new Node();
						temp = (Node) q.dequeue();
					    int x = Integer.valueOf(
					    String.valueOf(temp.getx()));
					    int y = Integer.valueOf(
							    String.valueOf(temp.gety()));
					    f[x][y].setVisited(true);
					    if (Character.valueOf((char)
						f[x][y].getVal()) == 'E'
						&& !f[x][y].getVisited()) {
					    	fx = Integer.valueOf(
					    	String.valueOf(f[x][y].getx()));
					    	fy = Integer.valueOf(
							    	String.valueOf(f[x][y].gety()));
					    	break;
					    }
						if (r - 1 >= 0
								&& Character.valueOf((char)
								f[x][y - 1].getVal()) == '.'
								&& !f[x][y].getVisited()) {
							    f[x][y - 1].setParent(f[x][y]);
								q.enqueue(f[x][y - 1]);
							}
							if (t + 1 < n
									&& Character.valueOf((char)
									f[x + 1][y].getVal()) == '.'
									&& !f[x][y].getVisited()) {
								f[x + 1][y].setParent(f[x][y]);
								q.enqueue(f[x + 1][y]);
							}
							if (r + 1 < m
									&& Character.valueOf((char)
									f[x][y + 1].getVal()) == '.'
									&& !f[x][y].getVisited()) {
								f[x][y + 1].setParent(f[x][y]);
								q.enqueue(f[x][y + 1]);
							}
							if (t - 1 >= 0
									&& Character.valueOf((char)
									f[x - 1][y].getVal()) == '.'
									&& !f[x][y].getVisited()) {
								f[x - 1][y].setParent(f[x][y]);
								q.enqueue(f[x - 1][y]);
							}
					}
					
				}
			}
		}
		if (d) {
			throw new RuntimeException();
		}
		LinkedListBased s = new LinkedListBased();
		Node t = f[fx][fy];
		while (t.getVal() != null) {
			s.enqueue(t);
			t = t.getParent();
		}
		int size = s.size();
		int[][] n = new int [size][size];
		for (int a = size - 1; a >= 0; a--) {
			Node v = (Node) s.dequeue();
			n[a][0] = Integer.valueOf(String.valueOf(v.getx()));
			n[a][1] = Integer.valueOf(String.valueOf(v.gety()));
		}
		return n;
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
						if (k + 1 < zew.length()
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
			throw new RuntimeException();
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
