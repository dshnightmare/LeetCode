import java.util.List;
import java.util.ArrayList;

public class PalindromePartitioning {
	private List<List<String>> result;
	
	public List<List<String>> partition(String s) {
		// use dp and backtracking
		boolean[][] status = dp(s);
		result = new ArrayList<>();
		ArrayList<String> cur = new ArrayList<>();
		dfs(s, 0, status, cur);
		return result;
	}
	
	private boolean[][] dp(String s){
		int length = s.length();
		boolean[][] status = new boolean[length][length];
		for(int i = 0; i < length; i++){
			for(int j = 0; j <= i; j++){
				if(i == j)
					status[j][i] = true;
				else{
					if(s.charAt(i) != s.charAt(j))
						continue;
					if(j == i - 1)
						status[j][i] = true;
					else
						status[j][i] = status[j + 1][i - 1];
				}
			}
		} 
		return status;
	}
	
	private void dfs(String s, int begin, boolean[][] status, ArrayList<String> cur) {
		int length = s.length();
		if(begin == length)
			result.add((ArrayList<String>)cur.clone());
		for(int i = begin; i < length; i++) {
			if(status[begin][i]){
				cur.add(s.substring(begin, i + 1));
				dfs(s, i + 1, status, cur);
				cur.remove(cur.size() - 1);
			}
		}
	}
	
	public static void main(String[] args) {
	}
}