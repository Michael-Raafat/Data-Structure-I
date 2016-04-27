package eg.edu.alexu.csd.datastructure.stack.cs59.menu;
import eg.edu.alexu.csd.datastructure.stack.cs59.MyExpression;

import java.util.Scanner;
/**
 *
 * @author Michael.
 *
 */
public class MyInfixtoPostfix {
	/**
	 *
	 * @param args not used.
	 */
	public static void main(final String[] args) {
		Scanner string = new Scanner(System.in);
		MyExpression my = new MyExpression();
		try {
			System.out.print("Enter your expression: ");
			String g = string.nextLine();
			String r = my.infixToPostfix(g);
			System.out.println(my.evaluate(r));
		} catch (RuntimeException e) {
	      System.out.println("ERROR! Invalid Infix!");
		}
	}
}
