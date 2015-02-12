import java.util.List;
import java.util.ArrayList;

public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>();
		int length = 1 << n;
		for(int i = 0; i < length; i++){
			result.add((i ^ (i << 1)) >> 1);
		}
		return result;
	}
	
	public static void main(String[] args) {
		new GrayCode().grayCode(3);
	}
}