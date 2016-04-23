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
 	int p = 0, d = 0;
     /**
      * stacks.
      */
 	MyStack s = new MyStack();
 	/**
 	 * array of characters.
 	 */
 	@Override
 	public String infixToPostfix(final String expression) {
 		// TODO Auto-generated method stub
 		StringBuilder zew = new StringBuilder();
 		if (expression.isEmpty()) {
 			throw new RuntimeException();
 		}
 		for (int i = 0; i < expression.length(); i++) {
 				if (expression.charAt(i) == '(') {
 					p++;
 					s.push("(");
 				}  else if (expression.charAt(i) == ')') {
 					if (d == 1) {
 	 					throw new RuntimeException();
 	 				}
 					p--;
				 if (!s.isEmpty() && String.valueOf(
						 s.peek()).equals("(")) {
					    	s.pop();
					    } else {
					    	zew.append(String.valueOf(
					    			s.pop()));
					    	zew.append(' ');
					    	s.pop();
 					}
 				} else if (expression.charAt(i) == '/') {
 					if (d == 1) {
 	 					throw new RuntimeException();
 	 				}
 	 				d = 1;
 					if (!s.isEmpty() && (String.valueOf(
 						s.peek()).equals("/")
 						|| String.valueOf(
 						s.peek()).equals("*"))) {
 						zew.append(
 						String.valueOf(s.pop()));
 					  zew.append(" ");
 					  s.push("/");
 				  } else {
 					  s.push("/");
 				  }
 				} else if (expression.charAt(i) == '*') {
 					if (d == 1) {
 	 					throw new RuntimeException();
 	 				}
 	 				d = 1;
 					if (!s.isEmpty() && (
 							String.valueOf(
 							s.peek()).equals("/")
 							|| String.valueOf(
 						   s.peek()).equals("*"))) {
 						zew.append(
 						String.valueOf(s.pop()));
 						  s.push("*");
 						  zew.append(" ");
 					  } else {
 						  s.push("*");
 					  }
 					} else if (
 						expression.charAt(i) == '+') {
 						if (d == 1) {
 		 			   throw new RuntimeException();
 		 				}
 		 				d = 1;
 							while (!s.isEmpty() && (
 							!String.valueOf(
 							s.peek()).equals("(")
 							)) {
 							zew.append(
 						   String.valueOf(s.pop()));
 							zew.append(" ");
 							}
 							  s.push("+");
 					} else if (
 					  expression.charAt(i) == '-') {
 						if (d == 1) {
 		 			   throw new RuntimeException();
 		 				}
 		 				d = 1;

 					 while (!s.isEmpty() && (
 					 !String.valueOf(
 					 s.peek()).equals("(")
 					 )) {
 					 zew.append(
 					  String.valueOf(s.pop()));
 								zew.append(" ");
 							}
 							  s.push("-");
 		} else {
 				if (expression.charAt(i) != ' ') {
 	 				zew.append(String.valueOf(
 	 						expression.charAt(i)));
 	 				zew.append(" ");
 	 				d = 0;
 	 				}
 			}
 		}
 		if (d == 1 || p != 0) {
 			throw new RuntimeException();
 		}
 		while (s.size() != 0) {
 			zew.append(String.valueOf(s.pop()));
 			if (s.size() != 0) {
 				zew.append(" ");
 			}
 		}
 		return zew.toString();
 	}
 	@Override
 	public int evaluate(final String expression) {
 		// TODO Auto-generated method stub
 		if (expression.isEmpty()) {
 			throw new RuntimeException();
 		}
 		Object v, f;
 		int k;
 		for (int i = 0; i < expression.length(); i++) {
 				if (expression.charAt(i) == '/') {
 					if (s.size() >= 2) {
 						f = s.pop();
 						v = s.pop();
 					} else {
 						throw new RuntimeException();
 					}
 				 k = (int) (Float.valueOf(
 						String.valueOf(v))
 						/ (Float.valueOf(
 						 String.valueOf(f))));
 				s.push(k);
 				} else if (expression.charAt(i) == '*') {
 					if (s.size() >= 2) {
 						f = s.pop();
 						v = s.pop();
 					} else {
 						throw new RuntimeException();
 					}
 				 k = (int) (Float.valueOf(
 							String.valueOf(v))
 							* (Float.valueOf(
 							 String.valueOf(f))));
 					s.push(k);
 					} else if (
 						expression.charAt(i) == '+') {
 						if (s.size() >= 2) {
 	 						f = s.pop();
 	 						v = s.pop();
 	 					} else {
 	 				   throw new RuntimeException();
 	 					}
 				 k = (int) (Float.valueOf(
 							String.valueOf(v))
 							+ (Float.valueOf(
 							 String.valueOf(f))));
 					s.push(k);
 					} else if (
 					expression.charAt(i) == '-') {
 						if (s.size() >= 2) {
 	 						f = s.pop();
 	 						v = s.pop();
 	 					} else {
 	 			   	   throw new RuntimeException();
 	 					}
 					 k = (int) (Float.valueOf(
 							String.valueOf(v))
 							- (Float.valueOf(
 							 String.valueOf(f))));
 					s.push(k);
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
        if (s.size() == 0) {
 			throw new RuntimeException();
 		}
 		float h = Float.parseFloat((String.valueOf(s.pop())));
 		if (!s.isEmpty()) {
 			return 0;
 		}
 		return (int) h;
 	}
 }
