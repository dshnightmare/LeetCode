import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		HashSet<String> map = new HashSet<>();
		int[] status = new int[s.length() + 1];
		status[s.length()] = 1;
		int maxL = Integer.MIN_VALUE, minL = Integer.MAX_VALUE;
		for(String word : dict){
			if(word.length() > maxL)
				maxL = word.length();
			if(word.length() < minL)
				minL = word.length();
			map.add(word);
		}
		for(int i = s.length() - 1; i >= 0; i--){
			for(int j = i + minL; j <= s.length() && j - i <= maxL; j++){
				if(status[j] == 1 && map.contains(s.substring(i, j))){
					status[i] = 1;
					break;
				}
			}
		}
		return status[0] == 1;
	}
	
	public static void main(String[] args) {
		Set<String> dict = new HashSet<>();
		dict.add("leet");
		dict.add("code");
		System.out.println(new WordBreak().wordBreak("leetcode", dict));
	}
}