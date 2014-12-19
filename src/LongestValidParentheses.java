public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		int[] length = new int[s.length()];
		int max = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '(')
				length[i] = 0;
			else {
				int j = i - 1, num = 0;
				if(j >= 0 && length[j] != 0){
					num += length[j];
					j -= length[j];
				}
				if(j >= 0  && length[j] == 0 && s.charAt(j) == '('){
					num += 2;
					j--;
					if(j >= 0 && length[j] != 0){
						num += length[j];
						j -= length[j];
					}
					length[i] = num;
				}
				if(num > max){
					max = num;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new LongestValidParentheses().longestValidParentheses(")()())()()("));
	}

}
