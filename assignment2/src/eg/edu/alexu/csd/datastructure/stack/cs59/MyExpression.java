package eg.edu.alexu.csd.datastructure.stack.cs59;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
/**
 *
 * @author Michael.
 *
 */
public class MyExpression implements IExpressionEvaluator {

	MyStack s = new MyStack();
	@Override
	public String infixToPostfix(String expression) {
		// TODO Auto-generated method stub
		
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
				}
				if (expression.charAt(i) == '*') {
					Object f = s.pop();	
					Object v = s.pop();
					float k = (Float.valueOf(
							String.valueOf(v))
							* (Float.valueOf(
							 String.valueOf(f)))) ;
					s.push(k);
					}
				if (expression.charAt(i) == '+') {
					Object f = s.pop();	
					Object v = s.pop();
					float k = (Float.valueOf(
							String.valueOf(v))
							+ (Float.valueOf(
							 String.valueOf(f)))) ;
					s.push(k);
					}
				if (expression.charAt(i) == '-') {
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
				s.push(expression.charAt(i));
				}
			}
			
		}
		
		int h = Integer.valueOf(String.valueOf(s.pop()));
		return h;
	}

}
