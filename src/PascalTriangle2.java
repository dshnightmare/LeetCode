import java.util.List;
import java.util.ArrayList;

public class PascalTriangle2 {
	public List<Integer> getRow(int rowIndex) {
		rowIndex++;
		List<Integer> cur = new ArrayList<>();
		List<Integer> last = new ArrayList<>();
		cur.add(1);
		for(int i = 1; i < rowIndex; i++){
			List<Integer> ex = last;
			last = cur;
			cur = ex;
			cur.add(1);
			for(int j = 1; j < i; j++){
				cur.set(j, last.get(j - 1) + last.get(j));
			}
			cur.add(1);
		}
		return cur;
	}
	
	public static void main(String[] args) {
		new PascalTriangle2().getRow(3);
	}
}