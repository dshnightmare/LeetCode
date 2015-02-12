import java.util.Stack;

///o(n) solution use two stack
public class MinStack {
	Stack<Integer> data = new Stack<>();
	int min = Integer.MAX_VALUE;
	
	public void push(int x) {
		data.push(x);
		if(x < min)
			min = x;
	}
	
	public void pop() {
		int t = data.pop();
		if(t == min){
			min = Integer.MAX_VALUE;
			for(Integer i : data){
				if(i < min)
					min = i;
			}
		}
	}
	
	public int top() {
		return data.peek();
	}
	
	public int getMin() {
		return min;
	}
	
	public static void main(String[] args) {
		
	}
}