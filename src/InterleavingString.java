public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if(s3.length() != (s1.length() + s2.length()))
			return false;
		boolean[][] status = new boolean[s1.length() + 1][s2.length() + 1];
		status[0][0] = true;
		// without s2
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) == s3.charAt(i))
				status[i + 1][0] = true;
			else
				break;
		}
		// without s1
		for(int i = 0; i < s2.length(); i++){
			if(s2.charAt(i) == s3.charAt(i))
				status[0][i + 1] = true;
			else
				break;
		}
		for(int i = 0; i < s1.length(); i++){
			for(int j = 0; j < s2.length(); j++){
				if((s1.charAt(i) == s3.charAt(i + j + 1) && status[i][j + 1]) ||
				(s2.charAt(j) == s3.charAt(i + j + 1) && status[i + 1][j])){
					status[i + 1][j + 1] = true;
				}
				else
					status[i + 1][j + 1] = false;
			}
		}
		return status[s1.length()][s2.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(new InterleavingString().isInterleave("aabcc", "dbbca", "aadbbbaccc"));
	}
}