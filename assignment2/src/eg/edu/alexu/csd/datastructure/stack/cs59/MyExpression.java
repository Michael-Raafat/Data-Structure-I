package eg.edu.alexu.csd.datastructure.stack.cs59;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
/**
 *
 * @author Michael.
 *
 */
public class MyExpression implements IExpressionEvaluator {
    /**
     * magic.
     */
	private final int magic10 = 10;
	/**
     * integer.
     */
	int p = 0;
    /**
     * stacks.
     */
	MyStack s = new MyStack();
	/**
	 * array of characters.
	 */
	char[] arr = {'(', ')', '-', '+', '*', '/'};
	@Override
	public String infixToPostfix(final String expression) {
		// TODO Auto-generated method stub
		StringBuilder zew = new StringBuilder();
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '/'
					|| expression.charAt(i) == '*'
					|| expression.charAt(i) == '+'
					|| expression.charAt(i) == '-'
					|| expression.charAt(i) == ')'
					|| expression.charAt(i) == '(') {
				if (!s.isEmpty() && expression.charAt(i) == '(') {
					p++;
					s.push("(");
				} else if (!s.isEmpty() && expression.charAt(i) == ')') {
					p--;
					while (!s.isEmpty() && !String.valueOf(s.peek()).equals("(")) {
						zew.append(s.pop());
					    zew.append(" ");
					}
					s.pop();
				} else if (expression.charAt(i) == '/') {
				  if (!s.isEmpty() && String.valueOf(s.peek()).equals("*")) {
					  zew.append(s.pop());
					  zew.append(" ");
					  s.push("/");
				  } else {
					  s.push("/");
				  }
				} else if (expression.charAt(i) == '*') {
					if (!s.isEmpty() && (String.valueOf(s.peek()).equals("/"))) {
						  zew.append(s.pop());
						  s.push("*");
						  zew.append(" ");
					  } else {
						  s.push("*");
					  }
					} else if (
						expression.charAt(i) == '+') {
						if (!s.isEmpty() && (String.valueOf(s.peek()).equals("*")
								|| String.valueOf(s.peek()).equals("/"))) {
							  zew.append(s.pop());
							  s.push("+");
							  zew.append(" ");
						  } else {
							  s.push("+");
						  }
					} else if (
							expression.charAt(i) == '-') {
						if (!s.isEmpty() && (String.valueOf(s.peek()).equals("*")
								|| String.valueOf(s.peek()).equals("/"))) {
							  zew.append(s.pop());
							  s.push("-");
							  zew.append(" ");
						  } else {
							  s.push("-");
						  }
					}
			} else {
				if (expression.charAt(i) != ' ') {
	 				zew.append(String.valueOf(
	 						expression.charAt(i)));
	 				zew.append(" ");
	 				}
			}
		}
		while (s.size() > 0) {
			if(!String.valueOf(s.peek()).equals("(")
					|| !String.valueOf(s.peek()).equals(")")) {
			zew.append(s.pop());
			if (s.size() > 0 || (s.size() == 1
					&& String.valueOf(s.peek()).equals("(" ))) {
			   zew.append(" ");
			}
			} else {
				s.pop();
			}
		}
		return zew.toString();
	}

	@Override
	public int evaluate(final String expression) {
		// TODO Auto-generated method stub
		if (expression.length() == 0) {
			throw new RuntimeException();
		}
		for (int i = 0; i < expression.length(); i++) {
			if (expression.charAt(i) == '/'
					|| expression.charAt(i) == '*'
					|| expression.charAt(i) == '+'
					|| expression.charAt(i) == '-') {
				if (expression.charAt(i) == '/') {
				Object f = s.pop();
				Object v = s.pop();
				float k = (Float.valueOf(
						String.valueOf(v))
						/ (Float.valueOf(
						 String.valueOf(f))));
				s.push(k);
				} else if (expression.charAt(i) == '*') {
					Object f = s.pop();
					Object v = s.pop();
					float k = (Float.valueOf(
							String.valueOf(v))
							* (Float.valueOf(
							 String.valueOf(f))));
					s.push(k);
					} else if (
						expression.charAt(i) == '+') {
					Object f = s.pop();
					Object v = s.pop();
					float k = (Float.valueOf(
							String.valueOf(v))
							+ (Float.valueOf(
							 String.valueOf(f))));
					s.push(k);
					} else if (
					expression.charAt(i) == '-') {
					Object f = s.pop();
					Object v = s.pop();
					float k = (Float.valueOf(
							String.valueOf(v))
							- (Float.valueOf(
							 String.valueOf(f))));
					s.push(k);
					}
			} else {
				if (expression.charAt(i) != ' ') {
					int r = 0;
					r += Integer.valueOf(
						String.valueOf(
						expression.charAt(i)));
					while (
					expression.charAt(i + 1) != ' ') {
						i++;
						r *= magic10;
						r += Integer.valueOf(
							String.valueOf(
							expression.charAt(i)));
					}
				s.push(r);
				}
			}
		}
		float h = Float.parseFloat((String.valueOf(s.pop())));
		if (s.size() != 0) {
			throw new RuntimeException();
		}
		return (int) h;
	}

}
