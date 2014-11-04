import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> set[] = new ArrayList[n + 1];
		set[0] = new ArrayList<>();
		set[1] = new ArrayList<>();
		set[1].add("()");
		if(n != 0 && n != 1)
			generate(n, set);
		return set[n];
	}
	
	private void generate(int n, List<String> set[]){
		List<String> r = new ArrayList<>();
		HashMap<String, Integer> tag = new HashMap<>();
		for(int i = 1; i < n; i++)
		{
			if(set[i] == null)
				generate(i, set);
			if(set[n - i] == null)
				generate(n - i, set);
			for(int j = 0; j < set[i].size(); j++){
				for(int k = 0; k < set[n - i].size(); k++){
					if(!tag.containsKey(set[i].get(j) + set[n - i].get(k)))
					{
						tag.put(set[i].get(j) + set[n - i].get(k), 0);
						r.add(set[i].get(j) + set[n - i].get(k));
					}
				}
			}
		}
		for(int i = 0; i < set[n - 1].size(); i++)
			r.add("(" + set[n - 1].get(i) + ")");
		set[n] = r;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> l = new GenerateParentheses().generateParenthesis(3);
		for (String string : l) {
			System.out.println(string);
		}
	}

}
