import java.util.List;
import java.util.ArrayList;

public class TextJustification {
	public List<String> fullJustify(String[] words, int L) {
		int curLen = 0;
		List<String> result = new ArrayList<>();
		List<String> line = new ArrayList<>();
		for(String s : words) {
			// can put the word
			if(curLen + s.length() <= L){
				// include a space
				curLen += (s.length() + 1);
				line.add(s);
			}
			// can't put the word, arrange the last line and start a new line
			else{
				int space = L - (curLen - line.size());
				StringBuilder sb =  new StringBuilder();
				sb.append(line.get(0));
				if(line.size() > 1){
					int n = space / (line.size() - 1), m = space % (line.size() - 1);
					for(int i = 1; i < line.size(); i++) {
						//arrange the space
						for(int j = 0; j < n; j++)
							sb.append(' ');
						if(i <= m)
							sb.append(' ');
						sb.append(line.get(i));
					}
				}
				else{
					for(int i = sb.length(); i < L; i++)
						sb.append(' ');
				}
				result.add(sb.toString());
				
				// start a new line
				curLen = s.length() + 1;
				line.clear();
				line.add(s);
			}
		}
		if(line.size() != 0){
			StringBuilder sb = new StringBuilder();
			sb.append(line.get(0));
			for(int i = 1; i < line.size(); i++){
				sb.append(' ');
				sb.append(line.get(i));
			}
			for(int i = sb.length(); i < L; i++)
				sb.append(' ');
			result.add(sb.toString());
		}
		return result;
	}
	
	public static void main(String[] args) {
		String[] s = {"a","b","c","d","e"};
		List<String> result = new TextJustification().fullJustify(s, 1);
		for(String i : result)
			System.out.println(i);
	}
}