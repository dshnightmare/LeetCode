import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String S, String[] L) {
		HashMap<String, Integer> needToFind = new HashMap<>();
		HashMap<String, Integer> notFound;
		List<Integer> result = new ArrayList<>();
		for (String string : L) {
			if(needToFind.containsKey(string))
				needToFind.put(string, needToFind.get(string) + 1);
			else
				needToFind.put(string, 1);
		}
		int lenS = S.length(), lenL = L[0].length(), size = L.length;
		for(int i = 0; i <= lenS - lenL * size; i++){
			notFound = new HashMap<>(needToFind);
			for(int j = 0; j < size; j++){
				Integer num = notFound.get(S.substring(i + j * lenL, i + (j + 1) * lenL));
				if(num == null || num == 0)
					break;
				num--;
				if(num == 0)
					notFound.remove(S.substring(i + j * lenL, i + (j + 1) * lenL));
				else
					notFound.put(S.substring(i + j * lenL, i + (j + 1) * lenL), num);
			}
			if(notFound.size() == 0)
				result.add(i);
		}
		return result;
	}
	
	public List<Integer> findSubstring_2(String S, String[] L) {
		HashMap<String, Integer> needToFind = new HashMap<>();
		HashMap<String, Integer> hasFound;
		List<Integer> result = new ArrayList<>();
		for (String string : L) {
			if(needToFind.containsKey(string))
				needToFind.put(string, needToFind.get(string) + 1);
			else
				needToFind.put(string, 1);
		}
		List<String> ss;
		int lenL = L[0].length();
		int lenS = S.length();
		for(int i = 0; i < lenL; i++){
			ss = new ArrayList<>();
			for(int j = i; j <= (lenS - lenL); j+=lenL){
				ss.add(S.substring(j, j + lenL));
			}
			int count = 0;
			for(int begin = 0, end = 0; end < ss.size(); end++){
				if(needToFind.)
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] L = {"a"};
		List<Integer> r = new SubstringwithConcatenationofAllWords().findSubstring("a", L);
		for (Integer integer : r) {
			System.out.println(integer);
		}
	}

}
