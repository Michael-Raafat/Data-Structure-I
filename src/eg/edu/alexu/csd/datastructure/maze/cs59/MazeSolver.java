package eg.edu.alexu.csd.datastructure.maze.cs59;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.cs59.LinkedListBased;
import eg.edu.alexu.csd.datastructure.stack.cs59.MyStack;
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
	 * magic numbers.
	 */
	final int boo = 10;
	@Override
	public int[][] solveBFS(final File maze) {
		// TODO Auto-generated method stub
		LinkedListBased q = new LinkedListBased();
		StringBuilder h = new StringBuilder();
		n = 0;
		m = 0;
		try {
			String zew;
			Scanner s = new Scanner(maze);
			if (s.hasNext()) {
				n = s.nextInt();
				m = s.nextInt();
           }
			if (s.hasNext()) {
				int you = 0, me = 0;
				for (int j = 0; j < n; j++) {
					zew = s.next();
					for (int k = 0; k < m; k++) {
						h.append(zew.charAt(k));
						if (Character.valueOf(
					 zew.charAt(k)).equals('S')) {
							you++;
					} else if (Character.valueOf(
						zew.charAt(k)).equals('E')) {
						me = 1;
					}
				}
				}
				if (me == 0 || you > 1) {
					throw new RuntimeException();
				}
			} else {
				throw new RuntimeException();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}
		Node[][] f = new Node[n][m];
		int b = 0;
		for (int y = 0; y < n; y++) {
			for (int z = 0; z < m; z++) {
				f[y][z] = new Node();
				f[y][z].setVal(h.charAt(b));
				f[y][z].setCoordinates(y, z);
				b++;
			}
		}
		int fx = 0, fy = 0, kaza = 0;
		boolean d = true, p = true;
		for (int t = 0; t < n; t++) {
			for (int r = 0; r < m; r++) {
				if (Character.valueOf((char)
						f[t][r].getVal()) == 'S') {
					kaza++;
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
					    if (String.valueOf(
		    f[x][y].getVal()).toCharArray()[0] == 'E') {
					    	p = false;
					    	fx = Integer.valueOf(
					   	String.valueOf(f[x][y].getx()));
					  fy = Integer.valueOf(
					String.valueOf(f[x][y].gety()));
					    	break;
					    }
					    if (x - 1 >= 0
				&& (String.valueOf(f[x - 1][y].getVal(
						)).toCharArray()[0] == '.'
							|| String.valueOf(
							f[x - 1][y].
							getVal()).toCharArray(
							)[0] == 'E')
					&& !f[x - 1][y].getVisited()) {
				    f[x - 1][y].setParent(f[x][y]);
							q.enqueue(f[x - 1][y]);
				    f[x - 1][y].setVisited(true);
						}
					    if (y + 1 < m
						&& (String.valueOf(
							f[x][y + 1].getVal(
						)).toCharArray()[0] == '.'
							|| String.valueOf(
							f[x][y + 1].getVal(
							)).toCharArray(
							)[0] == 'E')
					&& !f[x][y + 1].getVisited()) {
					f[x][y + 1].setParent(f[x][y]);
							q.enqueue(f[x][y + 1]);
					f[x][y + 1].setVisited(true);
						}
						if (x + 1 < n
				&& (String.valueOf(
				f[x + 1][y].getVal())
				.toCharArray()[0] == '.'
			  || String.valueOf(f[x + 1][y].getVal(
			 )).toCharArray()[0] == 'E')
					&& !f[x + 1][y].getVisited()) {
					f[x + 1][y].setParent(f[x][y]);
							q.enqueue(f[x + 1][y]);
					f[x + 1][y].setVisited(true);
						}
						if (y - 1 >= 0
						&& (String.valueOf(
						f[x][y - 1].getVal(
						)).toCharArray()[0] == '.'
						|| String.valueOf(
						f[x][y - 1].getVal(
						)).toCharArray(
						)[0] == 'E')
						&& !f[x][y - 1].getVisited()) {
					    f[x][y - 1].setParent(f[x][y]);
						q.enqueue(f[x][y - 1]);
						f[x][y - 1].setVisited(true);
							}
						}
				}
			}
		}
		if (!d && p) {
			return null;
		}
		if (d || p || kaza > 1) {
			 throw new RuntimeException();
		}
		LinkedListBased s = new LinkedListBased();
		Node t = f[fx][fy];
		while (String.valueOf(t.getVal())
				.toCharArray()[0] != 'S') {
			s.enqueue(t);
			t = t.getParent();
		}
		s.enqueue(t);
		int size = s.size();
		int[][] nn = new int[size][2];
		for (int a = size - 1; a >= 0; a--) {
			Node v = (Node) s.dequeue();
			nn[a][0] = Integer.valueOf(String.valueOf(v.getx()));
			nn[a][1] = Integer.valueOf(String.valueOf(v.gety()));
		}
		return nn;
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
		MyStack q = new MyStack();
		StringBuilder h = new StringBuilder();
		n = 0;
		m = 0;
		try {
			String zew;
			Scanner s = new Scanner(maze);
			if (s.hasNext()) {
				n = s.nextInt();
				m = s.nextInt();
			}
			if (s.hasNext()) {
				int you = 0, me = 0;
				for (int j = 0; j < n; j++) {
					zew = s.next();
					for (int k = 0; k < m; k++) {
						h.append(zew.charAt(k));
						if (Character.valueOf(
					zew.charAt(k)).equals('S')) {
							you++;
					} else if (Character.valueOf(
					zew.charAt(k)).equals('E')) {
							me = 1;
						}
					}
				}
				if (me == 0 || you > 1) {
					throw new RuntimeException();
				}
			} else {
				throw new RuntimeException();
			}
		} catch (FileNotFoundException e) {
			throw new RuntimeException();
		}
		Node[][] f = new Node[n][m];
		int b = 0;
		for (int y = 0; y < n; y++) {
			for (int z = 0; z < m; z++) {
				f[y][z] = new Node();
				f[y][z].setVal(h.charAt(b));
				f[y][z].setCoordinates(y, z);
				b++;
			}
		}
		int fx = 0, fy = 0, kaz = 0;
		boolean d = true, p = true;
		for (int t = 0; t < n; t++) {
			for (int r = 0; r < m; r++) {
				if (Character.valueOf((char)
						f[t][r].getVal()) == 'S') {
					kaz++;
					d = false;
					f[t][r].setVisited(true);
					q.push(f[t][r]);
					while (!q.isEmpty()) {
						Node temp = new Node();
						temp = (Node) q.pop();
					    int x = Integer.valueOf(
					    String.valueOf(temp.getx()));
					    int y = Integer.valueOf(
					String.valueOf(temp.gety()));
					    f[x][y].setVisited(true);
					    if (String.valueOf(
				     f[x][y].getVal()).toCharArray(
						)[0] == 'E') {
					    	p = false;
					    	fx = Integer.valueOf(
					    	String.valueOf(f[x][y].getx()));
					    	fy = Integer.valueOf(
					String.valueOf(f[x][y].gety()));
					    	break;
					    }
					    if (y - 1 >= 0
					&& (String.valueOf(
					f[x][y - 1].getVal(
					)).toCharArray()[0] == '.'
					|| String.valueOf(f[x][y - 1].getVal(
					)).toCharArray()[0] == 'E')
					&& !f[x][y - 1].getVisited()) {
					f[x][y - 1].setParent(f[x][y]);
					q.push(f[x][y - 1]);
									    }
					    if (x + 1 < n
					 && (String.valueOf(f[x + 1][y].getVal(
					 )).toCharArray()[0] == '.'
					 || String.valueOf(f[x + 1][y].getVal(
					 )).toCharArray()[0] == 'E')
					 && !f[x + 1][y].getVisited()) {
					 f[x + 1][y].setParent(f[x][y]);
					 q.push(f[x + 1][y]);
							}
					    if (y + 1 < m
					 && (String.valueOf(
					 f[x][y + 1].getVal(
					 )).toCharArray()[0] == '.'
					 || String.valueOf(f[x][y + 1].getVal(
				     )).toCharArray()[0] == 'E')
					 && !f[x][y + 1].getVisited()) {
					 f[x][y + 1].setParent(f[x][y]);
					 q.push(f[x][y + 1]);
									}
					    if (x - 1 >= 0
						&& (String.valueOf(
						f[x - 1][y].getVal()).
					toCharArray()[0] == '.'
					|| String.valueOf(f[x - 1][y].getVal(
				   )).toCharArray()[0] == 'E')
				 && !f[x - 1][y].getVisited()) {
				f[x - 1][y].setParent(f[x][y]);
						q.push(f[x - 1][y]);
						}
						}
				}
			}
		}
		if (!d && p) {
			return null;
		}
		if (d || p || kaz > 1) {
			throw new RuntimeException();
		}
		MyStack s = new MyStack();
		Node t = f[fx][fy];
		while (String.valueOf(t.getVal())
				.toCharArray()[0] != 'S') {
			s.push(t);
			t = t.getParent();
		}
		s.push(t);
		int size = s.size();
		int[][] nn = new int[size][2];
		for (int a = 0; a < size; a++) {
			Node v = (Node) s.pop();
			nn[a][0] = Integer.valueOf(String.valueOf(v.getx()));
			nn[a][1] = Integer.valueOf(String.valueOf(v.gety()));
		}
		return nn;	}

}
