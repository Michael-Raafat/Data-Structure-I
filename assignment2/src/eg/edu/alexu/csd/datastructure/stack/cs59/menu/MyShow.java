package eg.edu.alexu.csd.datastructure.stack.cs59.menu;
import eg.edu.alexu.csd.datastructure.stack.cs59.MyStack;

import java.util.Scanner;
/**
 *
 * @author Michael
 *
 */
public class MyShow {
	/**
	 *
	 * *@param args
	 * *not used.
	 **/
	public static void main(final String[] args) {
	MyStack yes = new MyStack();
	final int one = 1,
			two = 2,
			three = 3,
			four = 4,
			five = 5,
			six = 6;
	int k = 0;
	Scanner input = new Scanner(System.in);
	String j;
	do {
		System.out.print("1: Push."
				+ "\n2: Pop."
				+ "\n3: Peek."
				+ "\n4: Get size."
				+ "\n5: Check if empty."
				+ "\n6: Exit."
				+ "\n====================\n");
		    k = input.nextInt();
		    if (k == six) {
		    	break;
		    } else {
			switch (k) {
			case one :
				System.out.print("Enter an element : ");
				j = input.next();
				boolean r = true;
				for (int i = 0; i < j.length(); i++) {
					if (j.charAt(i) != ' ') {
						r = false;
					}
				}
				if (r) {
					System.out.println(
					 	"Error! Enter a valid input");
					break;
				}
				yes.push(j);
				break;
			case two :
				if (yes.size() == 0) {
					System.out.println(
						 "Error! Stack is empty");
					break;
				}
				System.out.println(yes.pop());
				break;
			case three :
				if (yes.size() == 0) {
					System.out.println(
						 "Error! Stack is empty");
					break;
				}
				System.out.println(yes.peek());
				break;
			case four :
				System.out.println(yes.size());
				break;
			case five :
				if (yes.isEmpty()) {
					System.out.println("Yes it's empty");
					break;
				}
				System.out.println("No");
				break;
			default :
				System.out.println(
						"ERROR! Enter a valid number.");
				break;
			}
		    }
		} while (k != six);
	}
}
