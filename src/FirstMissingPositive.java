import java.util.HashMap;

public class FirstMissingPositive {
	public int firstMissingPositive(int[] A) {
		HashMap<Integer, Integer> has = new HashMap<>();
		for(int i = 0; i < A.length; i++){
			if(A[i] > 0)
				has.put(A[i], 0);
		}
		for(int i = 1; i < A.length + 2; i++){
			if(!has.containsKey(i))
				return i;
		}
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
