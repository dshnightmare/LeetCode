import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		HashMap<Integer, Boolean> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		int length = s.length();
		for(int i = 0; i <= length - 10; i++){
			int cur = StringToInteger(s.substring(i, i + 10));
			if(map.containsKey(cur))
				map.put(cur, true);
			else
				map.put(cur, false);
		}
		for(Integer key : map.keySet()){
			if(map.get(key)){
				result.add(IntegerToString(key));
			}
		}
		return result;
	}
	
	// 00 -> A
	// 01 -> C
	// 10 -> G
	// 11 -> T
	private String IntegerToString(int i){
		StringBuilder result = new StringBuilder();
		i = i >> 2;
		for(int j = 0; j < 10; j++){
			int cur = i & 3;
			switch(cur){
				case 0: result.append('A'); break;
				case 1: result.append('C'); break;
				case 2: result.append('G'); break;
				case 3: result.append('T'); break;
				default:break;
			}
			i = i >> 2;
		}
		result.reverse();
		return result.toString();
	}
	
	private int StringToInteger(String s){
		int result = 0;
		for(char c : s.toCharArray()){
			int cur = 0;
			switch(c){
				case 'A': cur = 0;break;
				case 'C': cur = 1;break;
				case 'G': cur = 2;break;
				case 'T': cur = 3;break;
				default:break;
			}
			result |= cur;
			result = result << 2;
		}
		return result;
	}
	
	public static void main(String[] args) {
		new RepeatedDNASequences().findRepeatedDnaSequences("GAGAGAGAGAGA");
	}
}