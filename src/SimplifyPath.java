import java.util.ArrayList;

public class SimplifyPath {
	public String simplifyPath(String path) {
		ArrayList<String> p = new ArrayList<>();
		String[] dirs = path.split("/+");
		for(int i = 0; i < dirs.length; i++){
			if(dirs[i].equals(".")){
				
			}
			else if(dirs[i].equals("..")){
				if(p.size() > 1)
					p.remove(p.size() - 1);
			}
			else{
				p.add(dirs[i]);
			}
		}
		StringBuilder result = new StringBuilder();
		if(p.size() <= 1)
			result.append("/");
		for(int i = 1; i < p.size(); i++){
			result.append("/");
			result.append(p.get(i));
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(new SimplifyPath().simplifyPath("/"));
	}
}