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
		LinkedListBased q;
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
