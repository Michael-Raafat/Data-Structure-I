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
 
	int n = 0, m = 0;
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
				for(int i = 0; i < zew.length(); i++) {
					if (n == 0) {
						if (isNumber(zew.charAt(i))) {
							n += Integer.valueOf(
			 						String.valueOf(
			 		 				zew.charAt(i)));
						while (isNumber(zew.charAt(i+1))) {
								i++;
								n *= 10;
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
						while (isNumber(zew.charAt(i+1))) {
								i++;
								m *= 10;
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
						if (k == m - 1 && zew.charAt(k+1) != ' ') {
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
		char [][] f = new char [n][m];
		int b = 0;
		for (int y = 0; y < n; y++) {
			for (int z = 0; z < m; z++) {
				f[y][z] = h.charAt(b);
				b++;
			}
		}
		boolean d = true;
		for (int t = 0; t < n; t++) {
			for (int r = 0; r < m; n++) {
				if (f[t][r] == 's'){
					d = false;
					if (r + 1 < m && f[t][r+1] == '.') {
						q.enqueue(f[t][r+1]);
					} else if (t + 1 < n && f[t+1][r] == '.') {
						q.enqueue(f[t+1][r]);
					} else if (r - 1 >= 0 && f[t][r-1] == '.') {
						q.enqueue(f[t][r-1]);
					} else if (t - 1 >= 0 && f[t-1][r] == '.') {
						q.enqueue(f[t-1][r]);
					}
					
				}
			}
		}
		if (d == true) {
			throw new RuntimeException();
		}
		
		
		return null;
	}
	/**
	 * check.
	 * @param c
	 * @return true or false
	 */
	public boolean isNumber(char c) {
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
				for(int i = 0; i < zew.length(); i++) {
					if (n == 0) {
						if (isNumber(zew.charAt(i))) {
							n += Integer.valueOf(
			 						String.valueOf(
			 		 				zew.charAt(i)));
						while (isNumber(zew.charAt(i+1))) {
								i++;
								n *= 10;
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
						while (isNumber(zew.charAt(i+1))) {
								i++;
								m *= 10;
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
						if (k == m - 1 && zew.charAt(k+1) != ' ') {
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
		return null;
	}

}
