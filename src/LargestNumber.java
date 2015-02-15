import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {
	public String largestNumber(int[] num) {
		StringBuilder result = new StringBuilder();
		String[] ss = new String[num.length];
		for(int i = 0; i < num.length; i++) {
			ss[i] = num[i] + "";
		}
		Arrays.sort(ss, new Comparator<String>() {
			public int compare(String s1, String s2){
				int gap = s1.length() - s2.length();
				if(gap == 0)
					return s1.compareTo(s2);
				else if(gap < 0){
					int val = s1.compareTo(s2.substring(0, s1.length()));
					if(val == 0)
						return compare(s1, s2.substring(s1.length()));
					else
						return val;
				}
				else{
					int val = s1.substring(0, s2.length()).compareTo(s2);
					if(val == 0)
						return compare(s1.substring(s2.length()), s2);
					else
						return val;
				}
			}
		});
		if(Integer.parseInt(ss[num.length - 1]) == 0)
			return "0";
		for(int i = num.length - 1; i >= 0; i--)
			result.append(ss[i]);
		return result.toString();
	}
	
	public static void main(String[] args) {
		int[] num = {0, 0};
		System.out.println(new LargestNumber().largestNumber(num));
	}
}