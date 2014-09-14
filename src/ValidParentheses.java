import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		char c[] = s.toCharArray();
		for(int i = 0; i < c.length; i++)
		{
			if(c[i] == '(' || c[i] == '{' || c[i] == '[')
				stack.push(c[i]);
			else if(c[i] == ')'){
				if(stack.isEmpty() || stack.peek() != '(')
					return false;
				else
					stack.pop();
			}
			else if(c[i] == '}'){
				if(stack.isEmpty() || stack.peek() != '{')
					return false;
				else
					stack.pop();
			}
			else if(c[i] == ']'){
				if(stack.isEmpty() || stack.peek() != '[')
					return false;
				else
					stack.pop();
			}
		}
		if(!stack.isEmpty())
			return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new ValidParentheses().isValid("((("));
	}

}
