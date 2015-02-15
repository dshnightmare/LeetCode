import java.util.Stack;

public class EvaluateReversePolishNotation {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();
		for(String token : tokens) {
			int ele1, ele2;
			if(token.equals("+")){
				ele1 = stack.pop();
				ele2 = stack.pop();
				stack.push(ele2 + ele1);
			}
			else if(token.equals("-")){
				ele1 = stack.pop();
				ele2 = stack.pop();
				stack.push(ele2 - ele1);
			}
			else if(token.equals("*")){
				ele1 = stack.pop();
				ele2 = stack.pop();
				stack.push(ele2 * ele1);
			}
			else if(token.equals("/")){
				ele1 = stack.pop();
				ele2 = stack.pop();
				stack.push(ele2 / ele1);
			}
			else
				stack.push(Integer.parseInt(token));
		}
		return stack.pop();
	}
	
	public static void main(String[] args) {
		String[] tokens = {"2", "1", "+", "3", "*"};
		System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
	}
}