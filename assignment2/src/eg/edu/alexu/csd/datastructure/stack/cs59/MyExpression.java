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
 		if (expression.isEmpty()) {
 			throw new RuntimeException();
 		}
 		for (int i = 0; i < expression.length(); i++) {
 			if (expression.charAt(i) == '/'
 					|| expression.charAt(i) == '*'
 					|| expression.charAt(i) == '+'
 					|| expression.charAt(i) == '-'
 					|| expression.charAt(i) == ')'
 					|| expression.charAt(i) == '(') {
 				if (expression.charAt(i) == '(') {
 					p++;
 					s.push("(");
 				}  else if (expression.charAt(i) == ')') {
 					p--;
				 if (!s.isEmpty() && String.valueOf(s.peek()).equals("(")) {
					    	s.pop();
					    } else {
					    	zew.append(String.valueOf(s.pop()));
					    	zew.append(' ');
					    	s.pop();
 					}
 					
 				} else if (expression.charAt(i) == '/') {
 					if (!s.isEmpty() && (String.valueOf(s.peek()).equals("/")
 							|| String.valueOf(s.peek()).equals("*"))) {
 						zew.append(String.valueOf(s.pop()));
 					  zew.append(" ");
 					  s.push("/");
 				  } else {
 					  s.push("/");
 				  }
 				} else if (expression.charAt(i) == '*') {
 					if (!s.isEmpty() && (String.valueOf(s.peek()).equals("/")
 							|| String.valueOf(s.peek()).equals("*"))) {
 						zew.append(String.valueOf(s.pop()));
 						  s.push("*");
 						  zew.append(" ");
 					  } else {
 						  s.push("*");
 					  }
 					} else if (
 						expression.charAt(i) == '+') {
 						if (!s.isEmpty() && (String.valueOf(s.peek()).equals("*")
 								|| String.valueOf(s.peek()).equals("/")
 								|| String.valueOf(s.peek()).equals("-")
 								|| String.valueOf(s.peek()).equals("+"))) { 
 							zew.append(String.valueOf(s.pop()));
 							zew.append(" ");
 							while(!s.isEmpty() && (String.valueOf(s.peek()).equals("*")
 								|| String.valueOf(s.peek()).equals("/")
 								|| String.valueOf(s.peek()).equals("-")
 								|| String.valueOf(s.peek()).equals("+"))) {
 								zew.append(String.valueOf(s.pop()));
 								zew.append(" ");
 							}
 							  s.push("+");
 							  
 						  } else {
 							  s.push("+");
 						  }
 					} else if (
 							expression.charAt(i) == '-') {
 						if (!s.isEmpty() && (String.valueOf(s.peek()).equals("*")
 								|| String.valueOf(s.peek()).equals("/")
 								|| String.valueOf(s.peek()).equals("-")
 								|| String.valueOf(s.peek()).equals("+"))) { 
 							zew.append(String.valueOf(s.pop()));
 							zew.append(" ");
 							while(!s.isEmpty() && (String.valueOf(s.peek()).equals("*")
 								|| String.valueOf(s.peek()).equals("/")
 								|| String.valueOf(s.peek()).equals("-")
 								|| String.valueOf(s.peek()).equals("+"))) {
 								zew.append(String.valueOf(s.pop()));
 								zew.append(" ");
 							}
 							  s.push("-");
 							  
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
 		if (p != 0) {
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
 		int val = 0;
 		if (expression.isEmpty()) {
 			throw new RuntimeException();
 		}
 		Object v , f;
 		for (int i = 0; i < expression.length(); i++) {
 			if (expression.charAt(i) == '/'
 					|| expression.charAt(i) == '*'
 					|| expression.charAt(i) == '+'
 					|| expression.charAt(i) == '-') {
 				if (expression.charAt(i) == '/') {
 					if ( i+2 < expression.length() && (
 							expression.charAt(i+2) == '/'
 		 					|| expression.charAt(i+2) == '*'
 		 					|| expression.charAt(i+2) == '+'
 		 					|| expression.charAt(i+2) == '-')) {
 						throw new RuntimeException();
 					}
 					if(!s.isEmpty()) {
	 						f = s.pop();
						    } else {
 						    	throw new RuntimeException();
 						    }
						   if(!s.isEmpty()) {
	 	 						v = s.pop();
	 						    } else {
	 						    	throw new RuntimeException();
	 						    }
 				
 				float k = (Float.valueOf(
 						String.valueOf(v))
 						/ (Float.valueOf(
 						 String.valueOf(f))));
 				s.push(k);
 				val = 1;
 				} else if (expression.charAt(i) == '*') {
 					if ( i+2 < expression.length() && (
 							expression.charAt(i+2) == '/'
 		 					|| expression.charAt(i+2) == '*'
 		 					|| expression.charAt(i+2) == '+'
 		 					|| expression.charAt(i+2) == '-')) {
 						throw new RuntimeException();
 					}
 					if(!s.isEmpty()) {
	 						f = s.pop();
						    } else {
 						    	throw new RuntimeException();
 						    }
						   if(!s.isEmpty()) {
	 	 						v = s.pop();
	 						    } else {
	 						    	throw new RuntimeException();
	 						    }
 					float k = (Float.valueOf(
 							String.valueOf(v))
 							* (Float.valueOf(
 							 String.valueOf(f))));
 					s.push(k);
 					val = 1;
 					} else if (
 						expression.charAt(i) == '+') {
 						if ( i+2 < expression.length() && (
 	 							expression.charAt(i+2) == '/'
 	 		 					|| expression.charAt(i+2) == '*'
 	 		 					|| expression.charAt(i+2) == '+'
 	 		 					|| expression.charAt(i+2) == '-')) {
 	 						throw new RuntimeException();
 	 					}    
 						if(!s.isEmpty()) {
 	 						f = s.pop();
 						    } else {
	 						    	throw new RuntimeException();
	 						    }
 						   if(!s.isEmpty()) {
 	 	 						v = s.pop();
 	 						    } else {
 	 						    	throw new RuntimeException();
 	 						    }
 	 					
 					float k = (Float.valueOf(
 							String.valueOf(v))
 							+ (Float.valueOf(
 							 String.valueOf(f))));
 					s.push(k);
 					val = 1;
 					} else if (
 					expression.charAt(i) == '-') {
 						if ( i+2 < expression.length() && (
 	 							expression.charAt(i+2) == '/'
 	 		 					|| expression.charAt(i+2) == '*'
 	 		 					|| expression.charAt(i+2) == '+'
 	 		 					|| expression.charAt(i+2) == '-')) {
 	 						throw new RuntimeException();
 	 					}
 						if(!s.isEmpty()) {
 	 						f = s.pop();
 						    } else {
	 						    	throw new RuntimeException();
	 						    }
 						   if(!s.isEmpty()) {
 	 	 						v = s.pop();
 	 						    } else {
 	 						    	throw new RuntimeException();
 	 						    }
 					float k = (Float.valueOf(
 							String.valueOf(v))
 							- (Float.valueOf(
 							 String.valueOf(f))));
 					s.push(k);
 					val = 1;
 					}
 			} else {
 				if (expression.charAt(i) != ' ') {
 					int r = 0;
 					val = 1;
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
        if (s.size() == 0 || val == 0) {
 			throw new RuntimeException();
 		}
 		float h = Float.parseFloat((String.valueOf(s.pop())));
 		
 		return (int) h;
 	}
 
 }
