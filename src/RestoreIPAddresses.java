import java.util.List;
import java.util.ArrayList;

public class RestoreIPAddresses {
	private List<String> result;
	public List<String> restoreIpAddresses(String s) {
		result = new ArrayList<>();
		ArrayList<Integer> cur = new ArrayList<>();
		findIP(s, 0, cur);
		return result;
	}
	
	private void findIP(String s, int begin, ArrayList<Integer> cur) {
		int length = s.length();
		if(cur.size() == 4){
			if(begin == length){
				result.add(cur.get(0) + "." + cur.get(1) + "." + cur.get(2) + "."
					+ cur.get(3));
			}
			return;
		}
		if(begin < length && s.charAt(begin) == '0'){
			cur.add(0);
			findIP(s, begin + 1, cur);
			cur.remove(cur.size() - 1);
		}
		else{
			for(int i = 1; i < 4 && begin + i <= length; i++){
				int tt = Integer.parseInt(s.substring(begin, begin + i));
				if(tt <= 255){
					cur.add(tt);
					findIP(s, begin + i, cur);
					cur.remove(cur.size() - 1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new RestoreIPAddresses().restoreIpAddresses("010010");
	}
}