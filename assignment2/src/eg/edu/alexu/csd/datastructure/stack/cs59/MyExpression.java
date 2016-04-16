package eg.edu.alexu.csd.datastructure.stack.cs59;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
/**
 *
 * @author Michael.
 *
 */
public class MyExpression implements IExpressionEvaluator {
    int k = 0;
	MyStack s = new MyStack();
	char [] arr = {'(', ')', '-', '+', '*', '/'};
	@Override
	public String infixToPostfix(String expression) {
		// TODO Auto-generated method stub
		StringBuilder zew = new StringBuilder(); 
		for (int i = 0; i < expression.length(); i++) {
			if (arr.toString().indexOf(expression.charAt(i)) >= 0) {
				switch (expression.charAt(i)) {
					case '(' :
						s.push('(');
						k++;
						break;
					case ')' :
					    if (k == 0) {
					    	throw new RuntimeException();
					    }
					    k--;
						while(String.valueOf(s.peek()) != "(" ) {
							zew.append(s.pop());
						}
						break;
					case '*' :
						if (s.peek().equals('+')
								|| s.peek().equals('-')
								|| s.peek().equals('/')) {
							
						}
							
						s.push('*');
						break;
					case '/' :
						s.push('/');
						break;
					case '-' :
						s.push('-');
						break;
					case '+' :
						s.push('+');
						break;	
				
			}
				return null ;
		}
		}
		return null;
	}

	@Override
	public int evaluate(String expression) {
		// TODO Auto-generated method stub
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
						 String.valueOf(f)))) ;
				s.push(k);
				} else if (expression.charAt(i) == '*') {
					Object f = s.pop();	
					Object v = s.pop();
					float k = (Float.valueOf(
							String.valueOf(v))
							* (Float.valueOf(
							 String.valueOf(f)))) ;
					s.push(k);
					}else if (expression.charAt(i) == '+') {
					Object f = s.pop();	
					Object v = s.pop();
					float k = (Float.valueOf(
							String.valueOf(v))
							+ (Float.valueOf(
							 String.valueOf(f)))) ;
					s.push(k);
					} else if (expression.charAt(i) == '-') {
					Object f = s.pop();	
					Object v = s.pop();
					float k = (Float.valueOf(
							String.valueOf(v))
							- (Float.valueOf(
							 String.valueOf(f)))) ;
					s.push(k);
					}
			} else {
				if (expression.charAt(i) != ' ') {
					int r = 0;
					r += Integer.valueOf(
							String.valueOf(expression.charAt(i)));
					while(expression.charAt(i + 1) != ' ') {
						i++;
						r *= 10;
						r += Integer.valueOf(
								String.valueOf(expression.charAt(i)));
						
					}
				s.push(r);
				}
			}
			
		}
		
		float h = Float.parseFloat((String.valueOf(s.pop())));
		return (int)h;
	}

}
