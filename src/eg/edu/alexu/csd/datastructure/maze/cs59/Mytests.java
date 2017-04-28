package eg.edu.alexu.csd.datastructure.maze.cs59;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class Mytests {
	
	@Test
	public void test() {
		MazeSolver m = new MazeSolver();
		File f = new File("maze.txt");
		int [][] ans = m.solveDFS(f);
		int [][] r = {{0,0},{1,0},{2,0},{3,0},{3,1},
				{3,2},{3,3},{2,3},{1,3},{1,4},{0,4}
		};
		int [][] x = {{0,0},{0,1},{1,1},{1,0},{2,0},{3,0},{3,1},
				{3,2},{3,3},{2,3},{1,3},{1,4},{0,4}
		};
		for(int i = 0; i < ans.length; i++) {
			Assert.assertEquals(x[i][0], ans[i][0]);
			Assert.assertEquals(x[i][1], ans[i][1]);
		}
		int [][] ans2 = m.solveBFS(f);
		for(int i = 0; i < ans2.length; i++) {
			Assert.assertEquals(r[i][0], ans2[i][0]);
			Assert.assertEquals(r[i][1], ans2[i][1]);
		}
	}
	/*
	@Test
	public void test2() {
		MazeSolver m = new MazeSolver();
		File f = new File("maze2.txt");
		Assert.assertArrayEquals(null, m.solveBFS(f));
		Assert.assertArrayEquals(null, m.solveDFS(f));
	}
	*/
	@Test
	public void test3() {
		MazeSolver m = new MazeSolver();
		File f = new File("maze3.txt");
		int [][] r = {{0,0},{1,0},{2,0},{2,1},{2,2},
				{1,2},{1,1},{0,1},{0,2}
		};
		int [][] a = {{0,0},{1,0},{2,0}
		};
	//	Assert.assertArrayEquals(a, m.solveBFS(f));
		Assert.assertArrayEquals(a, m.solveDFS(f));
	}
}
