public class ReverseWordsInString {
	public String reverseWords(String s) {
		StringBuilder result = new StringBuilder(), cur = new StringBuilder();
		for(int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			if(c != ' ')
				cur.append(c);
			else if(cur.length() > 0) {
				result.append(cur.reverse().toString());
				result.append(' ');
				cur = new StringBuilder();
			}
		}
		if(cur.length() > 0) {
			result.append(cur.reverse().toString());
		}
		else if(result.length() - 1 > 0)
			result.deleteCharAt(result.length() - 1);
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new ReverseWordsInString().reverseWords("   the sky is blue   "));
	}
}