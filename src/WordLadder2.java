import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.List;

public class WordLadder2 {
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		List<List<String>> result = new ArrayList<>();
		HashMap<String, Integer> strings = new HashMap<>();
		ArrayList<String> lstrings = new ArrayList<>();
		ArrayList<Integer>[] neighbors = new ArrayList[dict.size() + 2];
		int istart, iend, z = 0;
		for(String s : dict)
		{
			strings.put(s, z);
			lstrings.add(s);
			z++;
		}
		if(!strings.containsKey(start))
		{
			strings.put(start, z);
			lstrings.add(start);
			istart = z;
			z++;
		}
		else {
			istart = strings.get(start);
		}
		if(!strings.containsKey(end))
		{
			strings.put(end, z);
			lstrings.add(end);
			iend = z;
			z++;
		}
		else {
			iend = strings.get(end);
		}
		
		
		int[] check = new int[strings.size()];
		Queue<Path> curStep = new LinkedList<>();
		Queue<Path> nextStep = new LinkedList<>();
		List<Integer> checks = new ArrayList<>();
		boolean flag = false;
		ArrayList<String> init = new ArrayList<>();
		init.add(start);
		curStep.add(new Path(init, istart));
		check[istart] = 1;
		while (!curStep.isEmpty()) {
			checks.clear();
			while(!curStep.isEmpty()){
				Path tmp = curStep.poll();
				if(neighbors[tmp.last] == null)
					neighbors[tmp.last] = getNeighbors(lstrings.get(tmp.last), strings);
				for (int i : neighbors[tmp.last]) {
					if (check[i] == 0) {
						Path path = new Path(new ArrayList<>(tmp.path), i);
						path.path.add(lstrings.get(i));
						nextStep.add(path);
						checks.add(i);
						if (i == iend){
							flag = true;
							result.add(path.path);
						}
					}
				}
			}
			for(Integer s : checks){
				check[s] = 1;
			}
			if(flag == false)
			{
				Queue<Path> swap = curStep;
				curStep = nextStep;
				nextStep = swap;
			}
		}
		return result;
	}

	public class Path {
		ArrayList<String> path;
		int last;

		public Path(ArrayList<String> _path, int _last) {
			path = _path;
			last = _last;
		}
	}

	private ArrayList<Integer> getNeighbors(String ele, HashMap<String, Integer> dict) {
		ArrayList<Integer> r = new ArrayList<>();
		int length = ele.length();
		for(int i = 0; i < ele.length(); i++)
		{
			for(char j = 'a'; j <= 'z'; j++)
			{
				char[] ctmp = ele.toCharArray();
				ctmp[i] = j;
				String tmp = String.copyValueOf(ctmp);
				if(dict.containsKey(tmp) && !tmp.equals(ele))
					r.add(dict.get(tmp));
			}
		}
		return r;
	}
	
	public static void main(String[] args) {
		
	}
}