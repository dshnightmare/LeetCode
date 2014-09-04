import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 
 */

/**
 * @author dengshihong
 * 
 */
public class WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {
		HashMap<String, Integer> strings = new HashMap<>();
		ArrayList<String> lstrings = new ArrayList<>();
		ArrayList<Integer> neighbors;
		//ArrayList<Integer>[] matrix;
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
		//matrix = new ArrayList[strings.size()];
		int[] check = new int[strings.size()];

//		for(int i = 0; i < strings.size(); i++)
//        {
//        	matrix[i] = new ArrayList<Integer>();
//        }
//		for (int i = 0; i < strings.size(); i++) {
//			for (int j = i + 1; j < strings.size(); j++) {
//				if(distance(strings.get(i), strings.get(j)))
//				{
//					matrix[i].add(j);
//					matrix[j].add(i);
//				}
//			}
//		}
		// for(int i = 0; i < strings.size(); i++)
		// {
		// for(int j = 0; j < strings.size(); j++)
		// {
		// for(int k = 0; k < strings.size(); k++)
		// {
		// if(matrix[i][k] != Integer.MAX_VALUE && matrix[k][j]!=
		// Integer.MAX_VALUE && matrix[i][k] + matrix[k][j] < matrix[i][j])
		// matrix[i][j] = matrix[i][k] + matrix[k][j];
		// }
		// }
		// }

		Queue<Path> queue = new LinkedList<>();
		queue.add(new Path(0, istart));
		check[istart] = 1;
		while (!queue.isEmpty()) {
			Path tmp = queue.poll();
			neighbors = getNeighbors(lstrings.get(tmp.node), strings);
			//neighbors = matrix[tmp.node];
			for (int i : neighbors) {
				if (check[i] == 0) {
					if (i == iend)
						return tmp.length + 2;
					else {
						queue.add(new Path(tmp.length + 1, i));
						check[i] = 1;
					}
				}
			}
		}
		return 0;
	}

	public class Path {
		int length;
		int node;

		public Path(int _length, int _node) {
			length = _length;
			node = _node;
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> dict = new HashSet<>();
		String[] all = { "dose", "ends", "dine", "jars", "prow", "soap",
				"guns", "hops", "cray", "hove", "ella", "hour", "lens", "jive",
				"wiry", "earl", "mara", "part", "flue", "putt", "rory", "bull",
				"york", "ruts", "lily", "vamp", "bask", "peer", "boat", "dens",
				"lyre", "jets", "wide", "rile", "boos", "down", "path", "onyx",
				"mows", "toke", "soto", "dork", "nape", "mans", "loin", "jots",
				"male", "sits", "minn", "sale", "pets", "hugo", "woke", "suds",
				"rugs", "vole", "warp", "mite", "pews", "lips", "pals", "nigh",
				"sulk", "vice", "clod", "iowa", "gibe", "shad", "carl", "huns",
				"coot", "sera", "mils", "rose", "orly", "ford", "void", "time",
				"eloy", "risk", "veep", "reps", "dolt", "hens", "tray", "melt",
				"rung", "rich", "saga", "lust", "yews", "rode", "many", "cods",
				"rape", "last", "tile", "nosy", "take", "nope", "toni", "bank",
				"jock", "jody", "diss", "nips", "bake", "lima", "wore", "kins",
				"cult", "hart", "wuss", "tale", "sing", "lake", "bogy", "wigs",
				"kari", "magi", "bass", "pent", "tost", "fops", "bags", "duns",
				"will", "tart", "drug", "gale", "mold", "disk", "spay", "hows",
				"naps", "puss", "gina", "kara", "zorn", "boll", "cams", "boas",
				"rave", "sets", "lego", "hays", "judy", "chap", "live", "bahs",
				"ohio", "nibs", "cuts", "pups", "data", "kate", "rump", "hews",
				"mary", "stow", "fang", "bolt", "rues", "mesh", "mice", "rise",
				"rant", "dune", "jell", "laws", "jove", "bode", "sung", "nils",
				"vila", "mode", "hued", "cell", "fies", "swat", "wags", "nate",
				"wist", "honk", "goth", "told", "oise", "wail", "tels", "sore",
				"hunk", "mate", "luke", "tore", "bond", "bast", "vows", "ripe",
				"fond", "benz", "firs", "zeds", "wary", "baas", "wins", "pair",
				"tags", "cost", "woes", "buns", "lend", "bops", "code", "eddy",
				"siva", "oops", "toed", "bale", "hutu", "jolt", "rife", "darn",
				"tape", "bold", "cope", "cake", "wisp", "vats", "wave", "hems",
				"bill", "cord", "pert", "type", "kroc", "ucla", "albs", "yoko",
				"silt", "pock", "drub", "puny", "fads", "mull", "pray", "mole",
				"talc", "east", "slay", "jamb", "mill", "dung", "jack", "lynx",
				"nome", "leos", "lade", "sana", "tike", "cali", "toge", "pled",
				"mile", "mass", "leon", "sloe", "lube", "kans", "cory", "burs",
				"race", "toss", "mild", "tops", "maze", "city", "sadr", "bays",
				"poet", "volt", "laze", "gold", "zuni", "shea", "gags", "fist",
				"ping", "pope", "cora", "yaks", "cosy", "foci", "plan", "colo",
				"hume", "yowl", "craw", "pied", "toga", "lobs", "love", "lode",
				"duds", "bled", "juts", "gabs", "fink", "rock", "pant", "wipe",
				"pele", "suez", "nina", "ring", "okra", "warm", "lyle", "gape",
				"bead", "lead", "jane", "oink", "ware", "zibo", "inns", "mope",
				"hang", "made", "fobs", "gamy", "fort", "peak", "gill", "dino",
				"dina", "tier" };
		dict.addAll(Arrays.asList(all));
		System.out.println(new WordLadder()
				.ladderLength("nape", "mild", dict));
	}

}
