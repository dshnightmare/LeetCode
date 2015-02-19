public class DistinctSubsequences {
	public int numDistinct(String S, String T) {
		if(T.length() > S.length())
			return 0;
		int[][] dp = new int[S.length() + 1][T.length() + 1];
		for(int i = 0; i < S.length(); i++)
			dp[i][0] = 1;
		for(int i = 0; i < S.length(); i++) {
			for(int j = 0; j < T.length(); j++) {
				if(S.charAt(i) == T.charAt(j))
					dp[i + 1][j + 1] = dp[i][j + 1] + dp[i][j];
				else
					dp[i + 1][j + 1] = dp[i][j + 1];
			}
		}
		return dp[S.length()][T.length()];
	}
	
	public static void main(String[] args) {
		System.out.println(new DistinctSubsequences().numDistinct("rabbbit", "rabbit"));
	}
}