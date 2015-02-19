import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Anagrams {
	public List<String> anagrams(String[] strs) {
		HashMap<String, Integer> map = new HashMap<>();
		ArrayList<String> result = new ArrayList<>();
		char[] cur;
		String s;
		
		for(int i = 0; i < strs.length; i++) {
			cur = strs[i].toCharArray();
			Arrays.sort(cur);
			s = String.valueOf(cur);
			if(map.containsKey(s)){
				if(map.get(s) >= 0){
					result.add(strs[map.get(s)]);
					map.put(s, -1);
				}
				result.add(strs[i]);
			}
			else{
				map.put(s, i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		
	}
}