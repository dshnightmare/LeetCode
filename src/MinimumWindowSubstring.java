public class MinimumWindowSubstring {
	public String minWindow(String S, String T) {
		int[] needToFind = new int[256];
		int[] hasFound = new int[256];
		int minBegin = 0, minEnd = 0, count = 0, minLen = S.length() + 1;
		for (char c : T.toCharArray()) {
			needToFind[c]++;
		}
		for(int begin = 0, end = 0; end < S.length(); end++){
			char c = S.charAt(end);
			if(needToFind[c] == 0)
				continue;
			hasFound[c]++;
			if(hasFound[c] <= needToFind[c])
				count++;
			if(count == T.length()){
				while( needToFind[S.charAt(begin)] == 0 ||
						hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)]){
					if(hasFound[S.charAt(begin)] > needToFind[S.charAt(begin)])
						hasFound[S.charAt(begin)]--;
					begin++;
				}
				
				int len = end - begin + 1;
				if(len < minLen){
					minLen = len;
					minBegin = begin;
					minEnd = end;
				}
			}
		}
		System.out.println(minLen);
		if(count == T.length())
			return S.substring(minBegin, minEnd + 1);
		else
			return "";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new MinimumWindowSubstring().minWindow("aa", "aa"));

	}

}
