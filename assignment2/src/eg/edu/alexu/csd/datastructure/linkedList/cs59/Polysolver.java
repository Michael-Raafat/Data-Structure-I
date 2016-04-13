package eg.edu.alexu.csd.datastructure.linkedList.cs59;

import java.util.ArrayList;

import eg.edu.alexu.csd.datastructure.linkedList.IPolynomialSolver;
/**
 *
 * @author Amr
 *
 */
public class Polysolver implements IPolynomialSolver {
	/**
	 * List 1 that contains the first equation.
	 */
	private singleList aA = new singleList();
	/**
	 * List 1 that contains the first equation.
	 */
	private singleList bB = new singleList();
	/**
	 * List 1 that contains the first equation.
	 */
	private singleList cC = new singleList();
	/**
	 * List 1 that contains the first equation.
	 */
	private singleList rR = new singleList();
	/**
	 *
	 * @param r
	 * List entered to be set.
	 * @param terms
	 * array that represents the equation coeffecients and degrees
	 */
	public final void setR(final singleList r, final int[][] terms) {
		r.clear();
		boolean error = false;
		for (int i = 0; i < terms.length && !error; i++) {
			if (terms[i][1] < 0) {
				error = true;
			}
			if (i != terms.length - 1
					&& terms[i][1] < terms[i + 1][1]) {
				error = true;
			}
			r.add(terms[i][0]);
			r.add(terms[i][1]);
		}
		if (error) {
			r.clear();
			throw new RuntimeException();
		}
	}

	@Override
	public final void setPolynomial(final char poly, final int[][] terms) {
		// TODO Auto-generated method stub
		if (poly == 'A') {
			aA.clear();
			boolean error = false;
			for (int i = 0; i < terms.length && !error; i++) {
				if (terms[i][1] < 0) {
					error = true;
				}
				if (i != terms.length - 1
						&& terms[i][1]
							< terms[i + 1][1]) {
					error = true;
				}
				aA.add(terms[i][0]);
				aA.add(terms[i][1]);
			}
			if (error) {
				aA.clear();
				throw new RuntimeException("A cleared yo!");
			}
		} else if (poly == 'B') {
			bB.clear();
			boolean error = false;
			for (int i = 0; i < terms.length && !error; i++) {
				if (terms[i][1] < 0) {
					error = true;
				}
				if (i != terms.length - 1
						&& terms[i][1]
							< terms[i + 1][1]) {
					error = true;
				}
				bB.add(terms[i][0]);
				bB.add(terms[i][1]);
			}
			if (error) {
				bB.clear();
				throw new RuntimeException("B cleared yo!");
			}
		} else if (poly == 'C') {
			cC.clear();
			boolean error = false;
			for (int i = 0; i < terms.length && !error; i++) {
				if (terms[i][1] < 0) {
					error = true;
				}
				if (i != terms.length - 1
						&& terms[i][1]
							< terms[i + 1][1]) {
					error = true;
				}
				cC.add(terms[i][0]);
				cC.add(terms[i][1]);
			}
			if (error) {
				cC.clear();
				throw new RuntimeException("C cleared too");
			}
		} else {
			throw new RuntimeException("Invalid poly set try");
		}
	}
	/**
	 *
	 * @param a
	 * single List chosen to be printed.
	 * @return
	 * A string that represents the equation
	 */
	public final String printL(final singleList a) {
		String equation = "";
		for (int i = 0; i < a.size() - 2; i += 2) {
			equation += String.valueOf(a.get(i))
					+ "x^"
					+ String.valueOf(a.get(i + 1)) + "+";
		}
		if (a.isEmpty()) {
			return equation;
		} else {
			if (a.get(a.size() - 1).equals(0)) {
				equation += String.valueOf(a.get(a.size() - 2));
			} else {
				equation += String.valueOf(a.get(a.size() - 2))
						+ "x^"
						+ String.valueOf(a.get(
								a.size() - 1));
			}
			return equation;
		}
	}

	@Override
	public final String print(final char poly) {
		// TODO Auto-generated method stub
		if (poly == 'A') {
			if (aA.isEmpty()) {
				return null;
			}
			return printL(aA);
		} else if (poly == 'B') {
			if (bB.isEmpty()) {
				return null;
			}
			return printL(bB);
		} else if (poly == 'C') {
			if (cC.isEmpty()) {
				return null;
			}
			return printL(cC);
		} else if (poly == 'R') {
			if (rR.isEmpty()) {
				return null;
			}
			return printL(rR);
		} else {
			throw new RuntimeException("invalid printer call");
		}
	}

	@Override
	public final void clearPolynomial(final char poly) {
		// TODO Auto-generated method stub
		if (poly == 'A') {
			aA.clear();
		} else if (poly == 'B') {
			bB.clear();
		} else if (poly == 'C') {
			cC.clear();
		} else if (poly == 'R') {
			rR.clear();
		}
	}
	/**
	 *
	 * @param x
	 * base.
	 * @param p
	 * power
	 * @return
	 * the base^power
	 */
	public final float power(final float x, final int p) {
		float r = 1;
		for (int i = 0; i < p; i++) {
			r *= x;
		}
		return r;
	}
	/**
	 *
	 * @param a
	 * single List.
	 * @param gogo
	 * the number we want to calculate the equation from
	 * @return
	 * the result
	 */
	public final float eva(final singleList a, final float gogo) {
		int equation = 0;
		for (int i = 0; i < a.size(); i += 2) {
			equation += Integer.valueOf(String.valueOf(a.get(i)))
					*
					power(gogo,
							Integer.valueOf(
								String.valueOf(
								a.get(i + 1))));
		}
		if (a.isEmpty()) {
			throw new RuntimeException();
		} else {
			return equation;
		}
	}

	@Override
	public final float evaluatePolynomial(
			final char poly, final float value) {
		// TODO Auto-generated method stub

		if (poly == 'A') {
			if (aA.isEmpty()) {
				throw new RuntimeException();
			}
			return eva(aA, value);
		} else if (poly == 'B') {
			if (bB.isEmpty()) {
				throw new RuntimeException();
			}
			return eva(bB, value);
		} else if (poly == 'C') {
			if (cC.isEmpty()) {
				throw new RuntimeException();
			}
			return eva(cC, value);
		} else if (poly == 'R') {
			if (rR.isEmpty()) {
				throw new RuntimeException();
			}
			return eva(rR, value);
		} else {
			throw new RuntimeException();
		}
	}
	/**
	 *
	 * @param x
	 * first list represnting equation.
	 * @param y
	 * second list
	 * @return
	 * A list containing the result of addition.
	 */
	public final singleList addto(final singleList x, final singleList y) {

		ArrayList<Integer> smallA = new ArrayList<Integer>();

		int j = 0, i = 0;
		while (i < x.size() && j < y.size()) {
			int first = Integer.valueOf(
					String.valueOf(x.get(i + 1)));
			int firstc = Integer.valueOf(
					String.valueOf(x.get(i)));
			int second = Integer.valueOf(
					String.valueOf(y.get(j + 1)));
			int secondc = Integer.valueOf(String.valueOf(y.get(j)));
			if (first > second) {
				smallA.add(firstc);
				smallA.add(first);

				i += 2;
			} else if (second > first) {
				smallA.add(secondc);
				smallA.add(second);
				j += 2;
			} else {
				if (secondc + firstc == 0) {
					i += 2;
					j += 2;
				} else {
					smallA.add(secondc + firstc);
					smallA.add(first);
					i += 2;
					j += 2;
				}
			}

		}
		if (j == y.size()) {
			for (int k = i; k < x.size(); k += 2) {
				int first = Integer.valueOf(
						String.valueOf(x.get(k + 1)));
				int firstc = Integer.valueOf(
						String.valueOf(x.get(k)));
				smallA.add(firstc);
				smallA.add(first);

			}
		} else if (i == x.size()) {
			for (int k = j; k < y.size(); k += 2) {
				int second = Integer.valueOf(
						String.valueOf(y.get(k + 1)));
				int secondc = Integer.valueOf(
						String.valueOf(y.get(k)));
				smallA.add(secondc);
				smallA.add(second);
			}
		}
		int[][] ab = new int[smallA.size() / 2][2];
		int l = 0;
		for (int p = 0; p < smallA.size() / 2; p++) {
			ab[p][0] = smallA.get(l);
			ab[p][1] = smallA.get(l + 1);
			l += 2;
		}
		singleList print = new singleList();
		for (int u = 0; u < ab.length; u++) {

			print.add(ab[u][0]);
			print.add(ab[u][1]);
		}
		return print;

	}
	/**
	 *
	 * @param x
	 * First list representing Poly.
	 * @param y
	 * Second List.
	 * @return
	 * a matrix containing the result.
	 */
	public final int[][] addlist(final singleList x, final singleList y) {
		ArrayList<Integer> smallA = new ArrayList<Integer>();

		int j = 0, i = 0;
		while (i < x.size() && j < y.size()) {
			int first = Integer.valueOf(
					String.valueOf(x.get(i + 1)));
			int firstc = Integer.valueOf(String.valueOf(x.get(i)));
			int second = Integer.valueOf(
					String.valueOf(y.get(j + 1)));
			int secondc = Integer.valueOf(String.valueOf(y.get(j)));
			if (first > second) {
				smallA.add(firstc);
				smallA.add(first);

				i += 2;
			} else if (second > first) {
				smallA.add(secondc);
				smallA.add(second);
				j += 2;
			} else {
				if (secondc + firstc == 0) {
					i += 2;
					j += 2;
				} else {
					smallA.add(secondc + firstc);
					smallA.add(first);
					i += 2;
					j += 2;
				}
			}

		}
		if (j == y.size()) {
			for (int k = i; k < x.size(); k += 2) {
				int first = Integer.valueOf(
						String.valueOf(x.get(k + 1)));
				int firstc = Integer.valueOf(
						String.valueOf(x.get(k)));
				smallA.add(firstc);
				smallA.add(first);

			}
		} else if (i == x.size()) {
			for (int k = j; k < y.size(); k += 2) {
				int second = Integer.valueOf(
						String.valueOf(y.get(k + 1)));
				int secondc = Integer.valueOf(
						String.valueOf(y.get(k)));
				smallA.add(secondc);
				smallA.add(second);
			}
		}
		int[][] ab = new int[smallA.size() / 2][2];
		int l = 0;
		singleList temp = new singleList();
		for (int p = 0; p < smallA.size() / 2; p++) {
			ab[p][0] = smallA.get(l);
			ab[p][1] = smallA.get(l + 1);
			temp.add(ab[p][0]);
			temp.add(ab[p][1]);
			l += 2;
		}
		accumulate(temp);
		return ab;
	}

	@Override
	public final int[][] add(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		if ((poly1 != 'A' && poly1 != 'B' && poly1 != 'C')
				|| (poly2 != 'A'
				&& poly2 != 'B'
				&& poly2 != 'C')) {
			throw new RuntimeException();
		}
		if (poly1 == 'A' || poly2 == 'A') {
			if (poly1 == 'B' || poly2 == 'B') {
				if (!aA.isEmpty() && !bB.isEmpty()) {
					return addlist(aA, bB);
				} else {
					throw new RuntimeException();
				}
			} else if (poly1 == 'A' && poly2 == 'A') {
				if (!aA.isEmpty()) {
					return addlist(aA, aA);
				} else {
					throw new RuntimeException();
				}
			} else {
				if (!aA.isEmpty() && !cC.isEmpty()) {
					return addlist(aA, cC);
				} else {
					throw new RuntimeException();
				}
			}
		} else if (poly1 == 'B' || poly2 == 'B') {
			if (poly1 == 'B' && poly2 == 'B') {
				if (!bB.isEmpty()) {
					return addlist(bB, bB);
				} else {
					throw new RuntimeException();
				}
			}

			if (!cC.isEmpty() && !bB.isEmpty()) {
				return addlist(bB, cC);
			} else {
				throw new RuntimeException();
			}
		} else if (poly1 == 'C' && poly2 == 'C') {
			if (!cC.isEmpty()) {
				return addlist(cC, cC);
			} else {
				throw new RuntimeException();
			}
		} else {
			throw new RuntimeException();
		}

	}
	/**
	 *
	 * @param x
	 * first list of a poly.
	 * @param y
	 * second list.
	 * @return
	 * matrix containing subtraction result.
	 */
	public final int[][] subtlist(final singleList x, final singleList y) {
		singleList temp = new singleList();

		int j = 0, i = 0;
		while (i < x.size() && j < y.size()) {
			int first = Integer.valueOf(
					String.valueOf(x.get(i + 1)));
			int firstc = Integer.valueOf(String.valueOf(x.get(i)));
			int second = Integer.valueOf(
					String.valueOf(y.get(j + 1)));
			int secondc = Integer.valueOf(String.valueOf(y.get(j)));
			if (first > second) {
				temp.add(firstc);
				temp.add(first);
				i += 2;
			} else if (second > first) {
				temp.add(-secondc);
				temp.add(second);
				j += 2;
			} else {
				if (firstc - secondc == 0) {
					i += 2;
					j += 2;
				} else {
					temp.add(-secondc + firstc);
					temp.add(first);
					i += 2;
					j += 2;
				}
			}

		}
		if (j == y.size()) {
			for (int k = i; k < x.size(); k += 2) {
				int first = Integer.valueOf(
						String.valueOf(x.get(k + 1)));
				int firstc = Integer.valueOf(
						String.valueOf(x.get(k)));
				temp.add(firstc);
				temp.add(first);

			}
		}
		if (i == x.size()) {
			for (int k = j; k < y.size(); k += 2) {
				int second = Integer.valueOf(
						String.valueOf(y.get(k + 1)));
				int secondc = Integer.valueOf(
						String.valueOf(y.get(k)));
				temp.add(-secondc);
				temp.add(second);
			}
		}
		int[][] ab = new int[temp.size() / 2][2];
		int l = 0;
		for (int p = 0; p < temp.size() / 2; p++) {
			ab[p][0] = Integer.valueOf(String.valueOf(temp.get(l)));
			ab[p][1] = Integer.valueOf(
					String.valueOf(temp.get(l + 1)));
			l += 2;
		}
		accumulate(temp);
		return ab;
	}

	@Override
	public final int[][] subtract(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		int[][] tal5ees = new int[1][2];
		tal5ees[0][1] = 0;
		tal5ees[0][0] = 0;
		if (poly1 == 'A') {
			if (poly2 == 'A') {
				if (!aA.isEmpty()) {
					setR(rR, tal5ees);
					return tal5ees;
				} else {
					throw new RuntimeException();
				}
			}
			if (poly2 == 'B') {
				if (!aA.isEmpty() && !bB.isEmpty()) {
					return subtlist(aA, bB);
				} else {
					throw new RuntimeException();
				}
			} else if (poly2 == 'C') {
				if (!aA.isEmpty() && !cC.isEmpty()) {
					return subtlist(aA, cC);
				} else {
					throw new RuntimeException();
				}
			} else {
				throw new RuntimeException();
			}
		} else if (poly1 == 'B') {
			if (poly2 == 'B') {
				if (!bB.isEmpty()) {
					setR(rR, tal5ees);
					return tal5ees;
				} else {
					throw new RuntimeException();
				}
			}
			if (poly2 == 'A') {
				if (!aA.isEmpty() && !bB.isEmpty()) {
					return subtlist(bB, aA);
				} else {
					throw new RuntimeException();
				}
			} else if (poly2 == 'C') {
				if (!bB.isEmpty() && !cC.isEmpty()) {
					return subtlist(bB, cC);
				} else {
					throw new RuntimeException();
				}
			} else {
				throw new RuntimeException();
			}
		} else if (poly1 == 'C') {
			if (poly2 == 'C') {
				if (!cC.isEmpty()) {
					setR(rR, tal5ees);
					return tal5ees;
				} else {
					throw new RuntimeException();
				}
			}
			if (poly2 == 'A') {
				if (!aA.isEmpty() && !cC.isEmpty()) {
					return subtlist(cC, aA);
				} else {
					throw new RuntimeException();
				}
			} else if (poly2 == 'B') {
				if (!bB.isEmpty() && !cC.isEmpty()) {
					return subtlist(cC, bB);
				} else {
					throw new RuntimeException();
				}
			} else {
				throw new RuntimeException();
			}
		} else {
			throw new RuntimeException();
		}
	}
	/**
	 *
	 * @param x
	 * first list containing poly.
	 * @param y
	 * second one.
	 * @return
	 * Matrix containing multiplication result.
	 */
	public final int[][] multiL(final singleList x, final singleList y) {
		singleList m = new singleList();
		singleList n = new singleList();
		for (int i = 0; i < x.size(); i += 2) {
			m.clear();
			for (int j = 0; j < y.size(); j += 2) {
				int f = Integer.valueOf(
						String.valueOf(x.get(i + 1)));
				int l = Integer.valueOf(
						String.valueOf(y.get(j + 1)));
				int fc = Integer.valueOf(
						String.valueOf(x.get(i)));
				int lc = Integer.valueOf(
						String.valueOf(y.get(j)));
				int z = fc * lc;
				int cc = f + l;
				m.add(z);
				m.add(cc);

			}
			n = addto(n, m);
		}
		int[][] ab = new int[n.size() / 2][2];
		int l = 0;
		for (int p = 0; p < n.size() / 2; p++) {
			ab[p][0] = Integer.valueOf(String.valueOf(n.get(l)));
			ab[p][1] = Integer.valueOf(
					String.valueOf(n.get(l + 1)));
			l += 2;
		}
		accumulate(n);
		return ab;

	}

	@Override
	public final int[][] multiply(final char poly1, final char poly2) {
		// TODO Auto-generated method stub
		if (poly1 == 'A' || poly2 == 'A') {
			if (poly1 == 'B' || poly2 == 'B') {
				if (!aA.isEmpty() && !bB.isEmpty()) {
					return multiL(aA, bB);
				} else {
					throw new RuntimeException();
				}
			} else if (poly1 == 'A' && poly2 == 'A') {
				if (!aA.isEmpty()) {
					return multiL(aA, aA);
				} else {
					throw new RuntimeException();
				}
			} else {
				if (!aA.isEmpty() && !cC.isEmpty()) {
					return multiL(aA, cC);
				} else {
					throw new RuntimeException();
				}
			}
		} else if (poly1 == 'B' || poly2 == 'B') {
			if (poly1 == 'B' && poly2 == 'B') {
				if (!bB.isEmpty()) {
					return multiL(bB, bB);
				} else {
					throw new RuntimeException();
				}
			}

			if (!cC.isEmpty() && !bB.isEmpty()) {
				return multiL(bB, cC);
			} else {
				throw new RuntimeException();
			}
		} else if (poly1 == 'C' && poly2 == 'C') {
			if (!cC.isEmpty()) {
				return multiL(cC, cC);
			} else {
				throw new RuntimeException();
			}
		} else {
			throw new RuntimeException();
		}

	}
	/**
	 *
	 * @param a
	 * list to be copied to rR the accumulator.
	 */
	public final void accumulate(final singleList a) {
		int i;
		i = 0;
		int x;
		rR.clear();
		while (i < a.size()) {
			x = Integer.valueOf(String.valueOf(a.get(i)));
			rR.add(x);
			i++;
		}
	}
}
